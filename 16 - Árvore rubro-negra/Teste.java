public class Teste {
    public static void main(String[] argas) {
        ArvoreRN arn = new ArvoreRN(10);
        arn.mostrar();

        arn.incluir(5);
        arn.mostrar();

        arn.incluir(15);
        arn.mostrar();

        arn.incluir(8);
        arn.mostrar();

        arn.incluir(12);
        arn.mostrar();

        System.out.println("Após a remoção: ");
        arn.remover(10);
        arn.mostrar();

        // ----------------- RDD -------------------

        // arn.incluir(5);
        // arn.mostrar();
        // arn.incluir(8);
        // arn.mostrar();

        // ----------------- RDE -------------------

        // arn.incluir(15);
        // arn.mostrar();
        // arn.incluir(12);
        // arn.mostrar();

        // -------------- Crescente ----------------

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

        // -------------- decrescente --------------

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