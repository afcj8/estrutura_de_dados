public class Teste {
    public static void main(String[] args) {
        ArvoreAVL avl = new ArvoreAVL(10);
        avl.mostrar();
        NoAVL noA = avl.incluir(9);
        avl.mostrar();
        NoAVL noB = avl.incluir(8);
        avl.mostrar();
        NoAVL noC = avl.incluir(7);
        avl.mostrar();
        NoAVL noD = avl.incluir(6);
        avl.mostrar();
        NoAVL noE = avl.incluir(5);
        avl.mostrar();
        NoAVL noF = avl.incluir(4);
        avl.mostrar();
        NoAVL noG = avl.incluir(3);
        avl.mostrar();
        NoAVL noH = avl.incluir(2);
        avl.mostrar();
        NoAVL noI = avl.incluir(1);
        avl.mostrar();

    }
}