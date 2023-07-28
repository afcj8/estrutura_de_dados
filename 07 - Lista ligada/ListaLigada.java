public class ListaLigada {
    private No inicio, fim;
    private int tamanho = 0;
    public void add(Object elemento) {
        No item = new No(elemento);
        if (this.tamanho == 0) {
            this.inicio = item;
        } else {
            this.fim.setProximo(item);
        }
        this.fim = item;
        this.tamanho++;
    }
    public void removeInicio() throws ListaLigadaException {
        if (isEmpty()) {
            throw new ListaLigadaException("Lista vazia");
        }
        this.inicio = inicio.getProximo();
        this.tamanho--;
    }
    public Object removeFim() throws ListaLigadaException {
        if (isEmpty()) {
            throw new ListaLigadaException("Lista vazia");
        }
        No fim = this.fim;
        if (tamanho == 1) {
            this.inicio = null;
            this.fim = null;
            this.tamanho--;
            return fim.getElemento();
        }
        No no = this.inicio;
        for (int i = 1; i < this.tamanho - 1; i++) {
            no = no.getProximo();
        }
        no.setProximo(null);
        this.fim = no;
        this.tamanho--;
        return fim.getElemento();
    }
    public Object buscar(int index) throws ListaLigadaException {
        if (index < 0 || index >= tamanho) {
            throw new ListaLigadaException("Índice inválido");
        }
        No no = this.inicio;
        for (int i = 0; i < tamanho; i++) {
            if (i == index) break;
            no = no.getProximo();
        }
        return no.getElemento();
    }
    public int size() {
        return this.tamanho;
    }
    public Object ultimo() {
        return this.fim.getElemento();
    }
    public boolean isEmpty() {
        return this.tamanho == 0;
    }
}