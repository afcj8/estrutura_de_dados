public class ListaDuplamenteLigada {
    private No inicio, fim;
    private int tamanho;
    public ListaDuplamenteLigada() {
        inicio = null;
        fim = null;
        tamanho = 0;
    }
    public void addInicio(Object obj) {
        No novo = new No(obj);
        if (inicio == null) {
            this.fim = novo;
        } else {
            inicio.setAnterior(novo);
            novo.setProximo(inicio);
            inicio = novo;
            tamanho++;
        }
    }
    public No addFim(Object obj) {
        No novo = new No(obj);
        if (inicio == null) {
            this.inicio = novo;
        } else {
            fim.setProximo(novo);
            novo.setAnterior(fim);
        }
        fim = novo;
        tamanho++;
        return novo;
    }
    public Object removeInicio() throws ListaException {
        if (inicio == null) {
            throw new ListaException("Lista vazia!");
        }
        Object elemento = inicio.getElemento();
        if (inicio == fim) {
            inicio = null;
            fim = null;
        } else {
            inicio = inicio.getProximo();
            inicio.setAnterior(null);
        }
        tamanho--;
        return elemento;
    }
    public Object removeFim() throws ListaException {
        if (inicio == null) {
            throw new ListaException("Lista vazia!");
        }
        Object elemento = fim.getElemento();
        if (inicio == fim) {
            inicio = null;
            fim = null;
        } else {
            fim = fim.getAnterior();
            fim.setProximo(null);
        }
        tamanho--;
        return elemento;
    }
    public Object insertAfter(No p, Object obj) {
        No q = new No(obj);
        q.setAnterior(p);
        q.setProximo(p.getProximo());
        p.getProximo().setAnterior(q);
        p.setProximo(q);
        tamanho++;
        return q;
    }
    public Object insertBefore(No p, Object obj) {
        No q = new No(obj);
        q.setProximo(p);
        q.setAnterior(p.getAnterior());
        p.getAnterior().setProximo(q);
        p.setAnterior(q);
        tamanho++;
        return q;
    }
    public No atRank(int r) {
        No novo;
        if (r <= (tamanho() / 2)) {
            novo = this.inicio;
            for (int i = 0; i < r; i++) {
                novo = novo.getProximo();
            }
        } else {
            novo = fim.getAnterior();
            for (int i = 0; i < tamanho() - r - 1; i++) {
                novo.getAnterior();
            }
        }
        return novo;
    }
    public No getInicio() {
        return this.inicio;
    }
    public No getFim() {
        return this.fim;
    }
    public void percorrer() {
        No aux = this.inicio;
        System.out.print("{");
        while (aux != null) {
            Object elemento = aux.getElemento();
            System.out.print(elemento + " ");
            aux = aux.getProximo();
        }
        System.out.print("} \n");
    }
    public int tamanho() {
        return tamanho;
    }
    public boolean isEmpty() {
        return tamanho == 0;
    }
}