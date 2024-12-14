# 18. Árvore Rubro-Negra

A árvore rubro-negra é uma estrutura de dados binária de busca balanceada, utilizada para garantir que o tempo de operações como busca, inserção e remoção permaneça eficiente, mesmo no pior caso. Cada nó da árvore contém um valor, uma cor (rubro ou negro) e referências para os filhos esquerdo e direito, além de uma referência para o pai.

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

#### Subcaso 3: Inserção na subárvore direita-direita

Realiza-se uma rotação simples à esquerda.

**Exemplo**

```
10[N]
    20[R]            
        30[R]
```

Após a rotação simples à esquerda:

```
        20[N]             
10[R]           30[R]
```

#### Subcaso 4: Inserção na subárvore direita-esquerda

Realiza-se uma rotação dupla (direita no filho, seguida de uma esquerda no pai).

**Exemplo**

```
10[N]
        30[R]            
    20[R]
```

Após a rotação dupla (direita no 30, esquerda no 10):

```
        20[N]             
10[R]           30[R]
```

### Exemplo: Inserção sequencial dos números de 1 a 8.

1. **Inserção do 1:** O nó 1 é inserido como raiz da árvore e, por regra, é colorido de negro.

```
1[N]
```

2. **Inserção do 2:** O nó 2 é inserido como filho à direita do nó 1 e é colorido de rubro. Nenhuma violação das propriedades da árvore rubro-negra ocorre.

```
1[N]
    2[R]
```

3. **Inserção do 3:** O nó 3 é inserido como filho à direita do nó 2 e é colorido de rubro. Isso causa uma violação da regra que proíbe dois nós rubros consecutivos.

```
1[N]
    2[R]
        3[R]
```

- **Correção:** Realiza-se uma rotação simples à esquerda no nó 1, resultando na seguinte configuração:

```
        2[N]
1[R]            3[R]
```

4. **Inserção do 4:** O nó 4 é inserido como filho à direita do nó 3 e é colorido de rubro. Isso causa uma violação da regra que proíbe dois nós rubros consecutivos.

```
        2[N]
1[R]            3[R]
                        4[R]
```

- **Correção:** Como o nó 1 (tio de 4) é rubro, realiza-se a recoloração: o nó 3 e o nó 1 tornam-se negros, e o nó 2 torna-se rubro. Em seguida, o nó 2, que é a raiz, é recolorido para negro, restaurando as propriedades.

```
        2[N]
1[N]            3[N]
                        4[R]
```

5. **Inserção do 5:** O nó 5 é inserido como filho à direita do nó 4 e é colorido de rubro, causando dois nós rubros consecutivos (4 e 5).

```
        2[N]
1[N]            3[N]
                        4[R]
                                5[R]
```

- **Correção:** Como o tio de 5 (nulo) é negro, realiza-se uma rotação simples à esquerda no nó 3. Após a rotação, o nó 4 torna-se o pai e é recolorido.

```
        2[N]
1[N]            4[N]
            3[R]    5[R]
```

6. **Inserção do 6:** O nó 6 é inserido como filho à direita do nó 5 e é colorido de rubro. Isso causa dois nós rubros consecutivos (5 e 6).

```
        2[N]
1[N]            4[N]
            3[R]    5[R]
                        6[R]
```

- **Correção:** Como o nó 3 (tio de 6) é rubro, realiza-se uma recoloração - o nó 4 torna-se rubro, enquanto os nós 3 e 5 tornam-se negros.

```
        2[N]
1[N]            4[R]
            3[N]    5[N]
                        6[R]
```

7. **Inserção do 7:** O nó 7 é inserido como filho à direita do nó 6 e é colorido de rubro, causando dois nós rubros consecutivos (6 e 7).

```
        2[N]
1[N]            4[R]
            3[N]    5[N]
                        6[R]
                            7[R]
```

- **Correção:** Como o nó 3 (tio de 7) é negro, realiza-se uma rotação simples à esquerda no nó 5. Após a rotação, o nó 6 torna-se pai e é recolorido.

```
        2[N]
1[N]                    4[R]
                3[N]            6[N]
                            5[R]    7[R]
```

8. **Inserção do 8:** O nó 8 é inserido como filho à direita do nó 7 e é colorido de rubro, causando dois nós rubros consecutivos (7 e 8).

```
        2[N]
1[N]                    4[R]
                3[N]            6[N]
                            5[R]    7[R]
                                        8[R]
```

- **Correção:** Como o nó 5 (tio de 8) é rubro, realiza-se a recoloração - o nó 6 torna-se rubro, e os nós 5 e 7 tornam-se negros.

```
        2[N]
1[N]                    4[R]
                3[N]            6[R]
                            5[N]    7[N]
                                        8[R]
```

Isso resulta em dois nós vermelhos consecutivos (4 e 6). Para corrigir, realiza-se uma rotação simples à esquerda no nó 2. Após a rotação e recoloração, a configuração final é:

```
                4[N]
    2[R]                  6[R]
1[N]    3[N]          5[N]    7[N]    
                                  8[R]
```

## 18.3. Remoção

A remoção em uma árvore rubro-negra envolve a análise do nó removido e de seu sucessor, resultando em quatro casos distintos. A seguir, descrevem-se esses casos e os procedimentos para cada um:

1. **Removido rubro e sucessor rubro:** Neste caso, não é necessário realizar nenhuma alteração, pois a propriedade da árvore é mantida.

2. **Removido negro e sucessor rubro:** Para esse cenário, basta pintar o sucessor de negro, mantendo a árvore balanceada.

3. **Removido negro e sucessor negro:** Quando ocorre a remoção de um nó negro e o sucessor também é negro, a propriedade fundamental da árvore rubro-negra — que exige que todos os caminhos até as folhas tenham o mesmo número de nós negros — é violada. Isso gera um "duplo negro", que precisa ser corrigido. Para isso, a análise prossegue com base no nó irmão do removido.

    - **Caso 1:** Se o irmão do nó removido é negro, ambos os filhos do irmão são negros e o pai é negro, deve-se pintar o irmão de rubro e promove o duplo negro para o pai. Este caso não é terminal, ou seja, requer mais ajustes.

    - **Caso 2:** Se o irmão do nó removido é negro, ambos os filhos do irmão são negros e o pai é rubro, simplesmente pinta-se o irmão de rubro e o pai de negro. Esse caso é terminal, pois resolve o desequilíbrio sem mais necessidade de ajustes.

    - **Caso 3:** Se o irmão do nó removido é negro, o pai é de qualquer cor, o filho esquerdo do irmão é rubro e o filho direito é negro, deve-se realizar uma rotação simples à direita no irmão, pintar o irmão de rubro e o filho esquerdo de negro. O duplo negro permanece no mesmo lugar. Este caso sempre leva ao Caso 4.

    - **Caso 4:** Se o irmão do nó removido é negro, o pai e o filho esquerdo do irmão é de qualquer cor e o filho direito é rubro, deve-se realizar uma rotação simples à esquerda no pai, pintar o pai de negro, transferir a cor antiga do pai para o irmão e pintar o filho direito do irmão de negro. Esse caso é terminal, resolvendo o desequilíbrio de maneira definitiva.

Em todos esses casos, as operações realizadas garantem a manutenção das propriedades da árvore rubro-negra, corrigindo eventuais violações e restaurando seu equilíbrio.

### Exemplo: Remover o no C da árvore abaixo

```
                        D[N]
        B[N]                            I[N]
A[N]            C[N]            G[R]            J[N]
                            F[N]    H[N] 
```

O nó `C` é removido, resultando no surgimento de um nó duplo-negro (`DN`) em seu lugar para manter o equilíbrio na altura negra da árvore.

```
                        D[N]
        B[N]                            I[N]
A[N]            DN              G[R]            J[N]
                            F[N]    H[N] 
```

- A remoção promoveu o caso 1:

```
                        D[N]
        B[DN]                           I[N]
A[R]                            G[R]            J[N]
                            F[N]    H[N] 
```

- Agora, será necessário resolver o caso 3:

```
                        D[N]
        B[DN]                           G[N]
A[R]                            F[N]            I[R]
                                            H[N]    J[N]
```

- Por fim, será necessário resolver o caso 4:

```
                                        G[N]
                D[N]                                    I[N]
        B[N]            F[N]                    H[N]            J[N]
A[R]
```