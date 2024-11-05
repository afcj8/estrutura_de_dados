public class Teste {
    public static void main(String[] args) {
        ArvoreAVL avl = new ArvoreAVL(30);
        NoAVL noA = avl.incluir(20);
        avl.mostrar();
        NoAVL noB = avl.incluir(50);
        avl.mostrar();
        NoAVL noC = avl.incluir(40);
        avl.mostrar();
        NoAVL noD = avl.incluir(70);
        avl.mostrar();

        NoAVL noE = avl.incluir(10);
        avl.mostrar();
        NoAVL noF = avl.incluir(25);
        avl.mostrar();
        NoAVL noG = avl.incluir(35);
        avl.mostrar();
        NoAVL noH = avl.incluir(60);
        avl.mostrar();
        NoAVL noI = avl.incluir(80);
        avl.mostrar();

        System.out.println("Removendo o 40");
        avl.remover(40);
        avl.mostrar();

        System.out.println("Removendo o 25");
        avl.remover(25);
        avl.mostrar();

        System.out.println("Removendo o 50");
        avl.remover(50);
        avl.mostrar();

        System.out.println("Removendo o 10");
        avl.remover(10);
        avl.mostrar();

        System.out.println("Removendo o 35");
        avl.remover(35);
        avl.mostrar();

        System.out.println("Removendo o 30");
        avl.remover(30);
        avl.mostrar();

        System.out.println("Removendo o 20");
        avl.remover(20);
        avl.mostrar();

        System.out.println("Removendo o 80");
        avl.remover(70);
        avl.mostrar();

        System.out.println("Removendo o 60");
        avl.remover(60);
        avl.mostrar();
    }
}