public class Teste {
    public static void main(String[] args) {
        ArvoreAVL avl = new ArvoreAVL(10);
        NoAVL noA = avl.incluir(5);
        NoAVL noB = avl.incluir(2);
        avl.mostrar();
    }
}