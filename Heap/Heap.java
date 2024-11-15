
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

    public No getUltimo() {
        return this.ultimo;
    }

    public void setUltimo(No u) {
        this.ultimo = u;
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

        if ((int) key == (int) no.getObj()) {
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

    public No incluir(Object obj) {
        No pai = pesquisar(raiz, obj);
        No novo = new No(pai, obj);

        if (pai == null) {
            raiz = novo;
            this.ultimo = novo;
            this.tamanho++;
            return novo;
        }

        if (novo.getObj() == pai.getObj()) {
            return pai;
        }

        if (c.compare(obj, pai.getObj()) < 0) {
            pai.setFilhoEsquerdo(novo);
        } else {
            pai.setFilhoDireito(novo);
        }

        this.ultimo = novo;
        tamanho++;
        upHeap(novo);
        return novo;
    }

    public Object removeMin() {
        if (isEmpty()) {
            return null;
        }

        Object min = raiz.getObj();
        if (tamanho == 1) {
            raiz = null;
            ultimo = null;
            tamanho--;
            return min;
        }

        No sucessor = encontrarSucessor(raiz);
        raiz.setObj(sucessor.getObj());
        No pai = sucessor.getPai();
        if (pai.getFilhoEsquerdo() == sucessor) {
            pai.setFilhoEsquerdo(null);
        } else {
            pai.setFilhoDireito(null);
        }

        downHeap(raiz);
        tamanho--;
        return min;
    }

    private void upHeap(No no) {
        while (!isRoot(no) && c.compare(no.getObj(), no.getPai().getObj()) < 0) {
            trocarNos(no, no.getPai());
            no = no.getPai();
        }
    }

    private void downHeap(No no) {
        while (no.getFilhoEsquerdo() != null) {
            No menor = no.getFilhoEsquerdo();
            if (no.getFilhoDireito() != null && c.compare(no.getFilhoDireito().getObj(), menor.getObj()) < 0) {
                menor = no.getFilhoDireito();
            }
            if (c.compare(menor.getObj(), no.getObj()) < 0) {
                trocarNos(no, menor);
                no = menor;
            } else {
                break;
            }
        }
    }

    private void trocarNos(No a, No b) {
        Object temp = a.getObj();
        a.setObj(b.getObj());
        b.setObj(temp);
    }

    private No encontrarSucessor(No no) {
        No sucessor = no.getFilhoDireito();
        while (sucessor.getFilhoEsquerdo() != null) {
            sucessor = sucessor.getFilhoEsquerdo();
        }
        return sucessor;
    }

    public void mostrar() {
        if (isEmpty()) {
            System.out.println("Heap vazia!");
            return;
        }

        Object[][] matriz = new Object[height(raiz) + 1][tamanho];
        aux = new ArrayList();
        emOrdem(raiz);
        for (int i = 0; i < tamanho; i++) {
            Object obj = ((No)aux.get(i)).getObj();
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

    public void heapOrdem(No no) {
        if (isInternal(no)) {
            if (no.getFilhoEsquerdo() != null) {
                heapOrdem(no.getFilhoEsquerdo());
            }
        }
        System.out.printf("%d ", no.getObj()); // visite
        if (isInternal(no)) {
            if (no.getFilhoDireito() != null) {
                heapOrdem(no.getFilhoDireito());
            }
        }
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public int size() {
        return tamanho;
    }

}
