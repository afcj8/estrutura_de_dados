# 18. Árvore Rubro-Negra

A árvore rubro-negra é uma estrutura de dados binária de busca balanceada, utilizada para garantir que o tempo de operações como busca, inserção e remoção permaneça eficiente, mesmo no pior caso. Cada nó da árvore contém um valor, uma cor (vermelho ou preto) e referências para os filhos esquerdo e direito, além de uma referência para o pai.

A principal característica da árvore rubro-negra é manter um balanceamento aproximadamente uniforme, de forma que a profundidade de qualquer folha não seja mais do que o dobro da profundidade de outra.

## 18.1. Propriedades

I. Nulos (nós externos ou folhas) são considerados negros.

II. A raiz é sempre negra.

III. Um nó rubro não pode ter um filho rubro (ou seja, nós rubros não podem ser consecutivos).

IV. O caminho de qualquer nó até as folhas descendentes contém o mesmo número de nós negros (propriedade da altura negra).

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

### Caso 1: O pai de 𝑣, 𝑤, é negro

Se o nó 𝑤 (pai de 𝑣) é negro, os critérios III e IV permanecem válidos. Não é necessário realizar nenhuma operação.

**Exemplo**

```
10[N]             
    22[R]
```

Nesse caso, 10 é negro e 22 é rubro. Os critérios permanecem válidos.

### Caso 2: 𝑤 (pai de 𝑣) é rubro, 𝑡 (pai de 𝑤) é negro, e 𝑢 (irmão de 𝑤) é rubro

Se 𝑤 é rubro, 𝑡 é negro e 𝑢 (irmão de 𝑤) também é rubro, a re-coloração resolve a violação:

- Re-colore 𝑡 como rubro.
- Re-colore 𝑤 e 𝑢 como negros.

**Exemplo**

```
        20[N]             
10[R]           22[R]
    15[R]
```

Após a inserção de 15, o critério III é violado porque 10 e 15 são rubros.

**Após a re-coloração**

```
        20[R]             
10[N]           22[N]
    15[R]
```

Agora, todos os critérios são mantidos.

### Caso 3: w (pai de 𝑣) é rubro, 𝑡 (pai de 𝑤) é negro, e 𝑢 (irmão de 𝑤) é negro

Neste cenário, são necessárias rotações para corrigir violações. Há quatro subcasos correspondentes às rotações possíveis, dependendo da posição de 𝑣, 𝑤 e 𝑡:

#### Subcaso 1: Inserção na subárvore esquerda-esquerda

Realiza-se uma rotação simples à direita.

**Exemplo**

```
        30[N]
    20[R]            
10[R]
```

Após a rotação simples à direita:

```
        20[N]             
10[R]           30[R]
```

#### Subcaso 2: Inserção na subárvore esquerda-direita

Realiza-se uma rotação dupla (esquerda no filho, seguida de uma direita no pai).

**Exemplo**

```
        30[N]
10[R]            
    20[R]
```

Após a rotação dupla (esquerda no 10, direita no 30):

```
        20[N]             
10[R]           30[R]
```