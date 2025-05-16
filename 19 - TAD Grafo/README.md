# Principais Métodos do TAD Grafo

- **finalVertices(a):** retorna um array armazenando os vértices finais da aresta a.
- **oposto(v, a):** retorna o vértice oposto de v em a, ou seja, o vértice final da aresta a separada do vértice v. Um erro ocorre se a não é incidente a v.
- **ehAdjacente(v, w):** retorna true se v e w são adjacentes.
- **subsVertice(v, x):** substitui o elemento armazenado no vértice v por x.
- **subsAresta(a, x):** substitui o elemento armazenado na aresta a por x.
- **inserirVertice(o):** insere e retorna um novo vértice armazenando o elemento o.
- **inserirAresta(v, w, o):** insere e retorna uma nova aresta não-dirigida (v, w) armazenando o elemento o.
- **removeVertice(v):** remove o vértice v (e todas as arestas incidentes) e retorna o elemento armazenado em v.
- **removeAresta(a):** remove a aresta a, retornando o elemento armazenado.
- **arestasIncidentes(v):** retorna uma coleção de todas as arestas incidentes sob o vértice v
- **vertices():** retorna uma coleção de todos os vértices do grafo.
- **arestas():** retorna uma coleção de todas as arestas no grafo.
- **ehDirecionada(a):** testa se a aresta é direcionada.
- **inserirArestaDirecionada(v, w, o):** insere uma nova aresta direcionada com origem em v, destino em w e armazenando o elemento o.