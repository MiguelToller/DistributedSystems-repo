import threading
import time
import random

barreira = threading.Barrier(4)

def tarefa(nome):

    # Primeira Parte
    print(f"{nome} executando a primeira parte.")
    time.sleep(random.uniform(0.1, 1.0))
    print(f"{nome} terminou a primeira parte.")

    # Espera as threads executarem
    barreira.wait

    # Segunda Parte
    print(f"{nome} executando a segunda parte.")
    time.sleep(random.uniform(0.1, 1.0))
    print(f"{nome} terminou a segunda parte.")

threads = []

for i in range(1, 5):
    t = threading.Thread(target=tarefa, args=(f"Thread {i}",))
    threads.append(t)
    t.start()

for t in threads:
    t.join()

print("Todas as threads concluiram a tarefa!")

