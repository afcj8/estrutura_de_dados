import java.util.ArrayList;

public class ArvoreAVL {
    private NoAVL raiz;
    Comparador c = new Comparador();
    private int tamanho;
    private ArrayList<NoAVL> aux;

    public ArvoreAVL() {
        this.raiz = null;
        this.tamanho = 0;
    }

    public ArvoreAVL(Object obj) {
        this.raiz = new NoAVL(null, obj);
        this.tamanho = 1;
    }

    public NoAVL getRaiz() {
        return raiz;
    }

    public void setRaiz(NoAVL raiz) {
        this.raiz = raiz;
    }

    public boolean isRoot(NoAVL no) {
        return no == this.raiz;
    }

    public boolean isExternal(NoAVL no) {
        return no.getFilhoDireito() == null && no.getFilhoEsquerdo() == null;
    }

    public boolean isInternal(NoAVL no) {
        return no.getFilhoDireito() != null || no.getFilhoEsquerdo() != null;
    }

    public NoAVL pesquisar(NoAVL no, Object key) {
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

    public NoAVL incluir(Object key) {
        NoAVL pai = pesquisar(raiz, key);
        NoAVL novo = new NoAVL(pai, key);

        if (pai == null) {
            raiz = novo;
            tamanho++;
            novo.setFb(0);
            return novo;
        }

        if (novo.getElement() == pai.getElement()) {
            return pai;
        }

        if (c.compare(key, pai.getElement()) < 0) {
            pai.setFilhoEsquerdo(novo);
        } else {
            pai.setFilhoDireito(novo);
        }
        
        tamanho++;
        return novo;
    }


    public int height(NoAVL no) {
        if (no == null) {
            return -1;
        }
        int hEsquerda = height(no.getFilhoEsquerdo());
        int hDireita = height(no.getFilhoDireito());
        return Math.max(hEsquerda, hDireita) + 1; 
    }

    public int depth(NoAVL no) {
        int profundidade = 0;
        while (no != raiz) {
            no = no.getPai();
            profundidade++;
        }
        return profundidade;
    }

    public int fatorBalanceamento(NoAVL no) {
        if (no == null) {
            return 0;
        }
        int hEsquerda = height(no.getFilhoEsquerdo());
        int hDireita = height(no.getFilhoDireito());
        return hEsquerda - hDireita;
    }

    public void mostrar() {
        if (raiz == null) {
            System.out.println("Árvore vazia");
            return;
        } 

        Object[][] matriz = new Object[height(raiz) + 1][tamanho];
        aux = new ArrayList();
        emOrdem(raiz);

        for (int i = 0; i < aux.size(); i++) {
            Object obj = ((NoAVL)aux.get(i)).getElement();
            matriz[depth((NoAVL)aux.get(i))][i] = obj;
        }

        for (int i = 0; i < height(raiz) + 1; i++) {
            for (int j = 0; j < tamanho; j++) {
                int fb = fatorBalanceamento((NoAVL)aux.get(j));
                if (matriz[i][j] == null) {
                    System.out.print("\t");
                } else {
                    System.out.printf("\t%d" + "[" + fb + "]", matriz[i][j]);
                }
            }
            System.out.println();
        } 
            
    }

    public void emOrdem(NoAVL no) {
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
}