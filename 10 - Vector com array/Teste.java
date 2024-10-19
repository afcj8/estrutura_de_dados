public class Teste {
  public static void main(String[] args) throws VectorException {
        Vector vector = new Vector(2);
        System.out.println("Está vazio? " + vector.isEmpty());
        System.out.println("tamanho: " + vector.size() + "\n");

        System.out.println("Inserindo elementos... \n");
        vector.insertAtRank(0, 1);
        vector.insertAtRank(1, 2);
        vector.insertAtRank(2, 3);
        vector.insertAtRank(3, "Vector");
        vector.insertAtRank(4, "Java");

        System.out.println("Está vazio? " + vector.isEmpty());
        System.out.println("tamanho: " + vector.size());
        System.out.println("Elemento do índice 1: " + vector.elemAtRank(1) + "\n");

        System.out.println("Substituindo o elemento do índice 1 por 8: \n");
        vector.replaceAtRank(1, 8);

        System.out.println("Está vazio? " + vector.isEmpty());
        System.out.println("tamanho: " + vector.size());
        System.out.println("Elemento do índice 1: " + vector.elemAtRank(1) + "\n");

        System.out.println("Removendo o elemento do índice 1: \n");
        vector.removeAtRank(1);

        System.out.println("Está vazio? " + vector.isEmpty());
        System.out.println("tamanho: " + vector.size());
        System.out.println("Elemento do índice 1: " + vector.elemAtRank(1));
    }
}