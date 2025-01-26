import java.util.ArrayList;

public class Vertice {
    private Object vertice;
    private ArrayList<Aresta> arestas;

    public Vertice(Object vertice) {
        this.vertice = vertice;
        this.arestas = new ArrayList<Aresta>();
    }
    public Object getVertice() {
        return vertice;
    }

    public ArrayList<Aresta> getArestas() {
        return arestas;
    }

    public void setVertice(Object vertice) {
        this.vertice = vertice;
    }

    public void setAresta(Aresta a) {
        arestas.add(a);
    }

    public void removerAresta(Aresta a) {
        arestas.remove(a);
    }

    @Override
    public String toString() {
        return "Vertice " + vertice + " | Qtd de arestas = " + arestas.size();
    }
}