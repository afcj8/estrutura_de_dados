public class Lista implements ILista {
    private No inicio, fim;
    private int n;
    public Lista() {
        inicio = new No(null);
        fim = new No(null);
        inicio.setProximo(fim);
        fim.setAnterior(inicio);
    }
    public boolean isFirst(No p) throws ListaException {
        if (isEmpty()) {
            throw new ListaException("Lista vazia!");
        }
        return inicio.getProximo().getElemento() == p.getElemento();
    }
    public boolean isLast(No p) throws ListaException {
        if (isEmpty()) {
            throw new ListaException("Lista vazia!");
        }
        return fim.getAnterior().getElemento() == p.getElemento();
    }
    public No first() throws ListaException {
        if (isEmpty()) {
            throw new ListaException("Lista vazia!");
        }
        return inicio.getProximo();
    }
    public No last() throws ListaException {
        if (isEmpty()) {
            throw new ListaException("Lista vazia!");
        }
        return fim.getAnterior();
    }
    public No after(No p) throws ListaException {
        if (isEmpty()) {
            throw new ListaException("Lista vazia!");
        }
        return p.getProximo();
    }
    public No before(No p) throws ListaException {
        if (isEmpty()) {
            throw new ListaException("Lista vazia!");
        }
        return p.getAnterior();
    }
    public Object replaceElement(No p, Object obj) throws ListaException {
        if (isEmpty()) {
            throw new ListaException("Lista vazia!");
        }
        Object temp = p.getElemento();
        p.setElemento(obj);
        return temp;
    }
    public void swapElements(No p, No q) throws ListaException {
        if (isEmpty()) {
            throw new ListaException("Lista vazia!");
        }
        Object aux = q.getElemento();
        q.setElemento(p.getElemento());
        p.setElemento(aux);
    }
    public No insertAfter(No p, Object obj) {
        No novoNo = new No(obj);
        No aux = p.getProximo();
        novoNo.setAnterior(p);
        novoNo.setProximo(aux);
        p.setProximo(novoNo);
        aux.setAnterior(novoNo);
        n++;
        return novoNo;
    }
    public No insertBefore(No p, Object obj) {
        No novoNo = new No(obj);
        No aux = p.getAnterior();
        novoNo.setProximo(p);
        novoNo.setAnterior(aux);
        p.setAnterior(novoNo);
        aux.setProximo(novoNo);
        n++;
        return novoNo;
    }
    public No insertFirst(Object obj) {
        No novoNo = new No(obj);
        No aux = inicio.getProximo();
        novoNo.setAnterior(inicio);
        novoNo.setProximo(aux);
        inicio.setProximo(novoNo);
        aux.setAnterior(novoNo);
        n++;
        return novoNo;
    }
    public No insertLast(Object obj) { // ok
        No novoNo = new No(obj);
        No aux = fim.getAnterior();
        novoNo.setProximo(fim);
        novoNo.setAnterior(aux);
        aux.setProximo(novoNo);
        fim.setAnterior(novoNo);
        n++;
        return novoNo;
    }
    public Object remove(No p) throws ListaException {
        if (isEmpty()) {
            throw new ListaException("Lista vazia!");
        }
        No pos = p.getProximo();
        No pre = p.getAnterior();
        pos.setAnterior(pre);
        pre.setProximo(pos);
        Object temp = p.getElemento();
        p.setAnterior(null);
        p.setProximo(null);
        p = null;
        n--;
        return temp;
    }
    public boolean isEmpty() {
        return n == 0;
    }
    public int size() {
        return this.n;
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
}