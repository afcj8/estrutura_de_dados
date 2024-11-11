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