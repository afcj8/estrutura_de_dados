public class FilaPrioridade {
    private No fila;

    public FilaPrioridade() {
        this.fila = null;
    }

    public void inserir(int elemento) {
        No novo = new No(elemento);
        if (fila == null) { // a fila está vazia?
            fila = novo;
        } else {
            if (elemento > 59) { // é prioridade?
                if (fila.getElemento() < 60) { // é a primeira prioridade?
                    novo.setProximo(fila); // insere no início da fila
                    fila = novo;
                } else {
                    No aux = fila;
                    while (aux.getProximo() != null && aux.getProximo().getElemento() > 59) {
                        aux = aux.getProximo();
                    }
                    novo.setProximo(aux.getProximo()); // insere depois da última prioridade
                    aux.setProximo(novo);
                }
            } else { // não é prioridade, então insere no final
                No aux = fila;
                while (aux.getProximo() != null) {
                    aux = aux.getProximo();
                }
                aux.setProximo(novo);
            }
        }
    }

    public int remover() {
        if (this.fila == null) {
            throw new RuntimeException("A fila está vazia!");
        }
        int elemento = this.fila.getElemento();
        this.fila = this.fila.getProximo();
        return elemento;
    }

    public void mostrar() {
        No atual = this.fila;
        if (atual == null) {
            System.out.println("Fila vazia!");
            return;
        }
        System.out.print("[");
        while (atual != null) {
            System.out.print(atual.getElemento());
            atual = atual.getProximo();
            if (atual != null) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}