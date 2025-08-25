# Resumo - Sistemas Distribuídos com Exemplos do Dia a Dia

## 🕒 Relógios Físicos
- Baseados no tempo real do hardware (UTC).
- Sofrem com **desvios de clock (clock drift)**:
  - Diferença no ritmo de contagem do tempo entre relógios de diferentes computadores.
- Precisam de sincronização (ex.: **NTP**):
  - Protocolo de rede usado para sincronizar os relógios dos computadores com um relógio de referência confiável.
- **Uso:** coordenação de eventos em tempo real, logs.

---

## ⏳ Relógios Lógicos
- Não medem tempo real, mas ordenam eventos.
- Garantem **ordem causal** entre processos.
- **Exemplos:**
  - **Relógio de Lamport** → ordem parcial:
    - Um relógio lógico que fornece uma ordem parcial dos eventos em sistemas distribuídos, sem depender do tempo físico real.
- **Uso:** consistência de mensagens, ordenação de eventos.

---

## 🔒 Exclusão Mútua
- Garante que apenas **um processo** acesse a região crítica por vez.
- **Propriedades:**
  - Mutual exclusion → apenas 1 processo no recurso.
  - Progress → se recurso livre, algum processo entra.
  - Bounded waiting → nenhum processo espera para sempre.
- **Implementações:**
  - Centralizada (coordenador)
  - Distribuída (Ricart-Agrawala, token ring)
- **Uso:** controle de acesso a recursos compartilhados.

---

## 👑 Eleição
- Algoritmo para escolher um **coordenador/líder**.
- Usado quando o coordenador falha ou precisa ser eleito.
- **Exemplos:**
  - Bully → maior ID vence
  - Ring → eleição circula até restar o maior ID
- **Uso:** tolerância a falhas, coordenação entre processos.
- **Exemplo em aeroporto:** escolher qual torre de controle ou sistema automático coordenará as pistas caso o sistema principal falhe.

---

## 🔄 Sincronismo e Acesso à Seção Crítica
- Garante que múltiplos processos ou threads acessem **uma seção crítica** de forma segura, evitando inconsistências em memória compartilhada.

### Mecanismos em linguagens de programação
- **Java:** `synchronized`  
- **C# e Python:** `lock`  

### Relação com relógios e exclusão mútua
- **Via relógio:**
  - Relógio físico → ajuda a ordenar eventos com base no tempo real.
  - Relógio lógico → garante ordem causal entre eventos, mesmo sem tempo real.
- **Exclusão mútua:**
  - Pode ser implementada usando **locks** (linguagem) ou protocolos distribuídos.
  - Também pode usar **relógios** (ordenar pedidos) ou **algoritmos de eleição** para decidir quem entra na seção crítica.

**Exemplo prático (aeroporto):**
- Apenas um avião pode usar a pista de decolagem → seção crítica.
- Controladores ou sistemas automatizados garantem que **um avião por vez** tenha acesso, utilizando **locks, ordem de eventos (relógios) ou eleição**.

---

## 🛫 Aplicações em Aeroportos

### Relógios Físicos
- Todos os painéis e sistemas usam **UTC** (Coordinated Universal Time).
- Horários de voo e comunicação internacional dependem de sincronização global.

### Relógios Lógicos
- Garantem a **ordem correta dos eventos**, mesmo se o tempo físico estiver ligeiramente errado.
- **Exemplo:** check-in → despacho de bagagem → embarque → decolagem.

### Exclusão Mútua
- A pista de decolagem/pouso é um **recurso crítico**.
- Apenas um avião pode usar a pista por vez.
- Controlada pelos controladores de voo (exclusão mútua centralizada).

### Eleição
- Escolher qual **torre de controle** ou **sistema automático** coordenará as pistas caso o sistema principal falhe.
