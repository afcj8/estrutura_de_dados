import java.util.Iterator;

public class Teste {
    public static void main(String[] args) {
        ArvoreBinariaPesquisa abp = new ArvoreBinariaPesquisa(10);
        Comparador c = new Comparador();
        No noA = abp.incluir(4);
        No noB = abp.incluir(8);
        No noC = abp.incluir(2);
        No noE = abp.incluir(15);
        No noF = abp.incluir(13);
        No noG = abp.incluir(18);
        No noI = abp.incluir(20);
        No noJ = abp.incluir(1);
        
        System.out.println("---------------- Nós ---------------");
        Iterator<No> x = abp.nos();
        while (x.hasNext()) {
            No aux = x.next();
            System.out.print(aux + " ");
        }

        System.out.println();
        System.out.println("------------- Elementos ------------");
        Iterator<No> y = abp.elements();
        while (y.hasNext()) {
            No aux = y.next();
            System.out.print(aux.getElement() + " ");
        }
        System.out.println();
        System.out.println("Profundidade: " + abp.depth(abp.getRaiz()));
        System.out.println("Altura      : " + abp.height(abp.getRaiz()));
        System.out.println();
        abp.mostrar();
        
        abp.remover(4);

        System.out.println("\nApós a remoção: ");
        
        System.out.println();
        abp.mostrar();
    }
}