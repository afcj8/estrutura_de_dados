public class Teste {
    public static void main(String[] argas) {
        
        // Inserir: 15, 8, 90, 44, 65, 22, 36, 78, 84, 11, 2, 19
        // Remover: 8, 65, 44, 15
        
        ArvoreRN arn = new ArvoreRN(15);
        arn.mostrar();

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
    }
}
