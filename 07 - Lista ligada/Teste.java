public class Teste {
  public static void main(String[] args) throws ListaLigadaException {
        ListaLigada lista = new ListaLigada();
        System.out.println("Está vazia? " + lista.isEmpty());
        System.out.println("Tamanho: " + lista.size() + "\n");

        System.out.println("Inserindo elementos na lista... \n");
        for (int i = 1; i < 11; i++) {
            lista.add(i * 2);
        }

        System.out.println("Está vazia? " + lista.isEmpty());
        System.out.println("Tamanho: " + lista.size());
        System.out.println("Elemento do índice 4: " + lista.buscar(4) + "\n");

        System.out.println("Removendo o elemento do ínicio da lista... \n");
        lista.removeInicio();

        System.out.println("Está vazia? " + lista.isEmpty());
        System.out.println("Tamanho: " + lista.size());
        System.out.println("Elemento do índice 4: " + lista.buscar(4) + "\n");

        System.out.println("Removendo o elemento do final da lista... \n");
        lista.removeFim();

        System.out.println("Está vazia? " + lista.isEmpty());
        System.out.println("Tamanho: " + lista.size());
        System.out.println("Elemento do índice 4: " + lista.buscar(4) + "\n");
    }
}