public class Teste {
    public static void main(String[] argas) {
        ArvoreRN arn = new ArvoreRN(15);
        arn.mostrar();

        // Inserir: 15, 8, 90, 44, 65, 22, 36, 78, 84, 11, 2, 19
        // Remover: 8, 65, 44, 15

        arn.incluir(8);
        arn.mostrar();

        arn.incluir(90);
        arn.mostrar();

        arn.incluir(44);
        arn.mostrar();

        arn.incluir(65);
        arn.mostrar();

        arn.incluir(22);
        arn.mostrar();

        arn.incluir(36);
        arn.mostrar();

        arn.incluir(78);
        arn.mostrar();

        arn.incluir(84);
        arn.mostrar();

        arn.incluir(11);
        arn.mostrar();

        arn.incluir(2);
        arn.mostrar();

        arn.incluir(19);
        arn.mostrar();

        System.out.println("Removendo o 8: ");
        arn.remover(8);
        arn.mostrar();

        System.out.println("Removendo o 65: ");
        arn.remover(65);
        arn.mostrar();

        System.out.println("Removendo o 44: ");
        arn.remover(44);
        arn.mostrar();

        System.out.println("Removendo o 15: ");
        arn.remover(15);
        arn.mostrar();

        // ---------- Remoção de um nó folha -----------
    
        // arn.incluir(5);
        // arn.mostrar();

        // arn.incluir(15);
        // arn.mostrar();

        // arn.incluir(20);
        // arn.mostrar();

        // System.out.println("Removendo o 20: ");
        // arn.remover(20);
        // arn.mostrar();

        // ------- Remoção de um nó com 1 filho --------

        // arn.incluir(5);
        // arn.mostrar();

        // arn.incluir(15);
        // arn.mostrar();

        // arn.incluir(8);
        // arn.mostrar();

        // System.out.println("Removendo o 5: ");
        // arn.remover(5);
        // arn.mostrar();

        // ------- Remoção de um nó com 2 filhos -------

        // arn.incluir(5);
        // arn.mostrar();

        // arn.incluir(15);
        // arn.mostrar();

        // arn.incluir(12);
        // arn.mostrar();

        // arn.incluir(18);
        // arn.mostrar();

        // System.out.println("Removendo o 15: ");
        // arn.remover(15);
        // arn.mostrar();

        // -------------- Remoção da raiz --------------

        // arn.incluir(5);
        // arn.mostrar();

        // arn.incluir(15);
        // arn.mostrar();

        // arn.incluir(12);
        // arn.mostrar();

        // arn.incluir(18);
        // arn.mostrar();

        // System.out.println("Removendo a raiz (10): ");
        // arn.remover(10);
        // arn.mostrar();

        // --------------------------------------------
        // Remoção de um nó preto com um filho vermelho

        // arn.incluir(5);
        // arn.mostrar();

        // arn.incluir(3);
        // arn.mostrar();

        // arn.incluir(12);
        // arn.mostrar();

        // System.out.println("Removendo o 10: ");
        // arn.remover(10);
        // arn.mostrar();

        // --------------------------------------------
        // Remoção em uma árvore com alta profundidade

        // arn.incluir(5);
        // arn.mostrar();

        // arn.incluir(15);
        // arn.mostrar();

        // arn.incluir(3);
        // arn.mostrar();

        // arn.incluir(12);
        // arn.mostrar();

        // arn.incluir(18);
        // arn.mostrar();

        // arn.incluir(1);
        // arn.mostrar();

        // arn.incluir(4);
        // arn.mostrar();

        // arn.incluir(7);
        // arn.mostrar();

        // arn.incluir(18);
        // arn.mostrar();

        // arn.incluir(20);
        // arn.mostrar();

        // arn.incluir(6);
        // arn.mostrar();

        // arn.incluir(8);
        // arn.mostrar();

        // arn.incluir(32);
        // arn.mostrar();

        // arn.incluir(25);
        // arn.mostrar();

        // System.out.println("Removendo o 15: ");
        // arn.remover(15);
        // arn.mostrar();

        // --------------------------------------------
        // Remoção de todos os nós sequencialmente

        // arn.incluir(5);
        // arn.mostrar();

        // arn.incluir(15);
        // arn.mostrar();

        // arn.incluir(3);
        // arn.mostrar();

        // arn.incluir(7);
        // arn.mostrar();

        // arn.incluir(12);
        // arn.mostrar();

        // arn.incluir(18);
        // arn.mostrar();

        // System.out.println("Removendo o 15: ");
        // arn.remover(15);
        // arn.mostrar();

        // System.out.println("Removendo o 18: ");
        // arn.remover(18);
        // arn.mostrar();

        // System.out.println("Removendo o 12: ");
        // arn.remover(12);
        // arn.mostrar();

        // System.out.println("Removendo o 7: ");
        // arn.remover(7);
        // arn.mostrar();

        // System.out.println("Removendo o 5: ");
        // arn.remover(5);
        // arn.mostrar();

        // System.out.println("Removendo o 3: ");
        // arn.remover(3);
        // arn.mostrar();

        // System.out.println("Removendo o 10: ");
        // arn.remover(10);
        // arn.mostrar();

        // --------------- Inserção RDD -----------------

        // arn.incluir(5);
        // arn.mostrar();
        // arn.incluir(8);
        // arn.mostrar();

        // --------------- Inserção RDE -----------------

        // arn.incluir(15);
        // arn.mostrar();
        // arn.incluir(12);
        // arn.mostrar();

        // ------------ Inserção Crescente --------------

        // arn.incluir(2);
        // arn.mostrar();
        // arn.incluir(3);
        // arn.mostrar();
        // arn.incluir(4);
        // arn.mostrar();
        // arn.incluir(5);
        // arn.mostrar();
        // arn.incluir(6);
        // arn.mostrar();
        // arn.incluir(7);
        // arn.mostrar();
        // arn.incluir(8);
        // arn.mostrar();
        // arn.incluir(9);
        // arn.mostrar();

        // ------------ Inserção decrescente ------------

        // arn.incluir(9);
        // arn.mostrar();
        // arn.incluir(8);
        // arn.mostrar();
        // arn.incluir(7);
        // arn.mostrar();
        // arn.incluir(6);
        // arn.mostrar();
        // arn.incluir(5);
        // arn.mostrar();
        // arn.incluir(4);
        // arn.mostrar();
        // arn.incluir(3);
        // arn.mostrar();
        // arn.incluir(2);
        // arn.mostrar();
    }
}