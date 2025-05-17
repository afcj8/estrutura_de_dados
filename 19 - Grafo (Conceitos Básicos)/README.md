# 19. Grafo (Conceitos Básicos)

Um grafo é uma estrutura matemática composta por um conjunto de vértices (ou nós) e um conjunto de arestas que conectam pares de vértices. Formalmente, um grafo pode ser representado como G = (V, A), onde:

- V é o conjunto de vértices;
- A é o conjunto de arestas.

Arestas podem ou não possuir direção, o que define diferentes tipos de grafos.

- **Dígrafo (grafo direcionado):** é um grafo no qual as arestas possuem uma direção, ou seja, cada aresta parte de um vértice e aponta para outro, indicando um sentido único de conexão.

- **Ordem do grafo:** é a quantidade de vértices, ou seja, o tamanho do conjunto V. Nos dois exemplos abaixo, a ordem é 4.

| Grafo simples | Dígrafo |
| ------------- | ------- |
| <img src="../imgs/grafo_simples.png" width="50%" style="max-height: 60vh;"/> | <img src="../imgs/digrafo.png" width="50%" style="max-height: 60vh;"/> |

- **Adjacência:** dois vértices são adjacentes quando existe uma aresta que os conecta. O mesmo vale para duas arestas que incidem sobre um mesmo vértice.

- **Grau de um vértice:** é o número de arestas que incidem sobre ele.

| Grafo         | Observações |
| ------------- | ----------- |
| <img src="../imgs/adjacencia_grau.png" width="50%" style="max-height: 60vh;" /> | - \(v1\) e \(v2\) são vértices adjacentes;<br> - \(a1\) e \(a4\) são arestas adjacentes;<br> - O vértice \(v1\) possui grau igual a 3. |