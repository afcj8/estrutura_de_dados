# 17. Árvore AVL

A árvore AVL é uma árvore binária de pesquisa balanceada, criada para garantir que a altura de suas subárvores permaneça equilibrada após cada operação de inserção ou remoção. O balanceamento é determinado pelo **fator de balanceamento (FB)**, calculado como a diferença entre a altura da subárvore esquerda e a altura da subárvore direita de um nó. Assim:

_FB = Altura Esquerda - Altura Direita_

O fator de balanceamento de uma árvore pode assumir os valores -1, 0 ou 1, indicando, respectivamente, que a subárvore direita é mais alta que a esquerda, que ambas possuem alturas iguais ou que a subárvore esquerda é mais alta que a direita. Quando essa condição é violada, a árvore realiza rotações para restabelecer o balanceamento.

## 17.1. Rotações

As rotações têm como objetivo reorganizar os nós da árvore para corrigir o desequilíbrio, mantendo sua propriedade de busca. Existem quatro tipos de rotações possíveis:

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
10[0]   20[0]
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
10[0]   20[0]
```

### 17.1.3. Rotação Dupla à Esquerda

A rotação dupla à esquerda é aplicada quando o FB do nó for menor que -1, e o FB do filho à direita for maior que 0. Nesse caso, realiza-se primeiro uma rotação simples à direita no filho à direita, seguida de uma rotação simples à esquerda no nó desbalanceado.

**Exemplo antes da rotação:**

```
10[-2]
    20[1]
15[0]
```

**Após a rotação simples à direita:**

```
10[-2]
    15[-1]
        20[0]
```

**Após a rotação simples à esquerda:**

```
    15[0]
10[0]   20[0]
```

### 17.1.4. Rotação Dupla à Direita

A rotação dupla à direita ocorre quando o FB do nó for maior que 1, e o FB do filho à esquerda for menor que 0. Nesse caso, realiza-se primeiro uma rotação simples à esquerda no filho à esquerda, seguida de uma rotação simples à direita no nó desbalanceado.

**Exemplo antes da rotação:**

```
    20[2]
10[-1]
    15[0]
```

**Após a rotação simples à esquerda:**

```
        20[2]
    15[1]
10[0]
```

**Após a rotação simples à direita:**

```
    15[0]
10[0]   20[0]
```

## 17.2. Inserção

A inserção em uma árvore AVL segue as mesmas regras de uma árvore binária de pesquisa: o elemento é colocado na posição adequada com base em sua relação de ordem com os outros nós. Após a inserção, o fator de balanceamento (FB) de cada nó no caminho da nova chave até a raiz é atualizado.

Se, ao recalcular os fatores de balanceamento, algum nó apresentar um valor fora do intervalo permitido (-1, 0, 1), considera-se que houve um desequilíbrio. Nesse caso, uma ou mais rotações são realizadas para restaurar o balanceamento da árvore.