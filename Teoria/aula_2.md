# Resumo - Sistemas Distribuídos com Exemplos do Dia a Dia

## 🕒 Relógios Físicos
- Baseados no tempo real do hardware (UTC).
- Sofrem com desvios de clock (clock drift).
- Precisam de sincronização (ex.: NTP).
- Uso: coordenação de eventos em tempo real, logs.

---

## ⏳ Relógios Lógicos
- Não medem tempo real, mas ordenam eventos.
- Garantem **ordem causal** entre processos.
- Exemplos:
  - Relógio de Lamport → ordem parcial.
  - Relógio Vetorial → ordem causal mais precisa.
- Uso: consistência de mensagens, ordenação de eventos.

---

## 🔒 Exclusão Mútua
- Garante que apenas **um processo** acesse a região crítica por vez.
- Propriedades:
  1. Mutual exclusion → apenas 1 processo no recurso.
  2. Progress → se recurso livre, algum processo entra.
  3. Bounded waiting → nenhum processo espera para sempre.
- Implementações:
  - Centralizada (coordenador).
  - Distribuída (Ricart-Agrawala, token ring).
- Uso: controle de acesso a recursos compartilhados.

---

## 👑 Eleição
- Algoritmo para escolher um **coordenador/líder**.
- Usado quando o coordenador falha ou precisa ser eleito.
- Exemplos:
  - Bully → maior ID vence.
  - Ring → eleição circula até restar o maior ID.
- Uso: tolerância a falhas, coordenação entre processos.

---

## 📊 Diferenças Resumidas

| Conceito          | O que é                                    | Foco principal          |
|-------------------|--------------------------------------------|-------------------------|
| Relógios Físicos  | Tempo real de hardware                     | Sincronização temporal  |
| Relógios Lógicos  | Ordem de eventos (sem tempo real)          | Consistência causal     |
| Exclusão Mútua    | Garantir 1 processo por vez no recurso     | Controle de acesso      |
| Eleição           | Escolher líder/coordenador                 | Coordenação em falhas   |

---

## 🛫 Aplicações em Aeroportos

### Relógios Físicos
- Todos os painéis e sistemas usam **UTC** (Coordinated Universal Time).
- Horários de voo e comunicação internacional dependem de sincronização global.

### Relógios Lógicos
- Garantem a **ordem correta dos eventos**, mesmo se o tempo físico estiver ligeiramente errado.
- Exemplo: check-in → despacho de bagagem → embarque → decolagem.

### Exclusão Mútua
- A pista de decolagem/pouso é um **recurso crítico**.
- Apenas um avião pode usar a pista por vez.
- Controlada pelos controladores de voo (exclusão mútua centralizada).

### Eleição
- Escolher qual **torre de controle** ou **sistema automático** coordenará as pistas caso o sistema principal falhe.
