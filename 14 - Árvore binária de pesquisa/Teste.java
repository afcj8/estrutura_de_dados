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
        
        System.out.println("Removendo o 15: ");
        abp.remover(15);
        abp.mostrar();

        System.out.println("Removendo o 8: ");
        abp.remover(8);
        abp.mostrar();

        System.out.println("Removendo o 10: ");
        abp.remover(10);
        abp.mostrar();

        System.out.println("Removendo o 4: ");
        abp.remover(4);
        abp.mostrar();

        System.out.println("Removendo o 2: ");
        abp.remover(2);
        abp.mostrar();

        System.out.println("Removendo o 13: ");
        abp.remover(13);
        abp.mostrar();

        System.out.println("Removendo o 18: ");
        abp.remover(18);
        abp.mostrar();

        System.out.println("Removendo o 20: ");
        abp.remover(20);
        abp.mostrar();

        System.out.println("Removendo o 1: ");
        abp.remover(1);
        abp.mostrar();
    }
}