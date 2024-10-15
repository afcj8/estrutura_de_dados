public class Teste {
    public static void main(String[] args) {
        ArvoreAVL avl = new ArvoreAVL(10);
        System.out.println(avl.getRaiz().getElement());
        System.out.println(avl.isRoot(avl.getRaiz()));
        System.out.println(avl.isExternal(avl.getRaiz()));
        System.out.println(avl.isInternal(avl.getRaiz()));
        System.out.println(avl.pesquisar(avl.getRaiz(), 10));
    }
}