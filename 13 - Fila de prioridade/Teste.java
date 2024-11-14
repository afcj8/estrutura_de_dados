public class Teste {
    public static void main(String[] args) {
        FilaPrioridade fp = new FilaPrioridade();
        fp.inserir(10);
        fp.inserir(20);
        fp.inserir(30);
        fp.inserir(40);
        fp.inserir(50);
        fp.inserir(60); // prioridade
        fp.inserir(70); // prioridade
        fp.inserir(65); // prioridade
        fp.mostrar();
        fp.inserir(55);
        fp.mostrar();

        System.out.println("Removendo elementos da fila: ");

        fp.remover();
        fp.mostrar();
        fp.remover();
        fp.mostrar();
        fp.remover();
        fp.mostrar();
        fp.remover();
        fp.mostrar();
        fp.remover();
        fp.mostrar();
        fp.remover();
        fp.mostrar();
        fp.remover();
        fp.mostrar();
        fp.remover();
        fp.mostrar();
        fp.remover();
        fp.mostrar();
    }
}