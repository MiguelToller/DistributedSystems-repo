# Sistemas Distribuídos

## Sistemas fracamente acoplados - Grid computacional
- Geograficamente distribuidos  
- Hardware e sistema operacional diferentes nas máquinas  
- Esquema de comunicação TCP/IP  
- Programação distribuída  
- *Arquitetura de Sistemas:*  
    - Cliente-Servidor  
    - Ponto-a-Ponto  
- *Comunicação -> troca:*  
    - tolêrancia a falhas  
    - string (mensagem)  
    - objetos (serialiação)  
    - sincronismo (relógio, monitor ou semáforo, exclusão-mútua)  

### Cliente-Servidor 
Vantagens: Manutenção, Escalabilidade  
Desvantagens: Estabilidade do Servidor  

### Ponto-a-Ponto
Vantagens: 
Desvantagens: Manutenção  

### Thread
- Processo (Id, Prioridade)  
- Gestão (getStatus, sleep, pause, resume, *sincronizar*)  

#### Thread Simples
- Sem dependência de dados  
- Mais rápido  
- Thread é classe  
- Interface *Runnable* (Java)

#### Thread Memória Compartilhada
- Com dependência de dados  
- Mais lento  
- Requer Sincronização  
- Thread é uma interface

# Sistemas Paralelos

## Sistemas fortemente acoplados - Cluster computacional
- Geograficamente na mesma localização  
- Hardware e sistema operacional iguais para todas as máquinas  
- Esquema de comunicação via fibra ótica  
- Sistema de nobreak robusto  
- Sistema de backup  
- Programação Paralela  
