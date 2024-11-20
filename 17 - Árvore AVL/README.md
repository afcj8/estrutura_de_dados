# 17. Árvore AVL

A árvore AVL é uma árvore binária de pesquisa balanceada, criada para garantir que a altura de suas subárvores permaneça equilibrada após cada operação de inserção ou remoção. O balanceamento é determinado pelo **fator de balanceamento (FB)**, calculado como a diferença entre a altura da subárvore esquerda e a altura da subárvore direita de um nó. Assim:

_FB = Altura Esquerda - Altura Direita_

O fator de balanceamento de uma árvore pode assumir os valores -1, 0 ou 1, indicando, respectivamente, que a subárvore direita é mais alta que a esquerda, que ambas possuem alturas iguais ou que a subárvore esquerda é mais alta que a direita. Quando essa condição é violada, a árvore realiza rotações para restabelecer o balanceamento.

## 17.1. Inserção

Durante a inserção, o elemento é inicialmente colocado na posição apropriada, seguindo as regras da árvore binária de pesquisa. Após a inserção, os fatores de balanceamento dos nós afetados são recalculados. Se algum nó apresentar um fator de balanceamento fora do intervalo permitido (-1, 0, 1), ocorre um desequilíbrio. Nesse caso, uma ou mais rotações são realizadas para corrigir o problema.

As rotações podem ser de quatro tipos:

1. Rotação Simples à Esquerda (desbalanceamento à direita).
2. Rotação Simples à Direita (desbalanceamento à esquerda).
3. Rotação Dupla à Esquerda (direita-esquerda).
4. Rotação Dupla à Direita (esquerda-direita).

### 17.1.1. Rotação Simples à Esquerda

A rotação simples à esquerda é aplicada quando o fator de balanceamento (FB) do nó for menor que -1, e o FB do filho à direita for 0 ou menor.

**Exemplo antes da rotação:**

```
10[-2]
        15[-1]
                20[0]
```

**Exemplo após a rotação:**

```
        15[0]
10[0]           20[0]
```

### 17.1.2. Rotação Simples à Direita

A rotação simples à direits ocorre quando o FB do nó for maior que 1, e o FB do filho à esquerda for 0 ou maior.

**Exemplo antes da rotação:**

```
                20[2]
        15[1]
10[0]
```

**Exemplo após a rotação:**

```
        15[0]
10[0]           20[0]
```