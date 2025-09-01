import threading

def pares():
    for i in range (0, 21, 2):
        print(i)

def impares():
    for i in range (1, 20, 2):
        print(i)

thread_pares = threading.Thread(target=pares)
thread_impares = threading.Thread(target=impares)

thread_pares.start()
thread_impares.start()

thread_pares.join()
thread_impares.join()