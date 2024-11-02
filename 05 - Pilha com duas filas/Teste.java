public class Teste {
    public static void main(String[] args) throws FilaVaziaException {
        Pilha pilha = new Pilha();
        System.out.println("Está vazia? " + pilha.isEmpty());
        System.out.println("tamanho: " + pilha.size() + "\n");

        System.out.println("Inserindo elementos... \n");
        for (int i = 1; i < 6; i++) {
            pilha.push(2 * i);
        }

        System.out.println("Está vazia? " + pilha.isEmpty());
        System.out.println("tamanho: " + pilha.size());
        System.out.println("Elemento do topo da pilha: " + pilha.top() + "\n");

        System.out.println("Removendo o elemento do topo: \n");
        pilha.pop();

        System.out.println("Está vazia? " + pilha.isEmpty());
        System.out.println("tamanho: " + pilha.size());
        System.out.println("Elemento do topo da pilha: " + pilha.top());
    }
}