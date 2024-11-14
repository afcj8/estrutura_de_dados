# 13. Fila de Prioridade

Uma fila de prioridade é uma estrutura de dados na qual cada elemento possui uma "prioridade" associada. Diferente de uma fila comum, onde os elementos são inseridos no final e removidos do início (seguindo a ordem de chegada), em uma fila de prioridade os elementos são organizados e removidos com base no nível de prioridade. Assim, os itens de maior prioridade são removidos antes dos de menor prioridade, independentemente da ordem de inserção.

## 13.1. Inserção

Ao inserir um novo elemento na fila de prioridade, ele é posicionado antes dos itens com menor prioridade e depois dos itens com prioridades iguais ou maiores. Isso significa que a fila é organizada de modo que o novo elemento não "fura a fila" de prioridades já estabelecidas, mas ainda é colocado em uma posição adequada.

**Exemplo**

- Lista inicial: [10, 20, 30]
- Inserindo o valor 60 com prioridade superior: [60, 10, 20, 30]

Nesse caso, o elemento 60 foi colocado na frente dos demais porque sua prioridade é maior.

## 13.2. Remoção

A remoção na fila de prioridade segue a mesma lógica: o item com maior prioridade é removido primeiro. Caso dois elementos tenham a mesma prioridade, o elemento que foi inserido primeiro é removido antes. Após a remoção do item de maior prioridade, a estrutura se reorganiza para manter o próximo item de maior prioridade na posição inicial.