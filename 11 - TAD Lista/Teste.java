public class Teste {
    public static void main(String[] args) throws ListaException {
        Lista lista = new Lista();
        System.out.println("Está vazia? " + lista.isEmpty());
        System.out.println("tamanho: " + lista.size() + "\n");

        System.out.println("Inserindo elementos na lista... \n");
        No n1 = lista.insertLast(1);
        No n2 = lista.insertLast(2);
        No n3 = lista.insertLast(3);
        No n4 = lista.insertLast(4);
        No n5 = lista.insertLast(5);

        lista.percorrer();
        System.out.println("Está vazia? " + lista.isEmpty());
        System.out.println("tamanho: " + lista.size() + "\n");

        System.out.println("O primeiro elemento é: " + lista.first().getElemento());
        System.out.println("O primeiro elemento é 1? " + lista.isFirst(n1));
        System.out.println("O último elemento é: " + lista.last().getElemento());
        System.out.println("O último elemento é 5? " + lista.isLast(n5));
        System.out.println("O elemento depois do 1: " + lista.after(n1).getElemento());
        System.out.println("O elemento antes do 5: " + lista.before(n5).getElemento() + "\n");

        System.out.println("Substituindo 1 por 0...");
        lista.replaceElement(n1, 0);
        lista.percorrer();

        System.out.println("\nTrocando de posição o 0 com o 2...");
        lista.swapElements(n1, n2);
        lista.percorrer();

        System.out.println("\nInserindo 5 depois do 2...");
        lista.insertAfter(n1, 5);
        lista.percorrer();

        System.out.println("\nInserindo 1 antes do 2...");
        lista.insertBefore(n1, 1);
        lista.percorrer();

        System.out.println("\nInserindo 8 no início...");
        lista.insertFirst(8);
        lista.percorrer();

        System.out.println("\nRemovendo o 2...");
        lista.remove(n1);
        lista.percorrer();

        System.out.println("\nEstá vazia? " + lista.isEmpty());
        System.out.println("tamanho: " + lista.size());
    }
}