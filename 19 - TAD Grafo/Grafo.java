import java.util.ArrayList;

public class Grafo {
    private ArrayList<Vertice> vertices;
    private ArrayList<Aresta> arestas;

    public Grafo() {
        vertices = new ArrayList<Vertice>();
        arestas = new ArrayList<Aresta>();
    }

    public Vertice inserirVertice(Object v) {
        Vertice vertice = new Vertice(v);
        this.vertices.add(vertice);
        return vertice;
    }

    public Aresta inserirAresta(Vertice inicio, Vertice fim, Object a) {
        Aresta aresta = new Aresta(a, inicio, fim);
        inicio.setAresta(aresta);
        fim.setAresta(aresta);
        arestas.add(aresta);
        return aresta;
    }

    public Object removeVertice(Vertice v) {
        if (!vertices.contains(v)) {
            throw new IllegalArgumentException("Vértice não encontrado");
        }

        vertices.remove(v);
        ArrayList<Aresta> arestasRemover = new ArrayList<Aresta>();

        for (Aresta a : v.getArestas()) {
            arestasRemover.add(a);
            Vertice vert = (v == a.getInicio() ? a.getFim() : a.getInicio());
            vert.removerAresta(a);
        }

        for (Aresta remover : arestasRemover) {
            arestas.remove(remover);
        }

        return v.getVertice();
    }

    public Object removeAresta(Aresta a) {
        if (a == null) {
            throw new IllegalArgumentException("Aresta não pode ser nula!");
        }
        arestas.remove(a);
        Vertice inicio = (Vertice)a.getInicio();
        Vertice fim = (Vertice)a.getFim();

        inicio.getArestas().remove(a);
        fim.getArestas().remove(a);

        return a.getAresta();
    }

    public Vertice oposto(Vertice v, Aresta a) {
        if (!a.getInicio().equals(v) && !a.getFim().equals(v)) {
            throw new IllegalArgumentException("Aresta não é incidente ao vértice");
        }
        return a.getInicio().equals(v) ? a.getFim() : a.getInicio();
    }

    public boolean ehAdjacente(Vertice v, Vertice w) {
        int x = this.vertices.indexOf(v);
        int z = this.vertices.indexOf(w);
        if (x == -1 || z == -1) {
            return false;
        } else {
            for (Aresta aresta : this.arestas) {
                if ((aresta.getInicio().equals(v) && aresta.getFim().equals(w)) ||
                        (aresta.getInicio().equals(w) && aresta.getFim().equals(v))) {
                    return true;
                }
            }
            return false;
        }
    }

    public void subsVertice(Vertice v, Object obj) { 
        v.setVertice(obj);
    }

    public void subsAresta(Aresta a, Object obj) {
        a.setAresta(obj);
    }

    public ArrayList<Vertice> finalVertices(Aresta a) {
        ArrayList<Vertice> verticesFinais = new ArrayList<>();
        verticesFinais.add(a.getInicio());
        verticesFinais.add(a.getFim());
        return verticesFinais;
    }

    public ArrayList<Aresta> arestasIncidentes(Vertice v) { 
        if (!vertices.contains(v)) {
            return new ArrayList<>();
        }

        ArrayList<Aresta> incidentes = new ArrayList<>();
        for (Aresta a : this.arestas) {
            if (a.getInicio().equals(v) || a.getFim().equals(v)) {
                incidentes.add(a);
            }
        }
        return incidentes;
    }

    public ArrayList<Vertice> vertices() {
        return this.vertices;
    }

    public ArrayList<Aresta> arestas() {
        return this.arestas;
    }

    public boolean ehDirecionada(Aresta a) {
        for (Aresta aresta : this.arestas) {
            if (a.getInicio().equals(aresta.getFim()) && a.getFim().equals(aresta.getInicio())) {
                return false;
            }
        }
        return true;
    }

    public Aresta inserirArestaDirecionada(Vertice inicio, Vertice fim, Object a) {
        Aresta aresta = new Aresta(a, inicio, fim);
        inicio.setAresta(aresta);
        fim.setAresta(aresta);
        arestas.add(aresta);
        return aresta;
    }

    public void imprimirListaAdjacencia() {
        for (Vertice vertice : vertices) {
            System.out.print(vertice.getVertice() + " -> ");
            ArrayList<Vertice> sucessores = new ArrayList<>();
            
            for (Aresta aresta : vertice.getArestas()) {
                if (aresta.getInicio().equals(vertice)) {
                    sucessores.add(aresta.getFim());
                }
            }
            
            if (sucessores.isEmpty()) {
                System.out.println("Nenhum sucessor");
            } else {
                for (int i = 0; i < sucessores.size(); i++) {
                    System.out.print(sucessores.get(i).getVertice());
                    if (i < sucessores.size() - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println();
            }
        }
    }
}
