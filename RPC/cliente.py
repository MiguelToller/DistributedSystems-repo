import xmlrpc.client, datetime

servidor = xmlrpc.client.ServerProxy("http://localhost:8000/")

hoje = servidor.hoje()

# convert the ISO8601 string to a datetime object
data_hora_convertida = datetime.datetime.strptime(hoje.value, "%Y%m%dT%H:%M:%S")
print("Hoje é: %s" % data_hora_convertida.strftime("%d.%m.%Y, %H:%M:%S"))

email = servidor.gerar_email("miguel")
print(f"Email é: {email}")

frase = servidor.retirar_artigos("O professor Zamberlan é um ótimo professor e possui uma experiencia vasta.")
print(f"Frase sem artigo:{frase}")