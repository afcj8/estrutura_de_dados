import java.util.*;

public class Dijkstra {
    private int[][] labirinto;  // Matriz representando o labirinto
    private int[] inicio;       // Posição inicial [linha, coluna]
    private int[] fim;          // Posição final [linha, coluna]
    private int linhas;         // Número de linhas do labirinto
    private int colunas;        // Número de colunas do labirinto
    private int[][] distancia;  // Matriz de distâncias mínimas
    private int[][] direcoes = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Movimentos possíveis (cima, baixo, esquerda, direita)

    public Dijkstra(int[][] labirinto, int[] inicio, int[] fim) {
        this.labirinto = labirinto;
        this.inicio = inicio;
        this.fim = fim;
        this.linhas = labirinto.length;
        this.colunas = labirinto[0].length;
        this.distancia = new int[linhas][colunas];

        // Inicializa todas as distâncias como infinito
        for (int[] linha : distancia) {
            Arrays.fill(linha, Integer.MAX_VALUE);
        }
    }

    public void encontrarCaminho() {
        // Fila de prioridade para processar os nós em ordem crescente de distância
        PriorityQueue<int[]> fila = new PriorityQueue<>(Comparator.comparingInt(a -> distancia[a[0]][a[1]]));

        distancia[inicio[0]][inicio[1]] = 0; // Distância da origem é 0
        fila.add(inicio); // Adiciona a posição inicial na fila

        while (!fila.isEmpty()) {
            int[] atual = fila.poll(); // Remove o nó com a menor distância conhecida

            // Se chegou ao destino, encerra a busca
            if (atual[0] == fim[0] && atual[1] == fim[1]) {
                System.out.println("Caminho encontrado pelo Dijkstra.");
                return;
            }

            // Explora os vizinhos (cima, baixo, esquerda, direita)
            for (int[] direcao : direcoes) {
                int novaLinha = atual[0] + direcao[0];
                int novaColuna = atual[1] + direcao[1];

                // Verifica se está dentro dos limites e não é uma parede
                if (novaLinha >= 0 && novaLinha < linhas && novaColuna >= 0 && novaColuna < colunas && labirinto[novaLinha][novaColuna] != 1) {
                    int novaDistancia = distancia[atual[0]][atual[1]] + 1; // Custo de movimentação

                    // Se encontrou um caminho mais curto, atualiza a distância e adiciona à fila
                    if (novaDistancia < distancia[novaLinha][novaColuna]) {
                        distancia[novaLinha][novaColuna] = novaDistancia;
                        fila.add(new int[]{novaLinha, novaColuna});
                    }
                }
            }
        }

        System.out.println("Caminho não encontrado pelo Dijkstra."); // Se a fila esvaziar, não há caminho possível
    }
}