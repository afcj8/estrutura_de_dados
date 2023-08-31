import java.util.Iterator;

public class Teste {
    public static void main(String[] args) {
        ArvoreSimples arvore = new ArvoreSimples(1);
        No raiz = arvore.root();
        No noA = arvore.addChild(raiz, 2);
        No noB = arvore.addChild(raiz, 3);
        No noC = arvore.addChild(noA, 4);
        No noD = arvore.addChild(noA, 5);

        System.out.println("============== Árvore ==============");
        System.out.println("Altura             : " + arvore.height(raiz));
        System.out.println("Profundidade       : " + arvore.depth(noB));
        System.out.println("Raiz               : " + arvore.root().element());
        System.out.println("Qtd de de elementos: " + arvore.size());
        System.out.println("Pai do nó C        : " + arvore.parent(noC).element());
        System.out.print("Filhos do nó raiz  : ");
        Iterator<No> filhos = arvore.children(raiz);
        while (filhos.hasNext()) {
            No filho = filhos.next();
            System.out.print(filho.element() + " ");
        }
        System.out.println();
        System.out.println("---------------- Nós ---------------");
        Iterator<No> x = arvore.nos();
        while (x.hasNext()) {
            No aux = x.next();
            System.out.print(aux + " ");
        }

        System.out.println();
        System.out.println("------------- Elementos ------------");
        Iterator<No> y = arvore.elements();
        while (y.hasNext()) {
            No aux = y.next();
            System.out.print(aux.element() + " ");
        }

        System.out.println();
        System.out.println("------------------------------------");
        System.out.println("Trocando elementos de posição:");
        System.out.println("Nó 1: " + noA.element() + " | Nó 2: " + noB.element());
        arvore.swapElements(noA, noB);
        System.out.println("Nó 1: " + noA.element() + " | Nó 2: " + noB.element());

        System.out.println("------------------------------------");
        System.out.println("Substituindo o elemento de de um nó:");
        System.out.println("Nó: " + noD.element());
        arvore.replace(noD, 8);
        System.out.println("Nó: " + noD.element());
    }
}