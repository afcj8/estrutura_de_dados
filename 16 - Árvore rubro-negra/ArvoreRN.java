import java.util.ArrayList;

public class ArvoreRN {
    private NoRB raiz;
    Comparador c = new Comparador();
    private int tamanho;
    private ArrayList<NoRB> imp;

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

    public NoRB pesquisar(NoRB no, Object key) {

        if (isExternal(no)) {
            return no;
        }

        if ((int) key == (int) no.getElement()) {
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

    public NoRB incluir(Object key) {
        NoRB pai = pesquisar(raiz, key);
        NoRB novo = new NoRB(pai, key);

        if (pai == null) {
            raiz = novo;
            tamanho++;
            novo.setCor("N");
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
        manterInsercao(novo);
        return novo;
    }

    // ------------------ Rotações ------------------

    public void rotacaoEsquerda(NoRB no) {
        NoRB aux = no.getFilhoDireito();
        no.setFilhoDireito(aux.getFilhoEsquerdo());

        if (aux.getFilhoEsquerdo() != null) {
            aux.getFilhoEsquerdo().setPai(no);
        }

        aux.setPai(no.getPai());

        if (no.getPai() == null) {
            setRaiz(aux);
        } else if (no == no.getPai().getFilhoEsquerdo()) {
            no.getPai().setFilhoEsquerdo(aux);
        } else {
            no.getPai().setFilhoDireito(aux);
        }

        aux.setFilhoEsquerdo(no);
        no.setPai(aux);

        System.out.println("Rotação simples à esquerda");
    }

    public void rotacaoDuplaEsquerda(NoRB no) {
        rotacaoDireita(no.getFilhoDireito());
        rotacaoEsquerda(no);
    }

    public void rotacaoDireita(NoRB no) {
        NoRB aux = no.getFilhoEsquerdo();
        no.setFilhoEsquerdo(aux.getFilhoDireito());

        if (aux.getFilhoDireito() != null) {
            aux.getFilhoDireito().setPai(no);
        }

        aux.setPai(no.getPai());

        if (no.getPai() == null) {
            setRaiz(aux);
        } else if (no == no.getPai().getFilhoDireito()) {
            no.getPai().setFilhoDireito(aux);
        } else {
            no.getPai().setFilhoEsquerdo(aux);
        }

        aux.setFilhoDireito(no);
        no.setPai(aux);

        System.out.println("Rotação simples á direita");
    }

    public void rotacaoDuplaDireita(NoRB no) {
        rotacaoEsquerda(no.getFilhoEsquerdo());
        rotacaoDireita(no);
    }

    public void manterInsercao(NoRB no) {
        while (no.getPai() != null && no.getPai().getCor().equals("R")) {
            NoRB pai = no.getPai();
            NoRB avo = pai.getPai();
            NoRB tio;

            if (avo != null) {
                // Se o pai for filho esquerdo, o tio é o filho direito
                if (pai == avo.getFilhoEsquerdo()) {
                    tio = avo.getFilhoDireito();
                // Se o pai for filho direito, o tio é o filho esquerdo
                } else if (pai == avo.getFilhoDireito()) {
                    tio = avo.getFilhoEsquerdo();
                } else {
                    tio = null;
                }
            } else {
                tio = null;
            }

            // Caso 2: pai vermelho, avô preto e tio vermelho
            if (pai.getCor().equals("R") && (avo != null && avo.getCor().equals("N")) && (tio != null && tio.getCor().equals("R"))) {
                System.err.println("Caso 2: pai rubro, avo negro e tio rubro");

                if (avo == raiz) {
                    avo.setCor("N");
                } else {
                    avo.setCor("R");
                }

                tio.setCor("N");
                pai.setCor("N");
                no = avo;  // Mover o foco de ajuste para o avô
                continue;
            }

            // Caso 3: Aplicar rotações onde tio é nulo ou preto
            if (pai.getCor().equals("R") && (avo != null && avo.getCor().equals("N")) && (tio == null || tio.getCor().equals("N"))) {
                
                // Caso 3a: pai é filho esquerdo e nó atual é filho esquerdo do pai
                if (pai == avo.getFilhoEsquerdo() && no == pai.getFilhoEsquerdo()) {
                    System.out.println("Caso 3a: Rotação à direita");
                    rotacaoDireita(avo);
                    pai.setCor("N");
                    avo.setCor("R");

                // Caso 3b: pai é filho direito e nó atual é filho direito do pai
                } else if (pai == avo.getFilhoDireito() && no == pai.getFilhoDireito()) {
                    System.out.println("Caso 3b: Rotação à esquerda");
                    rotacaoEsquerda(avo);
                    pai.setCor("N");
                    avo.setCor("R");

                // Caso 3c: pai é filho direito e nó atual é filho esquerdo do pai
                } else if (pai == avo.getFilhoDireito() && no == pai.getFilhoEsquerdo()) {
                    System.out.println("Caso 3c: Rotação dupla à esquerda");
                    rotacaoDuplaEsquerda(avo);
                    no.setCor("N");
                    pai.setCor("R");
                    avo.setCor("R"); 

                // Caso 3d: pai é filho esquerdo e nó atual é filho direito do pai
                } else if (pai == avo.getFilhoEsquerdo() && no == pai.getFilhoDireito()) {
                    System.out.println("Caso 3d: Rotação dupla à direita");
                    rotacaoDuplaDireita(avo);
                    no.setCor("N");
                    pai.setCor("R");
                    avo.setCor("R");
                }

                break;
            }
        }

        raiz.setCor("N");  // Garantir que a raiz permanece preta
    }

    public void mostrar() {
        if (raiz == null) {
            System.out.println("Árvore vazia");
            return;
        }

        imp = new ArrayList<>();
        emOrdem(raiz);

        int h = height(raiz); // Altura da árvore
        Object[][] matriz = new Object[h + 1][imp.size()];

        // Popular a matriz com nós
        for (int i = 0; i < imp.size(); i++) {
            NoRB no = imp.get(i);
            int profundidade = depth(no);
            matriz[profundidade][i] = no.getElement();
        }

        for (int i = 0; i <= h; i++) {
            for (int j = 0; j < imp.size(); j++) {
                if (matriz[i][j] == null) {
                    System.out.print("\t");
                } else {
                    NoRB no = imp.get(j);
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
        imp.add(no); // visite
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