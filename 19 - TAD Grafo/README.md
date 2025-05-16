# TAD Grafo

Este TAD (Tipo Abstrato de Dados) implementa um grafo com suporte a arestas direcionadas e não direcionadas, bem como operações fundamentais sobre vértices e arestas.

## Principais Métodos

### 📌 Inserção e Remoção

- **`inserirVertice(Object o)`**  
  Insere e retorna um novo vértice que armazena o elemento `o`.

- **`inserirAresta(Vertice v, Vertice w, Object o)`**  
  Insere e retorna uma nova aresta não direcionada entre os vértices `v` e `w`, armazenando o elemento `o`.

- **`inserirArestaDirecionada(Vertice v, Vertice w, Object o)`**  
  Insere e retorna uma nova aresta direcionada do vértice `v` para `w`, armazenando o elemento `o`.

- **`removeVertice(Vertice v)`**  
  Remove o vértice `v` e todas as arestas incidentes. Retorna o elemento armazenado em `v`.

- **`removeAresta(Aresta a)`**  
  Remove a aresta `a` e retorna o elemento armazenado nela.

---

### 🔄 Substituição

- **`subsVertice(Vertice v, Object x)`**  
  Substitui o elemento armazenado no vértice `v` por `x`.

- **`subsAresta(Aresta a, Object x)`**  
  Substitui o elemento armazenado na aresta `a` por `x`.

---

### 🔎 Consulta

- **`finalVertices(Aresta a)`**  
  Retorna uma lista com os dois vértices finais da aresta `a`.

- **`oposto(Vertice v, Aresta a)`**  
  Retorna o vértice oposto a `v` na aresta `a`. Lança erro se `a` não é incidente a `v`.

- **`ehAdjacente(Vertice v, Vertice w)`**  
  Retorna `true` se os vértices `v` e `w` são adjacentes, ou seja, se existe uma aresta ligando-os.

- **`arestasIncidentes(Vertice v)`**  
  Retorna uma lista de todas as arestas incidentes ao vértice `v`.

- **`vertices()`**  
  Retorna uma lista com todos os vértices do grafo.

- **`arestas()`**  
  Retorna uma lista com todas as arestas do grafo.

- **`ehDirecionada(Aresta a)`**  
  Retorna `true` se a aresta `a` for direcionada, ou seja, se não há aresta oposta entre os mesmos vértices.

---

### 📋 Impressão

- **`imprimirListaAdjacencia()`**  
  Imprime a lista de adjacência do grafo, exibindo os sucessores de cada vértice.