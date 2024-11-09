# 14. Árvore Binária de Pesquisa

Uma árvore binária de pesquisa é uma estrutura de dados hierárquica, composta por nós organizados de maneira específica para facilitar a busca de informações. Em uma árvore binária de pesquisa, cada nó pode ter até dois filhos, com a propriedade de que o nó à esquerda de um nó "pai" contém valores menores e o nó à direita contém valores maiores. Essa organização permite que operações de busca, inserção e remoção sejam executadas de maneira eficiente.

## 14.1. Estrutura da Árvore Binária de Pesquisa

- **Nó raiz:** o ponto de entrada da árvore.
- **Nós internos:** todos os nós que possuem ao menos um filho.
- **Nós folhas:** nós sem filhos, geralmente localizados nas extremidades da árvore.

## 14.2. Inserção

Para inserir um valor, inicia-se a partir da raiz e compara-se o valor a ser inserido com o valor do nó atual. Se o valor for menor, desloca-se para o filho à esquerda; se for maior, para o filho à direita. Esse processo se repete até encontrar uma posição vazia na árvore, onde o novo valor é inserido como um novo nó.

## 14.3. Remoção

A remoção de um nó na árvore binária de pesquisa depende da quantidade de filhos do nó a ser removido. Existem três cenários principais:

1. **Remoção de um Nó Folha**

Esse é o caso mais simples. O nó é simplesmente removido, pois não possui dependências na árvore.

**Exemplo**

```
    10
5        15
            20
```

Após a remoção do nó folha 20:

```
    10
5        15
```

2. **Remoção de um Nó com um Único Filho**

Nesse caso, o nó a ser removido é substituído por seu único filho (esquerdo ou direito), preservando a estrutura da árvore e mantendo a propriedade de ordenação.

**Exemplo**

```
    10
5        15
            20
                25
```

Após a remoção do nó folha 20:

```
    10
5        15
            20
```

3. **Remoção de um Nó com Dois Filhos**

O processo de remoção exige um ajuste na estrutura para preservar a ordem. Nesse caso, o nó removido é substituído pelo seu sucessor imediato, que é o menor valor da subárvore direita. Esse sucessor representa o menor valor maior do que o nó removido, garantindo a continuidade da ordem.

Após encontrar o sucessor, ele é movido para a posição do nó removido. Em seguida, o sucessor é excluído de sua posição original na subárvore direita. Essa remoção e substituição permitem que a estrutura e as propriedades de uma árvore binária de pesquisa sejam mantidas.

**Exemplo**

```
                10
    5                       20
3       8            15              30
            9   12        17     25
```

Após a remoção do nó 20, que possui dois filhos:


```
                10
    5                       25
3       8            15              30
            9   12        17     
```

Neste exemplo, o nó 25, que é o menor valor na subárvore direita de 20, substitui o nó removido, e a árvore mantém sua estrutura e propriedades de ordem.