import threading
import time

def imprimir_thread(nome, tempo):
    time.sleep(tempo)
    print("Thread " + nome)

t1 = threading.Thread(target=imprimir_thread, args=("1", 1))
t2 = threading.Thread(target=imprimir_thread, args=("2", 2))
t3 = threading.Thread(target=imprimir_thread, args=("3", 3))

t1.start()
t2.start()
t3.start()

t1.join()
t2.join()
t3.join()