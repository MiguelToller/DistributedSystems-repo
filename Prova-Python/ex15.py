import threading
import queue
import time
import random

fila = queue.Queue(maxsize=5)

def produtor():
    for i in range(10):
        item = f"Item {i}"
        fila.put(item)
        print(f"Produtor produziu: {item}")
        time.sleep(random.uniform(0.1, 0.5))

def consumidor():
    for _ in range(10):
        item = fila.get()
        print(f"Consumidor consumiu: {item}")
        time.sleep(random.uniform(0.3, 0.7))
        fila.task_done()

t_produtor = threading.Thread(target=produtor)
t_consumidor = threading.Thread(target=consumidor)

t_produtor.start()
t_consumidor.start()

t_produtor.join()
t_consumidor.join()