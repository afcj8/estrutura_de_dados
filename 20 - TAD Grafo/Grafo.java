import java.util.ArrayList;

public class Grafo {
    private ArrayList<Vertice> vertices;
    private ArrayList<Aresta> arestas;

    public Grafo() {
        this.vertices = new ArrayList<>();
        this.arestas = new ArrayList<>();
    }

    public Vertice inserirVertice(Object elemento) {
        Vertice novo = new Vertice(elemento);
        vertices.add(novo);
        return novo;
    }

    public Aresta inserirAresta(Vertice origem, Vertice destino, Object elemento) {
        Aresta aresta = new Aresta(elemento, origem, destino);
        origem.setAresta(aresta);
        destino.setAresta(aresta);
        arestas.add(aresta);
        return aresta;
    }

    public Aresta inserirArestaDirecionada(Vertice origem, Vertice destino, Object elemento) {
        Aresta aresta = new Aresta(elemento, origem, destino);
        origem.setAresta(aresta);
        destino.setAresta(aresta);
        arestas.add(aresta);
        return aresta;
    }

    public Object removeVertice(Vertice v) {
        if (!vertices.contains(v)) {
            throw new IllegalArgumentException("Vértice não encontrado");
        }

        // Remove arestas incidentes
        ArrayList<Aresta> incidentes = new ArrayList<>(v.getArestas());
        for (Aresta a : incidentes) {
            Vertice outro = (a.getInicio() == v) ? a.getFim() : a.getInicio();
            outro.removerAresta(a);
            arestas.remove(a);
        }

        vertices.remove(v);
        return v.getVertice();
    }

    public Object removeAresta(Aresta a) {
        if (a == null) throw new IllegalArgumentException("Aresta não pode ser nula!");
        a.getInicio().removerAresta(a);
        a.getFim().removerAresta(a);
        arestas.remove(a);
        return a.getAresta();
    }

    public Vertice oposto(Vertice v, Aresta a) {
        if (!a.getInicio().equals(v) && !a.getFim().equals(v)) {
            throw new IllegalArgumentException("Aresta não é incidente ao vértice informado.");
        }
        return a.getInicio().equals(v) ? a.getFim() : a.getInicio();
    }

    public boolean ehAdjacente(Vertice v1, Vertice v2) {
        for (Aresta a : arestas) {
            if ((a.getInicio().equals(v1) && a.getFim().equals(v2)) ||
                (a.getInicio().equals(v2) && a.getFim().equals(v1))) {
                return true;
            }
        }
        return false;
    }

    public void subsVertice(Vertice v, Object novoValor) {
        v.setVertice(novoValor);
    }

    public void subsAresta(Aresta a, Object novoValor) {
        a.setAresta(novoValor);
    }

    public ArrayList<Vertice> finalVertices(Aresta a) {
        ArrayList<Vertice> finais = new ArrayList<>();
        finais.add(a.getInicio());
        finais.add(a.getFim());
        return finais;
    }

    public ArrayList<Aresta> arestasIncidentes(Vertice v) {
        ArrayList<Aresta> incidentes = new ArrayList<>();
        for (Aresta a : arestas) {
            if (a.getInicio().equals(v) || a.getFim().equals(v)) {
                incidentes.add(a);
            }
        }
        return incidentes;
    }

    public ArrayList<Vertice> vertices() {
        return vertices;
    }

    public ArrayList<Aresta> arestas() {
        return arestas;
    }

    public boolean ehDirecionada(Aresta a) {
        for (Aresta outra : arestas) {
            if (a.getInicio().equals(outra.getFim()) &&
                a.getFim().equals(outra.getInicio())) {
                return false; // existe uma aresta oposta → grafo não é direcionado
            }
        }
        return true;
    }

    public void imprimirListaAdjacencia() {
        for (Vertice v : vertices) {
            System.out.print(v.getVertice() + " -> ");
            ArrayList<Vertice> adjacentes = new ArrayList<>();
            for (Aresta a : v.getArestas()) {
                if (a.getInicio().equals(v)) {
                    adjacentes.add(a.getFim());
                }
            }

            if (adjacentes.isEmpty()) {
                System.out.println("Nenhum sucessor");
            } else {
                for (int i = 0; i < adjacentes.size(); i++) {
                    System.out.print(adjacentes.get(i).getVertice());
                    if (i < adjacentes.size() - 1) System.out.print(", ");
                }
                System.out.println();
            }
        }
    }
}