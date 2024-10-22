public class Teste {
    public static void main(String[] args) {
        ArvoreAVL avl = new ArvoreAVL(50);
        avl.mostrar();
        NoAVL noA = avl.incluir(90);
        avl.mostrar();
        NoAVL noB = avl.incluir(20);
        avl.mostrar();
        NoAVL noC = avl.incluir(10);
        avl.mostrar();
        NoAVL noD = avl.incluir(40);
        avl.mostrar();
        NoAVL noE = avl.incluir(30);
        avl.mostrar();
        // NoAVL noF = avl.incluir(4);
        // avl.mostrar();
        // NoAVL noG = avl.incluir(3);
        // avl.mostrar();
        // NoAVL noH = avl.incluir(2);
        // avl.mostrar();
        // NoAVL noI = avl.incluir(1);
        // avl.mostrar();
    }
}