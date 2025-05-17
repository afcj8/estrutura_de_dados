# 20. Representação de Grafos

Grafos podem ser representados de diversas formas em estruturas computacionais e matemáticas, sendo as mais comuns a matriz de adjacência, matriz de custo, lista de arestas, lista de adjacência e a matriz de incidência. 

## 20.1. Matriz de Adjacência

Representa um grafo usando uma matriz $A$ de dimensão $nxn$, onde $n$ é o número de vértices. Cada entrada $A_ij$ indica a existência de uma aresta entre os vértices $i$ e $j$.

- Em grafos não direcionados, a matriz é simétrica, pois se há uma aresta entre $V_i$ e $V_j$, então também há entre $V_j$ e $V_i$.
- Em grafos direcionados, o valor de $A_ij$ representa o número de arestas que partem do vértice $V_i$ e chegam ao vértice $V_j$.

**Grafo não direcionado**

| Grafo | Matriz de adjacência |
| ----- | -------------------- |
| <img src="../imgs/grafo_nao_direcionado.png" style="max-height: 60vh;" /> | <img src="../imgs/matriz_adjacencia_grafo_nao_direcionado.png" style="max-height: 60vh;"/> |

**Grafo direcionado**

| Grafo | Matriz de adjacência |
| ----- | -------------------- |
| <img src="../imgs/grafo_direcionado.png" style="max-height: 60vh;" /> | <img src="../imgs/matriz_adjacencia_grafo_direcionado.png" style="max-height: 60vh;"/> |