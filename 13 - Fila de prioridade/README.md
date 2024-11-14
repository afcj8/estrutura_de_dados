# 13. Fila de Prioridade

Uma fila de prioridade é uma estrutura de dados na qual cada elemento possui uma "prioridade" associada. Diferente de uma fila comum, onde os elementos são inseridos no final e removidos do início (seguindo a ordem de chegada), em uma fila de prioridade os elementos são organizados e removidos com base no nível de prioridade. Assim, os itens de maior prioridade são removidos antes dos de menor prioridade, independentemente da ordem de inserção.

## 13.1. Inserção

Ao inserir um elemento em uma fila de prioridade, sua posição é determinada pela prioridade. Quando o novo item tem uma prioridade superior aos já presentes, ele é inserido antes dos elementos de menor prioridade. Caso a prioridade do novo elemento seja mais baixa, ele será posicionado depois dos elementos com prioridade mais alta.

**Exemplo**

- Lista inicial: [10, 20, 30]
- Inserindo o valor 60 com prioridade superior: [60, 10, 20, 30]

Nesse caso, o elemento 60 foi colocado na frente dos demais porque sua prioridade é maior.