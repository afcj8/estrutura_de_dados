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
        int indexVertice = this.vertices.indexOf(v);

        if (indexVertice == -1) {
            throw new IllegalArgumentException("Vértice não encontrado");
        }

        for (Aresta aresta : this.arestas) {
            if (aresta.equals(a)) {
                Vertice inicio = aresta.getInicio();
                Vertice fim = aresta.getFim();

                if (inicio.equals(v)) {
                    return fim;
                } else if (fim.equals(v)) {
                    return inicio;
                }
            }
        }
        return null;
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
        Aresta aux = new Aresta(obj, a.getInicio(), a.getFim());
        a.setAresta(aux);
    }

    public ArrayList<Vertice> finalVertices(Aresta a) {
        ArrayList<Vertice> verticesFinais = new ArrayList<>();
        verticesFinais.add(a.getInicio());
        verticesFinais.add(a.getFim());
        return verticesFinais;
    }

    public ArrayList<Aresta> arestasIncidentes(Vertice v) { 
        int aux = this.vertices.indexOf(v);

        if (aux == -1) {
            return new ArrayList<>();
        }

        ArrayList<Aresta> arestas = new ArrayList<>();
        for (Aresta a : this.arestas) {
            if (a.getInicio().equals(v) || a.getFim().equals(v)) {
                arestas.add(a);
            }
        }
        return arestas;
    }

    public ArrayList<Vertice> vertices() {
        return this.vertices;
    }

    public ArrayList<Aresta> arestas() {
        return this.arestas;
    }

    public boolean ehDirecionada(Aresta a) {
        Vertice inicio = a.getInicio();
        Vertice fim = a.getFim();

        int indexInicio = this.vertices.indexOf(inicio);
        int indexFim = this.vertices.indexOf(fim);

        if (indexInicio == -1 || indexFim == -1) {
            System.out.println("Vértice não encontrado");
            return false;
        }

        for (Aresta aux : this.arestas) {
            if (a.equals(aux)) {
                Aresta oposta = new Aresta(a.getAresta(), fim, inicio);
                if (!this.arestas.contains(oposta)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Aresta InserirArestaDirecionada(Vertice inicio, Vertice fim, Object a) {
        Aresta aresta = new Aresta(a, inicio, fim);
        inicio.setAresta(aresta);
        fim.setAresta(aresta);
        arestas.add(aresta);
        return aresta;
    }
}