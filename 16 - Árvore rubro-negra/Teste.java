public class Teste {
    public static void main(String[] argas) {
        ArvoreRN arn = new ArvoreRN(10);
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

        // arn.incluir(12);
        // arn.mostrar();

        // System.out.println("Removendo o 15: ");
        // arn.remover(15);
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
        // Remoção de um nó vermelho com um filho preto

        // arn.incluir(5);
        // arn.mostrar();

        // arn.incluir(15);
        // arn.mostrar();

        // arn.incluir(3);
        // arn.mostrar();

        // arn.incluir(12);
        // arn.mostrar();

        // System.out.println("Removendo o 15: ");
        // arn.remover(15);
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

        arn.incluir(5);
        arn.mostrar();

        arn.incluir(15);
        arn.mostrar();

        arn.incluir(3);
        arn.mostrar();

        arn.incluir(7);
        arn.mostrar();

        arn.incluir(12);
        arn.mostrar();

        arn.incluir(18);
        arn.mostrar();

        System.out.println("Removendo o 15: ");
        arn.remover(15);
        arn.mostrar();

        System.out.println("Removendo o 18: ");
        arn.remover(18);
        arn.mostrar();

        System.out.println("Removendo o 12: ");
        arn.remover(12);
        arn.mostrar();

        System.out.println("Removendo o 7: ");
        arn.remover(7);
        arn.mostrar();

        System.out.println("Removendo o 3: ");
        arn.remover(3);
        arn.mostrar();

        System.out.println("Removendo o 5: ");
        arn.remover(5);
        arn.mostrar();

        System.out.println("Removendo o 10: ");
        arn.remover(10);
        arn.mostrar();

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