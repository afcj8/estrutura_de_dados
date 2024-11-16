# 14. Heap

O Heap é uma estrutura de dados baseada em árvore binária, onde os elementos são organizados de forma hierárquica. Existem dois tipos principais de heaps:

1. **Heap Máximo:** O valor de cada nó é maior ou igual ao de seus filhos. O maior elemento está na raiz.
2. **Heap Mínimo:** O valor de cada nó é menor ou igual ao de seus filhos. O menor elemento está na raiz.

O heap é utilizado principalmente em algoritmos como a ordenação por heapsort e na implementação de filas de prioridade.

## 14.1. Inserção

Ao inserir um elemento em um heap, ele é adicionado inicialmente na posição mais à esquerda do último nível disponível para garantir a completude da árvore. Em seguida, ocorre o `upHeap`, um processo de ajuste que move o elemento para cima na árvore caso ele viole a propriedade do heap. O processo continua até que o elemento esteja em uma posição que respeite as regras do heap.