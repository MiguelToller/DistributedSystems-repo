import datetime, xmlrpc.client
from xmlrpc.server import SimpleXMLRPCServer

def hoje_eh():
	hoje = datetime.datetime.today()
	return xmlrpc.client.DateTime(hoje)

def gerar_email(nome):
   try:
      nomes = nome.split()
      email = nomes[0] + '.' + nomes[-1] + '@ufn.edu.br'
      email = email.lower()
      return email
   except Exception as e:
      print(f'Erro: {e}')
      return None

def retirar_artigos(frase):
    artigos_definidos = ["o", "a", "os", "as"]
    artigos_indefinidos = ["um", "uma", "uns", "umas"]
    artigos = artigos_definidos + artigos_indefinidos
	
    palavras = frase.split()
    palavras_sem_artigos = []
	
    # Retorno / Loop / Condicao
    palavras_sem_artigos = [p for p in palavras if p.lower() not in artigos]
	
    # for p in palavras:
    #     if p.lower() not in artigos:
    #           palavras_sem_artigos.append(p)

    frase_sem_artigos = " ".join(palavras_sem_artigos)
    return frase_sem_artigos
			
servidor = SimpleXMLRPCServer(("10.103.16.19", 8000))
print("Ouvindo a porta 8000...")

servidor.register_function(hoje_eh, "hoje")
servidor.register_function(gerar_email, "gerar_email")
servidor.register_function(retirar_artigos, "retirar_artigos")
servidor.serve_forever()