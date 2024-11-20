# 17. Árvore AVL

A árvore AVL é uma árvore binária de busca balanceada, criada para garantir que a altura de suas subárvores permaneça equilibrada após cada operação de inserção ou remoção. O balanceamento é determinado pelo **fator de balanceamento (FB)**, calculado como a diferença entre a altura da subárvore esquerda e a altura da subárvore direita de um nó. Assim:

_FB = Altura Esquerda - Altura Direita_

O fator de balanceamento de uma árvore pode assumir os valores -1, 0 ou 1, indicando, respectivamente, que a subárvore direita é mais alta que a esquerda, que ambas possuem alturas iguais ou que a subárvore esquerda é mais alta que a direita. Quando essa condição é violada, a árvore realiza rotações para restabelecer o balanceamento.