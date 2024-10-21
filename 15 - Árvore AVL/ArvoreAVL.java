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
        
        while (pai != null) {
            pai.setFb(fatorBalanceamento(pai));
            pai = balancear(pai);
            pai = pai.getPai();
        }
        return novo;
    }

    // ------------------ Rotações ------------------

    public NoAVL rotacaoEsquerda(NoAVL no) {
        NoAVL novoNo = no.getFilhoDireito();
        novoNo.setPai(no.getPai());

        no.setFilhoDireito(novoNo.getFilhoEsquerdo());


        if (no.getFilhoDireito() != null) {
            no.getFilhoDireito().setPai(no);
        }

        novoNo.setFilhoEsquerdo(no);
        no.setPai(novoNo);

        if (novoNo.getPai() != null) {
            if (novoNo.getPai().getFilhoDireito() == no) {
                novoNo.getPai().setFilhoDireito(novoNo);
            } else if (novoNo.getPai().getFilhoEsquerdo() == no) {
                novoNo.getPai().setFilhoEsquerdo(novoNo);
            }
        }

        no.setFb(fatorBalanceamento(no));
        novoNo.setFb(fatorBalanceamento(novoNo));

        System.out.println("Rotação simples à esquerda");

        return novoNo;
    }

    public NoAVL rotacaoDireita(NoAVL no) {
        NoAVL novoNo = no.getFilhoEsquerdo();
        novoNo.setPai(no.getPai());

        no.setFilhoEsquerdo(novoNo.getFilhoDireito());

        if (no.getFilhoEsquerdo() != null) {
            no.getFilhoEsquerdo().setPai(no);
        }

        novoNo.setFilhoDireito(no);
        no.setPai(novoNo);

        if (novoNo.getPai() != null) {
            if (novoNo.getPai().getFilhoDireito() == no) {
                novoNo.getPai().setFilhoDireito(novoNo);
            } else if (novoNo.getPai().getFilhoEsquerdo() == no) {
                novoNo.getPai().setFilhoEsquerdo(novoNo);
            }
        }

        no.setFb(fatorBalanceamento(no));
        novoNo.setFb(fatorBalanceamento(novoNo));

        System.out.println("Rotação simples à direita");

        return novoNo;
    }

    public NoAVL rotacaoDuplaEsquerda(NoAVL no) {
        rotacaoDireita(no.getFilhoDireito());
        System.out.println("Rotação dupla à esquerda");
        return rotacaoEsquerda(no);
    }

    public NoAVL rotacaoDuplaDireita(NoAVL no) {
        rotacaoEsquerda(no.getFilhoEsquerdo());
        System.out.println("Rotação dupla à direita");
        return rotacaoDireita(no);;
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

    private NoAVL balancear(NoAVL no) {
        int fb = fatorBalanceamento(no);

        // Rotação simples à esquerda
        if (fb < -1 && fatorBalanceamento(no.getFilhoDireito()) <= 0) {
            no = rotacaoEsquerda(no);
        }
        // Rotação simples à direita
        else if (fb > 1 && fatorBalanceamento(no.getFilhoEsquerdo()) >= 0) {
            no = rotacaoDireita(no);
        }
        // Rotação dupla à esquerda
        else if (fb < -1 && fatorBalanceamento(no.getFilhoDireito()) > 0) {
            no = rotacaoDuplaEsquerda(no);
        }
        // Rotação dupla á direita
        else if (fb > 1 && fatorBalanceamento(no.getFilhoEsquerdo()) < 0) {
            no = rotacaoDuplaDireita(no);
        } 

        if (no.getPai() == null) {
            raiz = no;
        }

        return no;
    }

    public void mostrar() {
        if (raiz == null) {
            System.out.println("Árvore vazia");
            return;
        } 

        aux = new ArrayList<>();
        emOrdem(raiz);

        int h = height(raiz); // Altura da árvore
        Object[][] matriz = new Object[h + 1][aux.size()];

        // Popular a matriz com nós
        for (int i = 0; i < aux.size(); i++) {
            NoAVL no = aux.get(i);
            int profundidade = depth(no);
            matriz[profundidade][i] = no.getElement();
        }

        for (int i = 0; i <= h; i++) {
            for (int j = 0; j < aux.size(); j++) {
                if (matriz[i][j] == null) {
                    System.out.print("\t");
                } else {
                    NoAVL no = aux.get(j);
                    System.out.printf("\t%d" + "[" + no.getFb() + "]", no.getElement());
                }
            }
            System.out.println();
        }
        System.out.println();
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