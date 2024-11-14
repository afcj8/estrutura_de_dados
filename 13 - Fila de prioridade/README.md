# 13. Fila de Prioridade

Uma fila de prioridade é uma estrutura de dados na qual cada elemento possui uma "prioridade" associada. Diferente de uma fila comum, onde os elementos são inseridos no final e removidos do início (seguindo a ordem de chegada), em uma fila de prioridade os elementos são organizados e removidos com base no nível de prioridade. Assim, os itens de maior prioridade são removidos antes dos de menor prioridade, independentemente da ordem de inserção.

## 13.1. Inserção

Ao inserir um novo elemento na fila de prioridade, ele é posicionado antes dos itens com menor prioridade e depois dos itens com prioridades iguais ou maiores. Isso significa que a fila é organizada de modo que o novo elemento não "fura a fila" de prioridades já estabelecidas, mas ainda é colocado em uma posição adequada.

**Exemplo**

1. Lista inicial: [10, 20, 30]
2. Inserindo 60 com prioridade mais alta:
    - Resultado: [60, 10, 20, 30]

O elemento 60, por ter prioridade mais alta, é inserido no início da fila.

3. Inserindo 65, ainda com prioridade superior:
    - Resultado: [60, 65, 10, 20, 30]

Nesse caso, o elemento 65 se posiciona após o 60 e antes dos demais, mantendo a ordem de prioridade sem furar a fila.

## 13.2. Remoção

A remoção na fila de prioridade segue a mesma lógica: o item com maior prioridade é removido primeiro. Caso dois elementos tenham a mesma prioridade, o elemento que foi inserido primeiro é removido antes. Após a remoção do item de maior prioridade, a estrutura se reorganiza para manter o próximo item de maior prioridade na posição inicial.

**Exemplo**

1. Lista inicial: [60, 65, 10, 20, 30]
2. Após a remoção do primeiro elemento (60):
    - Resultado: [65, 10, 20, 30]

O item com a maior prioridade restante (65) ocupa agora o início da fila, mantendo a estrutura de prioridade intacta.

Esse processo de inserção e remoção assegura que a fila permaneça ordenada de acordo com a prioridade, processando sempre o elemento mais importante antes dos demais, sem que novos itens furem a posição dos elementos já organizados na fila.