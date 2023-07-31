public class Teste {
  public static void main(String[] args) {
        ListaDuplamenteLigada ldl = new ListaDuplamenteLigada();
        System.out.println("Tamanho: " + ldl.tamanho());
        System.out.println("Está vazia? " + ldl.isEmpty());

        for (int i = 0; i < 10; i++) {
            ldl.addFim(i * 2);
        }
        ldl.percorrer();
    
        System.out.println("Adicionando no início...");
        ldl.addInicio(1);
        ldl.percorrer();

        System.out.println("Inserindo após do índice 2...");
        No x = ldl.atRank(2);
        ldl.insertAfter(x, 8);
        ldl.percorrer();

        System.out.println("Inserindo antes do índice 2...");
        ldl.insertBefore(x, 6);
        ldl.percorrer();

        System.out.println("Tamanho: " + ldl.tamanho());
        System.out.println("Está vazia? " + ldl.isEmpty());
    }
}