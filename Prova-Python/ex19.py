import threading
import time

recurso_a = threading.Lock()
recurso_b = threading.Lock()

# Funcao que gera DeadLock
'''
def acessar_recursos(primeiro, segundo):
    nome = threading.current_thread().name

    print(f"{nome} tentando adquirir {primeiro['nome']}...")
    with primeiro['lock']:
        print(f"{nome} adquiriu {primeiro['nome']}!")
        time.sleep(1)

        print(f"{nome} tentando adquirir {segundo['nome']}...")
        with segundo['lock']:
            print(f"{nome} adquiriu {segundo['nome']}!")

    print(f"{nome} terminou")

res_a = {'lock': recurso_a, 'nome': "Recurso A"}
res_b = {'lock': recurso_b, 'nome': "Recurso B"}
    
t1 = threading.Thread(target=acessar_recursos, args=(res_a, res_b), name="Thread 1")
t2 = threading.Thread(target=acessar_recursos, args=(res_b, res_a), name="Thread 2")
'''

# Funcao Correta, com locks na mesma ordem
def acessar_recursos():
    nome = threading.current_thread().name

    print(f"{nome} tentando adquirir Recurso A...")
    with recurso_a:
        print(f"{nome} adquiriu Recurso A!")
        time.sleep(1)

        print(f"{nome} tentando adquirir Recurso B...")
        with recurso_b:
            print(f"{nome} adquiriu Recurso B!")
            time.sleep(1)

    print(f"{nome} terminou")

t1 = threading.Thread(target=acessar_recursos, name="Thread 1")
t2 = threading.Thread(target=acessar_recursos, name="Thread 2")

t1.start()
t2.start()

t1.join()
t2.join()