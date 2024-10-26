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

    public NoRB pesquisar(NoRB no, Object key) {

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
        
        while (pai != null) {
            manterInsercao(novo);
            pai = pai.getPai();
        }

        return novo;
    }

    // ------------------ Rotações ------------------

    public void rotacaoEsquerda(NoRB n) {
        NoRB aux = n.getFilhoDireito();
        n.setFilhoDireito(aux.getFilhoEsquerdo());

        if (aux.getFilhoEsquerdo() != null) {
            aux.getFilhoEsquerdo().setPai(n);
        }

        aux.setPai(n.getPai());

        if (n.getPai() == null) {
            setRaiz(aux);
        } else if (n == n.getPai().getFilhoEsquerdo()) {
            n.getPai().setFilhoEsquerdo(aux);
        } else {
            n.getPai().setFilhoDireito(aux);
        }

        aux.setFilhoEsquerdo(n);
        n.setPai(aux);

        System.out.println("Rotação para a esquerda realizada: ");
    }
    
    public void rotacaoDuplaEsquerda(NoRB n) {
        rotacaoDireita(n.getFilhoDireito());
        rotacaoEsquerda(n);
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

        System.out.println("Rotação para a direita realizada: ");
    }

    public void rotacaoDuplaDireita(NoRB no) {
        rotacaoEsquerda(no.getFilhoEsquerdo());
        rotacaoDireita(no);
    }

    public void manterInsercao(NoRB n) {
        while (n.getPai() != null && n.getPai().getCor().equals("R")) {
            NoRB pai = n.getPai();
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

            // Caso 2: pai rubro, avo negro e tio rubro
            if (pai.getCor().equals("R") && (avo != null && avo.getCor().equals("N")) && (tio != null && tio.getCor().equals("R"))) {
                System.err.println("pai rubro, avo negro e tio rubro");
                if (!isRoot(avo)) {
                    avo.setCor("R");
                    tio.setCor("N");
                    pai.setCor("N");
                    n.setCor("R");
                } else {
                    tio.setCor("N");
                    pai.setCor("N");
                    n.setCor("R");
                }
            } else if (pai.getCor().equals("R") && (avo != null && avo.getCor().equals("N")) && ((tio != null && tio.getCor().equals("R")) || (tio == null))) {
                System.err.println("Entrei aqui");
                // if (!isRoot(avo)) { // Diferente de raiz
                    if (pai == avo.getFilhoEsquerdo() && n == pai.getFilhoEsquerdo()) {
                        System.err.println("Entrei");
                        System.out.println("Caso 3a: ");
                        rotacaoDireita(avo);
                        pai.setCor("N");
                        avo.setCor("R");
                        if (tio != null) {
                            tio.setCor("N");
                        }
                        n.setCor("R");
                    } else if (pai == avo.getFilhoDireito() && n == pai.getFilhoDireito()) {
                        System.out.println("Caso 3b: ");
                        rotacaoEsquerda(avo);
                        pai.setCor("N");
                        avo.setCor("R");
                        tio.setCor("N");
                        n.setCor("R");
                    } else if (pai == avo.getFilhoDireito() && n == pai.getFilhoEsquerdo()) {
                        System.out.println("Caso 3c: ");
                        rotacaoDuplaEsquerda(avo);
                        pai.setCor("N");
                        avo.setCor("R");
                        tio.setCor("N");
                        n.setCor("R");
                    } else if (pai == avo.getFilhoEsquerdo() && n == pai.getFilhoDireito()) {
                        System.out.println("Caso 3d: ");
                        rotacaoDuplaDireita(avo);
                        pai.setCor("N");
                        avo.setCor("R");
                        tio.setCor("N");
                        n.setCor("R");
                    }
                // }
            } else {
                break;
            }
        }
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