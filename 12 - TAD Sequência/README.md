# 12. TAD Sequência

A sequência é uma estrutura de dados que organiza elementos de forma ordenada. Em uma sequência, os elementos são armazenados em posições contíguas ou de fácil acesso, sendo possível realizar operações como inserção, remoção e acesso aos itens por sua posição. Existem diferentes tipos de sequências, como listas, filas e pilhas, sendo que o comportamento e as operações sobre esses tipos variam conforme a estrutura adotada.

## 12.1. Inserção

A inserção consiste em adicionar um novo elemento na sequência. O local onde o elemento será inserido depende do tipo de sequência:

- **Em listas:** pode-se inserir elementos em qualquer posição, seja no início, no meio ou no final da lista.
- **Em filas:** os elementos são inseridos no final da fila.
- **Em pilhas:** os elementos são inseridos no topo da pilha, seguindo a lógica LIFO (Last In, First Out - Último a Entrar, Primeiro a Sair).

## 12.2. Remoção

A remoção de um elemento consiste em eliminar um item da sequência. Dependendo do tipo de sequência, existem diferentes formas de remoção:

1. **Remoção no Início:**

- **Listas:** um elemento é removido da primeira posição. Após a remoção, todos os elementos seguintes são deslocados para preencher a lacuna.
- **Filas:** a remoção ocorre sempre no início da fila, o que segue a lógica FIFO (First In, First Out - Primeiro a Entrar, Primeiro a Sair).
- **Pilhas:** a remoção do topo da pilha é a operação típica, mas é possível usar a pilha como uma sequência e removê-la do início, embora essa operação não seja comum para pilhas.

2. **Remoção no Meio:**

- **Listas:** permite remover um elemento de qualquer posição, seja no meio da sequência ou em qualquer outro lugar. A operação de remoção desloca os elementos após o item removido para fechar a lacuna.
- **Filas** e **Pilhas:** a remoção do meio não é uma operação comum, pois ambas seguem restrições de ordem de acesso e remoção (FIFO e LIFO, respectivamente).

3. **Remoção no Final:**

- **Listas:** é possível remover o último elemento da sequência. Em algumas implementações, essa operação é eficiente, pois o último elemento está facilmente acessível.
- **Filas:** a remoção do final não é realizada, já que a estrutura prioriza a remoção do início.
- **Pilhas:** a remoção do topo é o comportamento típico, o que implica que a remoção do final também é irrelevante na pilha, pois o topo é sempre o último elemento inserido.

Essas operações, quando realizadas de forma eficiente, podem garantir um bom desempenho dependendo da estrutura de dados utilizada. Em algumas sequências, a remoção de um item pode envolver o deslocamento de múltiplos elementos para manter a ordem da sequência, o que pode influenciar o custo de tempo das operações.