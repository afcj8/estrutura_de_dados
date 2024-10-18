public class Teste {
    public static void main(String[] args) {
        ArvoreAVL avl = new ArvoreAVL(3);
        NoAVL noA = avl.incluir(2);
        NoAVL noB = avl.incluir(1);
        avl.mostrar();

        NoAVL noC = avl.incluir(4);
        NoAVL noD = avl.incluir(5);
        avl.mostrar();

        NoAVL noE = avl.incluir(6);
        avl.mostrar();

        NoAVL noF = avl.incluir(7);
        avl.mostrar();
    }
}