
import java.util.ArrayList;

public class Heap {

    private No raiz, ultimo;
    private int tamanho;
    private ArrayList<No> aux;
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

    public No pesquisar(No no, Object key) {

        if (isExternal(no)) {
            return no;
        }

        if ((int)key == (int)no.getObj()) {
            return no;
        }

        if (c.compare(key, no.getObj()) < 0) {
            if (no.getFilhoEsquerdo() != null) {
                return pesquisar(no.getFilhoEsquerdo(), key);
            } else {
                return no;
            }
        } else {
            if (no.getFilhoDireito() != null) {
                return pesquisar(no.getFilhoDireito(), key);
            } else {
                return no;
            }
        }
    }

    public void emOrdem(No no) {
        if (isInternal(no)) {
            if (no.getFilhoEsquerdo() != null) {
                emOrdem(no.getFilhoEsquerdo());
            }
        }
        aux.add(no); // visite
        if (isInternal(no)) {
            if (no.getFilhoDireito() != null) {
                emOrdem(no.getFilhoDireito());
            }
        }
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

    public int depth(No no) {
        if (no == null) {
            return 0;
        }

        if (isRoot(no)) {
            return 0;
        }

        return 1 + depth(no.getPai());
    }


}
