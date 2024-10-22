public class Teste {
    public static void main(String[] args) {
        ArvoreAVL avl = new ArvoreAVL(40);
        NoAVL noA = avl.incluir(20);
        avl.mostrar();
        NoAVL noB = avl.incluir(50);
        avl.mostrar();
        NoAVL noC = avl.incluir(60);
        avl.mostrar();
        // NoAVL noD = avl.incluir(90);
        // avl.mostrar();

        avl.remover(20);
        avl.mostrar();
        // avl.remover(5);
        // avl.mostrar();

        // NoAVL noE = avl.incluir(60);
        // avl.mostrar();
        // NoAVL noF = avl.incluir(40);
        // avl.mostrar();
        // NoAVL noG = avl.incluir(30);
        // avl.mostrar();
        // NoAVL noH = avl.incluir(20);
        // avl.mostrar();
        // NoAVL noI = avl.incluir(10);
        // avl.mostrar();
    }
}