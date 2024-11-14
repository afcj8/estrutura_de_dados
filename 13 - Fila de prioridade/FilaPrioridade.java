public class FilaPrioridade {
    private No inicio;
    private No fim;
    public FilaPrioridade() {
        this.inicio = null;
        this.fim = null;
    }
    public void inserir(Object elemento, int prioridade) {
        No novo = new No(elemento, prioridade);
        if (this.inicio == null) {
            this.inicio = novo;
            this.fim = novo;
        } else {
            No atual = this.inicio;
            No anterior = null;
            while (atual != null && atual.getPrioridade() >= prioridade) {
                anterior = atual;
                atual = atual.getProximo();
            }
            if (anterior == null) {
                novo.setProximo(this.inicio);
                this.inicio = novo;
            } else {
                anterior.setProximo(novo);
                novo.setProximo(atual);
            }
            if (atual == null) {
                this.fim = novo;
            }
        }
    }
    public Object desenfileirar() throws FilaPrioridadeException {
        if (this.inicio == null) {
            throw new FilaPrioridadeException("Fila vazia");
        }
        Object elemento = this.inicio.getElemento();
        this.inicio = this.inicio.getProximo();
        if (this.inicio == null) {
            this.fim = null;
        }
        return elemento;
    }
    public Object inicio() throws FilaPrioridadeException {
        if (this.inicio == null) {
            throw new FilaPrioridadeException("Fila vazia");
        }
        return this.inicio.getElemento();
    }
    public boolean vazia() {
        return this.inicio == null;
    }
    public void mostrar() {
        No atual = this.inicio;
        while (atual != null) {
            System.out.println(atual.getElemento() + " - " + atual.getPrioridade());
            atual = atual.getProximo();
        }
    }
}