import threading
import time

contador = 0
lock = threading.Lock()

def incrementa():
    global contador
    for _ in range (100):
        with lock:
            contador += 1
            print(f"{threading.current_thread().name} = {contador}")
        time.sleep(0.001)

t1 = threading.Thread(target=incrementa, name="Thread 1")
t2 = threading.Thread(target=incrementa, name="Thread 2")

t1.start()
t2.start()

t1.join()
t2.join()