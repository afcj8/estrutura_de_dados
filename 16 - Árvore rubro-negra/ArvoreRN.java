import java.util.ArrayList;

public class ArvoreRN {
    private NoRB raiz;
    Comparador c = new Comparador();
    private int tamanho;
    private ArrayList<NoRB> aux;

    public ArvoreRN() {
        this.raiz = null;
        this.tamanho = 0;
    }

    public ArvoreRN(Object obj) {
        this.raiz = new NoRB(null, obj);
        this.tamanho++;
        this.raiz.setCor("N");
    }

    public NoRB getRaiz() {
        return raiz;
    }

    public void setRaiz(NoRB raiz) {
        this.raiz = raiz;
    }

    public boolean isRoot(NoRB no) {
        return no == this.raiz;
    }

    public boolean isExternal(NoRB no) {
        return no.getFilhoDireito() == null && no.getFilhoEsquerdo() == null;
    }

    public boolean isInternal(NoRB no) {
        return no.getFilhoDireito() != null || no.getFilhoEsquerdo() != null;
    }

    // ------------------ Rotações ------------------

    
    public NoRB rotacaoEsquerda(NoRB no) {
        NoRB novoNo = no.getFilhoDireito();
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

        novoNo.setCor(no.getCor());
        no.setCor("R");

        System.out.println("Rotação simples à esquerda");

        return novoNo;
    }

    public NoRB rotacaoDireita(NoRB no) {
        NoRB novoNo = no.getFilhoEsquerdo();
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

        novoNo.setCor(no.getCor());
        no.setCor("R");

        System.out.println("Rotação simples à direita");

        return novoNo;
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
            NoRB no = aux.get(i);
            int profundidade = depth(no);
            matriz[profundidade][i] = no.getElement();
        }

        for (int i = 0; i <= h; i++) {
            for (int j = 0; j < aux.size(); j++) {
                if (matriz[i][j] == null) {
                    System.out.print("\t");
                } else {
                    NoRB no = aux.get(j);
                    System.out.printf("\t%d" + "[" + no.getCor() + "]", no.getElement());
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public int height(NoRB no) {
        if (no == null) {
            return -1;
        }
        int hEsquerda = height(no.getFilhoEsquerdo());
        int hDireita = height(no.getFilhoDireito());
        return Math.max(hEsquerda, hDireita) + 1; 
    }
    
    public void emOrdem(NoRB no) {
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

    public int depth(NoRB no) {
        int profundidade = 0;
        while (no != raiz) {
            no = no.getPai();
            profundidade++;
        }
        return profundidade;
    }
}