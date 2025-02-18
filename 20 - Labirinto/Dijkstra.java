import java.util.*;

public class Dijkstra {
    private int[][] labirinto;
    private int[] inicio;
    private int[] fim;
    private int linhas;
    private int colunas;
    private int[][] distancia;
    private int[][] direcoes = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public Dijkstra(int[][] labirinto, int[] inicio, int[] fim) {
        this.labirinto = labirinto;
        this.inicio = inicio;
        this.fim = fim;
        this.linhas = labirinto.length;
        this.colunas = labirinto[0].length;
        this.distancia = new int[linhas][colunas];
        for (int[] linha : distancia) {
            Arrays.fill(linha, Integer.MAX_VALUE);
        }
    }

    public void encontrarCaminho() {
        PriorityQueue<int[]> fila = new PriorityQueue<>(Comparator.comparingInt(a -> distancia[a[0]][a[1]]));
        distancia[inicio[0]][inicio[1]] = 0;
        fila.add(inicio);

        while (!fila.isEmpty()) {
            int[] atual = fila.poll();
            if (atual[0] == fim[0] && atual[1] == fim[1]) {
                System.out.println("Caminho encontrado pelo Dijkstra.");
                return;
            }

            for (int[] direcao : direcoes) {
                int novaLinha = atual[0] + direcao[0];
                int novaColuna = atual[1] + direcao[1];

                if (novaLinha >= 0 && novaLinha < linhas && novaColuna >= 0 && novaColuna < colunas && labirinto[novaLinha][novaColuna] != 1) {
                    int novaDistancia = distancia[atual[0]][atual[1]] + 1;
                    if (novaDistancia < distancia[novaLinha][novaColuna]) {
                        distancia[novaLinha][novaColuna] = novaDistancia;
                        fila.add(new int[]{novaLinha, novaColuna});
                    }
                }
            }
        }

        System.out.println("Caminho não encontrado pelo Dijkstra.");
    }
}