import java.util.ArrayList;

public class Teste {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        // Inserção de vértices
        Vertice v1 = grafo.inserirVertice("V1");
        Vertice v2 = grafo.inserirVertice("V2");
        Vertice v3 = grafo.inserirVertice("V3");
        Vertice v4 = grafo.inserirVertice("V4");

        // Teste: Inserção de aresta direcionada
        Aresta a10 = grafo.inserirArestaDirecionada(v1, v2, new Aresta("10", v1, v2));
        System.out.println("Aresta direcionada A10 inserida.");

        Aresta a5 = grafo.inserirArestaDirecionada(v1, v3, new Aresta("5", v1, v3));
        System.out.println("Aresta direcionada A5 inserida.");

        Aresta a15 = grafo.inserirArestaDirecionada(v4, v2, new Aresta("15", v4, v2));
        System.out.println("Aresta direcionada A15 inserida.");

        Aresta a30 = grafo.inserirArestaDirecionada(v4, v3, new Aresta("30", v4, v3));
        System.out.println("Aresta direcionada A30 inserida.");

        Aresta a20 = grafo.inserirArestaDirecionada(v2, v4, new Aresta("20", v2, v4));
        System.out.println("Aresta direcionada A20 inserida.");

        // Teste: lista de adjacência
        System.out.println("---- Lista de adjacência ----");
        grafo.imprimirListaAdjacencia();

        // Inserção de arestas
        Aresta a1 = grafo.inserirAresta(v1, v2, new Aresta("A1", v1, v2));
        Aresta a2 = grafo.inserirAresta(v2, v3, new Aresta("A2", v2, v3));
        Aresta a3 = grafo.inserirAresta(v3, v4, new Aresta("A3", v3, v4));
        Aresta a4 = grafo.inserirAresta(v4, v1, new Aresta("A4", v4, v1));

        // Teste: finalVertices
        System.out.println("Vértices finais da aresta A1: " + grafo.finalVertices(a1));

        // Teste: ehAdjacente
        System.out.println("V2 e V4 são adjacentes? " + grafo.ehAdjacente(v2, v4));

        // Teste: oposto
        Vertice oposto = grafo.oposto(v1, a1);
        System.out.println("O oposto de " + v1.getVertice() + " ao longo de " + a1.getAresta() + " é " + oposto.getVertice());

        // Teste: substituição de vértice
        grafo.subsVertice(v3, "V6");
        System.out.println("Vértice V3 substituído por V6.");
        System.out.println("Lista de vértices após substituição:");
        for (Vertice v : grafo.vertices()) {
            System.out.println(v.getVertice());
        }

        // Teste: substituição de aresta
        grafo.subsAresta(a2, "A6");
        System.out.println("Aresta A2 substituída por A6.");
        System.out.println("Lista de arestas após substituição:");
        for (Aresta a : grafo.arestas()) {
            System.out.println(a.getAresta());
        }

        // Teste: arestas incidentes
        ArrayList<Aresta> arestasIncidentes = grafo.arestasIncidentes(v1);
        System.out.println("Arestas incidentes a V1:");
        for (Aresta a : arestasIncidentes) {
            System.out.println(a.getAresta());
        }

        // Teste: ehDirecionada
        System.out.println("A aresta " + a1.getAresta() + " é direcionada? " + grafo.ehDirecionada(a1));

        // Teste: lista de vértices do grafo
        System.out.println("---- Lista de vértices do grafo ----");
        for (Vertice v : grafo.vertices()) {
            System.out.println(v.getVertice());
        }

        // Teste: lista de arestas do grafo
        System.out.println("---- Lista de arestas do grafo -----");
        for (Aresta a : grafo.arestas()) {
            System.out.println(a);
        }

        // Teste: remoção de vértices e arestas
        grafo.removeAresta(a1);
        System.out.println("Aresta A1 removida.");
        grafo.removeVertice(v2);
        System.out.println("Vértice V2 removido.");

        System.out.println("Lista de vértices após remoção:");
        for (Vertice v : grafo.vertices()) {
            System.out.println(v.getVertice());
        }

        System.out.println("Lista de arestas após remoção:");
        for (Aresta a : grafo.arestas()) {
            System.out.println(a.getAresta());
        }
    }
}