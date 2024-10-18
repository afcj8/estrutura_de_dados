public class Teste {
    public static void main(String[] args) {
        ArvoreAVL avl = new ArvoreAVL(10);
        avl.incluir(15);
        avl.incluir(20);
        // avl.incluir(25);
        System.out.println(avl.height(avl.getRaiz()));
        System.out.println(avl.fatorBalanceamento(avl.getRaiz()));
        avl.mostrar();
    }
}