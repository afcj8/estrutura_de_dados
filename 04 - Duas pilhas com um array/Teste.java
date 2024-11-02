public class Teste {
    public static void main(String[] args) throws PilhaVaziaException {
        Pilha pilha = new Pilha(12);
        System.out.println("--------------- Pilha vermelha ---------------");
        System.out.println("Está vazia? " + pilha.isEmptyV());
        System.out.println("tamanho: " + pilha.sizeV() + "\n");

        System.out.println("Inserindo elementos na pilha vermelha... \n");
        for (int i = 0; i < 6; i++) {
            pilha.pushV(i);
        }
        pilha.mostrar();

        System.out.println("--------------- Pilha vermelha ---------------");
        System.out.println("Está vazia? " + pilha.isEmptyV());
        System.out.println("tamanho: " + pilha.sizeV());
        System.out.println("Elemento do topo da pilha: " + pilha.topV() + "\n");

        System.out.println("----------------- Pilha preta ----------------");
        System.out.println("Está vazia? " + pilha.isEmptyP());
        System.out.println("tamanho: " + pilha.sizeP() + "\n");

        System.out.println("Inserindo elementos na pilha preta... \n");
        for (int i = 0; i < 6; i++) {
            pilha.pushP(i * 2);
        }
        pilha.mostrar();

        System.out.println("----------------- Pilha preta ----------------");
        System.out.println("Está vazia? " + pilha.isEmptyP());
        System.out.println("tamanho: " + pilha.sizeP());
        System.out.println("Elemento do topo da pilha: " + pilha.topP() + "\n");

        System.out.println("Removendo o último elemento da pilha vermelha: \n");
        pilha.popV();

        System.out.println("Removendo o último elemento da pilha preta: \n");
        pilha.popP();

        System.out.println("--------------- Pilha vermelha ---------------");
        System.out.println("Está vazia? " + pilha.isEmptyV());
        System.out.println("tamanho: " + pilha.sizeV());
        System.out.println("Elemento do topo da pilha: " + pilha.topV() + "\n");

        System.out.println("----------------- Pilha preta ----------------");
        System.out.println("Está vazia? " + pilha.isEmptyP());
        System.out.println("tamanho: " + pilha.sizeP());
        System.out.println("Elemento do topo da pilha: " + pilha.topP() + "\n");
    }
}