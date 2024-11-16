public class Teste {
    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.incluir(5);
        heap.incluir(3);
        heap.incluir(7);
        heap.incluir(1);
        heap.incluir(2);
        heap.mostrar();

        System.out.print("Heap em ordem: ");
        heap.heapOrdem(heap.getRaiz());
        System.out.println();

        System.out.println("Removendo...");
        heap.removeMin();
        heap.mostrar();

        System.out.println("Removendo...");
        heap.removeMin();
        heap.mostrar();

        System.out.println("Removendo...");
        heap.removeMin();
        heap.mostrar();

        System.out.println("Removendo...");
        heap.removeMin();
        heap.mostrar();

        System.out.println("Removendo...");
        heap.removeMin();
        heap.mostrar();

        System.out.println("Removendo...");
        heap.removeMin();
        heap.mostrar();
    }
}