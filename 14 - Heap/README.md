# 14. Heap

O Heap é uma estrutura de dados baseada em árvore binária, onde os elementos são organizados de forma hierárquica. Existem dois tipos principais de heaps:

1. **Heap Máximo:** O valor de cada nó é maior ou igual ao de seus filhos. O maior elemento está na raiz.
2. **Heap Mínimo:** O valor de cada nó é menor ou igual ao de seus filhos. O menor elemento está na raiz.

O heap é utilizado principalmente em algoritmos como a ordenação por heapsort e na implementação de filas de prioridade.

## 14.1. Inserção

Ao inserir um elemento em um heap, ele é adicionado inicialmente na posição mais à esquerda do último nível disponível para garantir a completude da árvore. Em seguida, ocorre o `upHeap`, um processo de ajuste que move o elemento para cima na árvore caso ele viole a propriedade do heap. O processo continua até que o elemento esteja em uma posição que respeite as regras do heap.

**Exemplo**

Para ilustrar o processo de inserção, considera-se a árvore abaixo e a inserção do valor 2:

```
            3
    5               15
10       8         
```

Após a inserção do valor 2, a heap temporariamente assume o seguinte estado:

```
            3
    5               15
10       8      2   
```

Para manter a propriedade da heap, aplica-se o processo de `upHeap`. Nesse processo, o elemento inserido é comparado com seu pai e trocado, se necessário, até alcançar sua posição ideal:

1. O valor 2 é comparado com seu pai (15) e as posições são ajustadas:

```
            3
    5               2
10       8      15
```

2. O valor 2 continua subindo na estrutura, sendo comparado e trocado com o pai (3), resultando no estado final:

```
            2
    5               3
10       8      15
```

Dessa forma, a propriedade da heap é restabelecida.

## 14.2. Remoção

A remoção no heap ocorre geralmente na raiz, pois ela contém o maior (em um heap máximo) ou o menor (em um heap mínimo) elemento. Após a remoção:

1. Substitui-se o valor da raiz pelo último elemento da árvore (o mais à direita do último nível).
2. Esse elemento é movido para baixo usando o processo de `downHeap` até que a propriedade do heap seja restabelecida.

**Exemplo**

Para ilustrar o processo de remoção, considera-se a árvore abaixo e a remoção do valor 2:

```
            2
    5               3
10       8      15
```

Após a remoção do valor 2, o último elemento da heap (15) substitui o valor 2 no topo, resultando na seguinte estrutura:

```
            15
    5               3
10       8      
```

Para manter a propriedade da heap, aplica-se o processo de `downHeap`. Nesse processo, o elemento que está no topo é comparado com seus filhos e trocado, se necessário, até alcançar sua posição ideal:

1. O valor 15 é comparado com seus filhos (5 e 3). Ele é trocado com o menor dos filhos (3), assumindo a seguinte configuração:

```
            3
    5               15
10       8
```

2. O valor 15 é comparado novamente com seus filhos e trocado, se necessário. Como não há mais violações, a estrutura final é a seguinte:

```
            3
    5               15
10       8
```

Após esses passos, a remoção do elemento foi concluída e a propriedade da heap foi restaurada.