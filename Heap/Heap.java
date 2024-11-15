import java.util.ArrayList;

public class Heap {
    private No raiz;
    private No ultimo;
    private int tamanho;
    private ArrayList<No> nos;
    private Comparador c = new Comparador();

    public Heap(Object obj) {
        this.raiz = new No(null, obj);
        this.ultimo = this.raiz;
        this.tamanho++;
    }

    public Comparador getComparador() {
        return c;
    }

    public void setComparador(Comparador c) {
        this.c = c;
    }

    public No getRaiz() {
        return this.raiz;
    }

    public void setRaiz(No p) {
        this.raiz = p;
    }

    public boolean isRoot(No no) {
        return no == this.raiz;
    }

    public boolean isInternal(No no) {
        return no.getFilhoEsquerdo() != null || no.getFilhoDireito() != null;
    }

    public boolean isExternal(No no) {
        return no.getFilhoEsquerdo() == null && no.getFilhoDireito() == null;
    }

    public int height(No no) {
        if (no == null) {
            return 0;
        }
        
        if (isExternal(no)) {
            return 0;
        }

        int h = 0;
        if (no.getFilhoEsquerdo() != null) {
            h = Math.max(h, height(no.getFilhoEsquerdo()));
        }
        if (no.getFilhoDireito() != null) {
            h = Math.max(h, height(no.getFilhoDireito()));
        }
        return h + 1;
    }
}