package fila;

public class Teste {
    public static void main(String[] args) throws FilaVaziaException {
        Fila fila = new Fila(10);
        System.out.println("Está vazia? " + fila.isEmpty());
        System.out.println("Tamanho: " + fila.size());

        System.out.println("Inserindo elementos na fila... \n");
        for (int i = 1; i < 11; i++) {
            fila.enqueue(i * 2);
        }

        System.out.println("Está vazia? " + fila.isEmpty());
        System.out.println("Tamanho: " + fila.size());
        System.out.println("Elemento da vez: " + fila.first() + "\n");

        System.out.println("Removendo um elemento da fila... \n");
        fila.dequeue();

        System.out.println("Está vazia? " + fila.isEmpty());
        System.out.println("Tamanho: " + fila.size());
        System.out.println("Elemento da vez: " + fila.first());
    }
}