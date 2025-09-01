import threading

def soma_lista(lista, resultado, chave):
    total = sum(lista)
    resultado[chave] = total

numeros = [1, 2, 3, 4, 5]
resultado = {}

t = threading.Thread(target=soma_lista, args=(numeros, resultado, 'soma'))
t.start()
t.join()

print(f"A soma da lista é: {resultado['soma']}")