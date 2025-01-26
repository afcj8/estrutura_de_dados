import java.util.ArrayList;

public class Teste {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        Vertice v1 = grafo.inserirVertice("V1");
        Vertice v2 = grafo.inserirVertice("V2");
        Vertice v3 = grafo.inserirVertice("V3");
        Vertice v4 = grafo.inserirVertice("V4");

        // Testar inserção de arestas
        Aresta a1 = grafo.inserirAresta(v1, v2, new Aresta("A1", v1, v2));
        Aresta a2 = grafo.inserirAresta(v2, v3, new Aresta("A2", v2, v3));
        Aresta a3 = grafo.inserirAresta(v3, v4, new Aresta("A3", v3, v4));
        Aresta a4 = grafo.inserirAresta(v4, v1, new Aresta("A4", v4, v1));

        System.out.println("Vertices finais da aresta A1: " + grafo.finalVertices(a1));

        System.out.println("V2 e V4 são adjacentes? " + grafo.ehAdjacente(v2, v4));
        System.out.println();


        // Remoção do vértice V2
        //grafo.removeVertice(v2);

        // Remoção da aresta A1
        //grafo.removeAresta(a1);

        // Oposto
        //Vertice oposto = grafo.oposto(v1, a1);
        //System.out.println("O oposto do " + v1 + " ao longo de " + a1 + " é " + oposto);

        // Substituição de vértice
        //grafo.subsVertice(v3, "V6");

        // Substituição de aresta
        //grafo.subsAresta(a2, "A6");

        // Arestas incidentes
        //ArrayList<Aresta> arestasIncidentes = grafo.arestasIncidentes(v1);
        //System.out.println("Arestas incidentes a V1: " + arestasIncidentes);

        // A aresta é direcionada?
        //System.out.println("A aresta " + a2 + " é direcionada? " + grafo.ehDirecionada(a2));

        // Inserção de aresta direcionada
        //Aresta a5 = grafo.InserirArestaDirecionada(v1, v3, new Aresta("A5", v1, v3));

        // Imprime os vértices do grafo
        System.out.println("---- Lista de vértices do grafo ----");
        for (Vertice v : grafo.vertices()) {
            System.out.println(v);
        }

        System.out.println();

        // Imprime as arestas do grafo
        System.out.println("---- Lista de arestas do grafo -----");
        for (Aresta a : grafo.arestas()) {
            System.out.println(a.getAresta());
        }
    }
}