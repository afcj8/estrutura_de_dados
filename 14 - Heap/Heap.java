import java.util.ArrayList;

public class Heap {

    private No raiz, ultimo;
    private int tamanho;
    private ArrayList<No> aux;
    private Comparador c = new Comparador();

    public Heap() {
        this.raiz = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

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

    public Object min() {
        if (isEmpty()) {
            return "Heap vazia!";
        }
        return raiz.getObj();
    }

    public No incluir(Object obj) {
        No antigoUltimo = proximoNo();
        No novoUltimo = new No(antigoUltimo, obj);

        if (isEmpty()) {
            raiz = novoUltimo;
            ultimo = novoUltimo;
            tamanho++;
            return novoUltimo;
        }

        if (antigoUltimo.getFilhoEsquerdo() == null) {
            antigoUltimo.setFilhoEsquerdo(novoUltimo);
        } else {
            antigoUltimo.setFilhoDireito(novoUltimo);
        }

        upHeap(novoUltimo);
        this.ultimo = novoUltimo;
        tamanho++;
        return novoUltimo;
    }

    public Object removeMin() {
        if (isEmpty()) {
            return "Heap vazia!";
        }

        Object min = raiz.getObj();
        trocarNos(raiz, ultimo);
        No novoUltimo = novoUltimoNo();

        if (isRoot(ultimo)) {
            raiz = null;
            ultimo = null;
            tamanho--;
            return min;
        }

        if (ultimo != null && ultimo.getPai() != null) {
            if (ultimo.getPai().getFilhoDireito() == null) {
                ultimo.getPai().setFilhoEsquerdo(null);
            } else {
                ultimo.getPai().setFilhoDireito(null);
            }
        }

        downHeap(raiz);
        this.ultimo = novoUltimo;
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

    private No proximoNo() {
        No atual = ultimo;

        if (isRoot(atual)) {
            return atual;
        }

        while (!isRoot(atual) && !atual.getPai().getFilhoEsquerdo().equals(atual)) {
            atual = atual.getPai();
        }

        if (atual != raiz && atual.getPai().getFilhoDireito() == null) {
            return atual.getPai();
        } else if (atual != raiz && atual.getPai().getFilhoDireito() != null) {
            atual = atual.getPai().getFilhoDireito();
        }

        while (atual.getFilhoEsquerdo() != null) {
            atual = atual.getFilhoEsquerdo();
        }

        return atual;
    }

    private No novoUltimoNo() {
        No atual = ultimo;

        if (isRoot(atual)) {
            return atual;
        }

        while (!isRoot(atual) && (atual.getPai().getFilhoDireito() == null || !atual.getPai().getFilhoDireito().equals(atual))) {
            atual = atual.getPai();
        }

        if (!isRoot(atual) && atual.getPai().getFilhoEsquerdo() == null) {
            return atual.getPai();
        } else if (!isRoot(atual) && atual.getPai().getFilhoEsquerdo() != null) {
            atual = atual.getPai().getFilhoEsquerdo();
        }

        while (atual.getFilhoDireito() != null) {
            atual = atual.getFilhoDireito();
        }

        return atual;
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
        if (isEmpty()) {
            System.out.println("Heap vazia!");
            return;
        }

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