import TadLista.ListaException;
import TadLista.No;

public class Teste {
    public static void main(String[] args) throws ListaException, Excecao {
        Sequencia s = new Sequencia();
        System.out.println("Está vazia? " + s.isEmpty());
        System.out.println("tamanho: " + s.size() + "\n");

        System.out.println("Inserindo elementos... \n");
        No n1 = s.insertLast(1);
        No n2 = s.insertLast(2);
        No n3 = s.insertLast(3);
        No n4 = s.insertLast(4);
        No n5 = s.insertLast(5);

        s.percorrer();
        System.out.println("Está vazia? " + s.isEmpty());
        System.out.println("tamanho: " + s.size() + "\n");

        System.out.println("O primeiro elemento é: " + s.first().getElemento());
        System.out.println("O primeiro elemento é 1? " + s.isFirst(n1));
        System.out.println("O último elemento é: " + s.last().getElemento());
        System.out.println("O último elemento é 5? " + s.isLast(n5));
        System.out.println("O elemento depois do 1: " + s.after(n1).getElemento());
        System.out.println("O elemento antes do 5: " + s.before(n5).getElemento() + "\n");

        System.out.println("Substituindo 1 por 0...");
        s.replaceElement(n1, 0);
        s.percorrer();

        System.out.println("\nTrocando de posição o 0 com o 2...");
        s.swapElements(n1, n2);
        s.percorrer();

        System.out.println("\nInserindo 5 depois do 2...");
        s.insertAfter(n1, 5);
        s.percorrer();

        System.out.println("\nInserindo 1 antes do 2...");
        s.insertBefore(n1, 1);
        s.percorrer();

        System.out.println("\nInserindo 8 no início... ");
        s.insertFirst(8);
        s.percorrer();

        System.out.println("\nRemovendo o 2...");
        s.remove(n1);
        s.percorrer();

        System.out.println();
        System.out.println("Está vazia? " + s.isEmpty());
        System.out.println("tamanho: " + s.size());
    }
}