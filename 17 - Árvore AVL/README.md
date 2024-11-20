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

**Exemplo:** Inserção sequencial dos números de 1 a 7.

1. **Inserção do 1:** O nó 1 é inserido como raiz. Como não há outros elementos, a árvore permanece balanceada.

```
1[0]
```

2. **Inserção do 2:** O nó 2 é inserido à direita do nó 1. Após a inserção, o fator de balanceamento (FB) do nó 1 torna-se -1, mantendo a árvore balanceada.

```
1[-1]
    2[0]
```

3. **Inserção do 3:** O nó 3 é inserido à direita do nó 2. O FB do nó 2 torna-se -1, e o FB do nó 1 passa para -2, indicando um desbalanceamento.

```
1[-2]
    2[-1]
        3[0]
```

- **Correção:** Realiza-se uma Rotação Simples à Esquerda no nó 1.

```
    2[0]
1[0]   3[0]
```

4. **Inserção do 4:** O nó 4 é inserido à direita do nó 3. Após a inserção, o FB do nó 3 torna-se -1, e o FB do nó 2 passa para -1, mantendo a árvore balanceada.

```
    2[-1]
1[0]    3[-1]
            4[0]
```

5. **Inserção do 5:** O nó 5 é inserido à direita do nó 4. Após a inserção, o FB do nó 4 torna-se -1, o FB do nó 3 passa para -2, indicando um desbalanceamento.

```
    2[-3]
1[0]    3[-2]
            4[-1]
                5[0]
```

- **Correção:** Realiza-se uma Rotação Simples à Esquerda no nó 3.

```
    2[-1]
1[0]       4[0]
        3[0]   5[0]
```

6. **Inserção do 6:** O nó 6 é inserido à direita do nó 5. Após a inserção, o FB do nó 5 torna-se -1, o FB do nó 4 passa para -1, e o FB do nó 2 passa para -2, indicando um desbalanceamento.

```
    2[-2]
1[0]       4[-1]
        3[0]    5[-1]
                    6[0]
```

- **Correção:** Realiza-se uma Rotação Simples à Esquerda no nó 2.

```
            4[0]
    2[0]          5[-1]
1[0]   3[0]             6[0]
```

7. **Inserção do 7:** O nó 7 é inserido à direita do nó 6. O FB do nó 6 torna-se -1, o FB do nó 5 passa para -2, indicando um desbalanceamento.

```
            4[-1]
    2[0]          5[-2]
1[0]   3[0]             6[-1]
                             7[0]
```

- **Correção:** Realiza-se uma Rotação Simples à Esquerda no nó 5.

```
            4[0]
    2[0]          6[0]
1[0]   3[0]   5[0]   7[0]
```

## 17.3. Remoção

Na remoção, o elemento é retirado da árvore seguindo as regras da árvore binária de busca. Após a remoção, os fatores de balanceamento são recalculados e podem causar desequilíbrios. A correção também utiliza rotações, seguindo os mesmos princípios da inserção.