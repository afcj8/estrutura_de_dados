import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        try {
            // Leitura do arquivo .dat
            File file = new File("labirinto.dat");
            Scanner scanner = new Scanner(file);

            // Leitura da matriz do labirinto
            int linhas = 0;
            int colunas = 0;
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                colunas = linha.length();
                linhas++;
            }
            scanner.close();

            // Inicialização da matriz
            int[][] labirinto = new int[linhas][colunas];
            scanner = new Scanner(file);
            int linhaAtual = 0;
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                for (int coluna = 0; coluna < linha.length(); coluna++) {
                    labirinto[linhaAtual][coluna] = Character.getNumericValue(linha.charAt(coluna));
                }
                linhaAtual++;
            }
            scanner.close();

            // Encontrar o ponto de partida (2) e a saída (3)
            int[] inicio = null;
            int[] fim = null;
            for (int i = 0; i < linhas; i++) {
                for (int j = 0; j < colunas; j++) {
                    if (labirinto[i][j] == 2) {
                        inicio = new int[]{i, j};
                    } else if (labirinto[i][j] == 3) {
                        fim = new int[]{i, j};
                    }
                }
            }

            if (inicio == null || fim == null) {
                System.out.println("Ponto de partida ou saída não encontrados.");
                return;
            }

            // Execução do Dijkstra e posteriormente do A*
            long inicioTempoDijkstra = System.nanoTime();
            Dijkstra dijkstra = new Dijkstra(labirinto, inicio, fim);
            dijkstra.encontrarCaminho();
            long fimTempoDijkstra = System.nanoTime();
            System.out.println("Tempo gasto pelo Dijkstra: " + (fimTempoDijkstra - inicioTempoDijkstra) / 1_000_000 + " ms");

            long inicioTempoAEstrela = System.nanoTime();
            AEstrela aEstrela = new AEstrela(labirinto, inicio, fim);
            aEstrela.encontrarCaminho();
            long fimTempoAEstrela = System.nanoTime();
            System.out.println("Tempo gasto pelo A*: " + (fimTempoAEstrela - inicioTempoAEstrela) / 1_000_000 + " ms");

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        }
    }
}