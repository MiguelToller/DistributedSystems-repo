import threading
import time
import random

clock_1 = 0
clock_2 = 0

mensagem_para_2 = None
mensagem_para_1 = None

lista_mensagens = ["Bom dia!", "Boa tarde!", "Boa noite!"]

def processo_1():
    global clock_1, mensagem_para_2, mensagem_para_1
    for i in range(5):

        # Evento local
        clock_1 += 1
        time.sleep(random.uniform(0.1, 0.5))

        # Envia mensagem para Processo 2
        clock_1 += 1
        mensagem = random.choice(lista_mensagens)
        mensagem_para_2 = (mensagem, clock_1)
        print(f"Processo 1 enviou: '{mensagem}', clock = {clock_1}")
        time.sleep(random.uniform(0.2, 0.5))

        # Recebe resposta de Processo 2
        if mensagem_para_1:
            msg, clock = mensagem_para_1
            clock_1 = max(clock_1, clock) + 1
            print(f"Processo 1 recebeu: '{msg}', clock atualizado = {clock_1}")
            mensagem_para_1 = None

def processo_2():
    global clock_2, mensagem_para_1, mensagem_para_2
    for i in range(5):

        # Evento local
        clock_2 += 1
        time.sleep(random.uniform(0.1, 0.5))

        # Recebe mensagem de Processo 1
        if mensagem_para_2:
            msg, clock = mensagem_para_2
            clock_2 = max(clock_2, clock) + 1
            print(f"Processo 2 recebeu: '{msg}', clock atualizado = {clock_2}")

            # Responde
            clock_2 += 1
            resposta = random.choice(lista_mensagens)
            mensagem_para_1 = (resposta, clock_2)
            print(f"Processo 2 respondeu: '{resposta}', clock = {clock_2}")
            mensagem_para_2 = None

    time.sleep(random.uniform(0.2, 0.5))

t1 = threading.Thread(target=processo_1)
t2 = threading.Thread(target=processo_2)

t1.start()
t2.start()

t1.join()
t2.join()