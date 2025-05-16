public class Aresta {
    private Object aresta;
    private Vertice inicio;
    private Vertice fim;

    public Aresta(Object aresta, Vertice inicio, Vertice fim) {
        if (inicio == null || fim == null) {
            throw new IllegalArgumentException("Os vértices não podem ser nulos!");
        }
        this.aresta = aresta;
        this.inicio = inicio;
        this.fim = fim;
    }

    public Object getAresta() {
        return aresta;
    }

    public void setAresta(Object aresta) {
        this.aresta = aresta;
    }

    public Vertice getInicio() {
        return inicio;
    }

    public void setInicio(Vertice inicio) {
        this.inicio = inicio;
    }

    public Vertice getFim() {
        return fim;
    }

    public void setFim(Vertice fim) {
        this.fim = fim;
    }

    @Override
    public String toString() {
        return aresta + " = {" + "inicio = " + inicio.getVertice() + ", fim = " + fim.getVertice() + "}";
    }
}