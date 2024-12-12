# 18. Árvore Rubro-Negra

A árvore rubro-negra é uma estrutura de dados binária de busca balanceada, utilizada para garantir que o tempo de operações como busca, inserção e remoção permaneça eficiente, mesmo no pior caso. Cada nó da árvore contém um valor, uma cor (vermelho ou preto) e referências para os filhos esquerdo e direito, além de uma referência para o pai.

A principal característica da árvore rubro-negra é manter um balanceamento aproximadamente uniforme, de forma que a profundidade de qualquer folha não seja mais do que o dobro da profundidade de outra.

## 18.1. Propriedades

1. Nulos (nós externos ou folhas) são considerados negros.
2. A raiz é sempre negra.
3. Um nó rubro não pode ter um filho rubro (ou seja, nós rubros não podem ser consecutivos).
4. O caminho de qualquer nó até as folhas descendentes contém o mesmo número de nós negros (propriedade da altura negra).

Essas propriedades asseguram que a altura da árvore seja $O(log 𝑛)$, onde 𝑛 é o número de nós.

### 18.1.1. Altura Negra

É representado pelo número de nós negros encontrados até qualquer nó folha descendente.

**Exemplo**

```
            10[N]             
      6[R]          22[N]
3[N]        8[N]
       7[R]     9[R]
         
```

Nesse exemplo a altura negra é 2.

## 18.2. Inserção

Na inserção de um novo nó:

1. O nó é sempre inserido como rubro.
2. Após a inserção, as propriedades da árvore rubro-negra podem ser violadas.
3. Para corrigir essas violações, aplica-se uma série de rotações (simples ou duplas) e/ou recolorações.