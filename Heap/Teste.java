public class Teste {
    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.incluir(5);
        heap.incluir(3);
        heap.incluir(7);
        heap.incluir(1);
        heap.incluir(2);
        heap.mostrar();
        heap.removeMin();
        heap.mostrar();
    }
}