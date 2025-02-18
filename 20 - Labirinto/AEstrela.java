import java.util.*;

public class AEstrela {
    private int[][] labirinto;  // Matriz do labirinto (0 = livre, 1 = parede)
    private int[] inicio;       // Coordenadas [linha, coluna] do início
    private int[] fim;          // Coordenadas [linha, coluna] do destino
    private int linhas;         // Número total de linhas do labirinto
    private int colunas;        // Número total de colunas do labirinto
    private int[][] distancia;  // Matriz de distâncias mínimas
    private int[][] direcoes = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Movimentos possíveis (cima, baixo, esquerda, direita)

    // Construtor recebe o labirinto e os pontos inicial e final
    public AEstrela(int[][] labirinto, int[] inicio, int[] fim) {
        this.labirinto = labirinto;
        this.inicio = inicio;
        this.fim = fim;
        this.linhas = labirinto.length;        // Número de linhas do labirinto
        this.colunas = labirinto[0].length;    // Número de colunas do labirinto
        this.distancia = new int[linhas][colunas]; // Inicializa matriz de distâncias

        // Define todas as distâncias inicialmente como infinito (valor máximo)
        for (int[] linha : distancia) {
            Arrays.fill(linha, Integer.MAX_VALUE);
        }
    }

    // Função heurística: distância de Manhattan até o destino
    private int heuristica(int linha, int coluna) {
        return Math.abs(linha - fim[0]) + Math.abs(coluna - fim[1]);
    }

    // Método para encontrar o menor caminho utilizando A*
    public void encontrarCaminho() {
        // Fila de prioridade ordenada pela soma da distância percorrida + heurística
        PriorityQueue<int[]> fila = new PriorityQueue<>(Comparator.comparingInt(a -> distancia[a[0]][a[1]] + heuristica(a[0], a[1])));

        distancia[inicio[0]][inicio[1]] = 0; // Define a distância inicial como 0
        fila.add(inicio); // Adiciona o ponto inicial à fila

        while (!fila.isEmpty()) { // Enquanto houver elementos na fila
            int[] atual = fila.poll(); // Pega o nó com menor custo estimado

            // Se chegou ao destino, encerra a busca
            if (atual[0] == fim[0] && atual[1] == fim[1]) {
                System.out.println("Caminho encontrado pelo A*.");
                return;
            }

            // Testa todas as direções possíveis
            for (int[] direcao : direcoes) {
                int novaLinha = atual[0] + direcao[0];
                int novaColuna = atual[1] + direcao[1];

                // Verifica se a nova posição está dentro dos limites e não é uma parede
                if (novaLinha >= 0 && novaLinha < linhas && novaColuna >= 0 && novaColuna < colunas && labirinto[novaLinha][novaColuna] != 1) {
                    int novaDistancia = distancia[atual[0]][atual[1]] + 1; // Distância acumulada

                    // Se a nova distância for menor, atualiza e adiciona à fila
                    if (novaDistancia < distancia[novaLinha][novaColuna]) {
                        distancia[novaLinha][novaColuna] = novaDistancia;
                        fila.add(new int[]{novaLinha, novaColuna});
                    }
                }
            }
        }

        // Se a fila esvaziou e não encontrou o destino, não há caminho possível
        System.out.println("Caminho não encontrado pelo A*.");
    }
}