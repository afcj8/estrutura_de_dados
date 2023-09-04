import java.util.ArrayList;
import java.util.Iterator;

public class ArvoreBinariaPesquisa {
    private No raiz;
    private Comparador c = new Comparador();
    private int tamanho;
    private ArrayList<No> aux;
    public ArvoreBinariaPesquisa(Object obj) {
        this.raiz = new No(null,obj);
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
        if ((int)key == (int)no.getElement()) {
            return no;
        }
        if (c.compare(key, no.getElement()) < 0) {
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
    public No incluir(Object key) {
        No pai = pesquisar(raiz, key);
        No novo = new No(pai, key);
        if (c.compare(key, pai.getElement()) < 0) {
            pai.setFilhoEsquerdo(novo);
        } else {
            pai.setFilhoDireito(novo);
        }
        tamanho++;
        return novo;
    }
    public No encontrarSucessor(No no) {
        if (no.getFilhoDireito() != null) {
            No sucessor = no.getFilhoDireito();
            while (sucessor.getFilhoEsquerdo() != null) {
                sucessor = sucessor.getFilhoEsquerdo();
            }
            return sucessor;
        }
        return null;
    }
    public Object remover(Object key) {
        No v = pesquisar(raiz, key);
        No pai = v.getPai();
        if (isExternal(v)) {
            if (pai.getFilhoEsquerdo() != null && pai.getFilhoEsquerdo().equals(v)) {
                pai.setFilhoEsquerdo(null);
            } else if (pai.getFilhoDireito() != null && pai.getFilhoDireito().equals(v)) {
                pai.setFilhoDireito(null);
            }
        } else if (isInternal(v)) {
            if (v.getFilhoEsquerdo() != null && v.getFilhoDireito() == null) {
                if (pai.getFilhoEsquerdo() == v) {
                    pai.setFilhoEsquerdo(v.getFilhoEsquerdo());
                }
                v.getFilhoEsquerdo().setPai(pai);
            } else if (v.getFilhoDireito() != null && v.getFilhoEsquerdo() == null) {
                if (pai.getFilhoDireito() == v) {
                    pai.setFilhoDireito(v.getFilhoDireito());
                }
                v.getFilhoDireito().setPai(pai);
            } else if (v.getFilhoEsquerdo() != null && v.getFilhoDireito() != null) {
                No sucessor = encontrarSucessor(v);
                if (sucessor != null) {
                    Object temp = sucessor.getElement();
                    remover(sucessor.getElement());
                    v.setElement(temp);
                    return key;
                }
            }
        }
        tamanho--;
        return key;
    }
    public void mostrar() {
        Object[][] matriz = new Object[height(raiz) + 1][tamanho];
        aux = new ArrayList();
        emOrdem(raiz);
        for (int i = 0; i < tamanho; i++) {
            Object obj = ((No)aux.get(i)).getElement();
            matriz[depth((No)aux.get(i))][i] = obj;
        }
        for (int i = 0; i < height(raiz) + 1; i++) {
            for (int j = 0; j < tamanho; j++) {
                if (matriz[i][j] == null) {
                    System.out.print("\t");
                } else {
                    System.out.printf("\t%d", matriz[i][j]);
                }
            }
            System.out.println();
        }
    }
    public void preOrdem(No no) {
        aux.add(no); // visite
        if (isInternal(no)) {
            if (no.getFilhoEsquerdo() != null) {
                preOrdem(no.getFilhoEsquerdo());
            }
        }
        if (isInternal(no)) {
            preOrdem(no.getFilhoDireito());
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
    public int height(No v) {
        if (v == null) {
            return 0;
        }
        if (isExternal(v)) {
            return 0;
        }
        int h = 0;
        if (v.getFilhoEsquerdo() != null) {
            h = Math.max(h, height(v.getFilhoEsquerdo()));
        }
        if (v.getFilhoDireito() != null) {
            h = Math.max(h, height(v.getFilhoDireito()));
        }
        return 1 + h;
    }
    public int depth(No v) {
        int profundidade = profundidade(v);
        return profundidade;
    }

    private int profundidade(No v) {
        if (v == raiz)
            return 0;
        else
            return 1 + depth(v.getPai());
    }
    public Iterator elements() {
        aux = new ArrayList<No>();
        emOrdem(raiz);
        return aux.iterator();
    }
    public Iterator nos() {
        aux = new ArrayList<No>();
        emOrdem(raiz);
        return aux.iterator();
    }
    public int size() {
        return tamanho;
    }
    public boolean isEmpty() {
        return raiz == null;
    }
}