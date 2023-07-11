package pilha;

public class Teste {
    public static void main(String[] args) throws PilhaVaziaException {
        Pilha pilha = new Pilha(10);
        System.out.println("Está vazia? " + pilha.isEmpty());
        System.out.println("tamanho: " + pilha.size());
        pilha.imprimir();

        System.out.println("\nInserindo elementos na pilha...");
        for (int i = 0; i < 10; i++) {
            pilha.push(i);
        }
        pilha.imprimir();

        System.out.println("\nEstá vazia? " + pilha.isEmpty());
        System.out.println("tamanho: " + pilha.size());
        System.out.println("Elemento do topo da pilha: " + pilha.top() + "\n");

        System.out.println("Removendo o elemento do topo da pilha...");
        pilha.pop();
        pilha.imprimir();

        System.out.println("\nEstá vazia? " + pilha.isEmpty());
        System.out.println("tamanho: " + pilha.size());
        System.out.println("Elemento do topo da pilha: " + pilha.top() + "\n");

        System.out.println("Removendo todos os elementos da pilha...");
        pilha.empty();

        System.out.println("\nEstá vazia? " + pilha.isEmpty());
        System.out.println("tamanho: " + pilha.size());
        pilha.imprimir();
    }
}