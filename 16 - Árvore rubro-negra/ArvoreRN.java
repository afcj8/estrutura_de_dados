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
        balancearInsercao(novo);
        return novo;
    }

    public Object remover(Object key) {
        NoRB no = pesquisar(raiz, key);
        NoRB pai = no.getPai();

        if (no.getElement() != key) {
            return null;
        }

        if (isRoot(no) && isExternal(no)) {
            raiz = null;
            tamanho--;
            return key;
        }

        if (isExternal(no)) {
            if (pai != null) {
                if (pai.getFilhoEsquerdo() != null && pai.getFilhoEsquerdo().equals(no)) {
                    balancearRemocao(pai.getFilhoEsquerdo());
                    pai.setFilhoEsquerdo(null);
                } else if (pai.getFilhoDireito() != null && pai.getFilhoDireito().equals(no)) {
                    balancearRemocao(pai.getFilhoDireito());
                    pai.setFilhoDireito(null);
                }
            }
        } 

        else if (isInternal(no)) {
            if (no.getFilhoEsquerdo() != null && no.getFilhoDireito() == null) {
                if (pai == null) {
                    this.raiz = no.getFilhoEsquerdo();
                } else {
                    if (pai.getFilhoEsquerdo() == no) {
                        pai.setFilhoEsquerdo(no.getFilhoEsquerdo());
                    } else {
                        pai.setFilhoDireito(no.getFilhoEsquerdo());
                    }
                }
                no.getFilhoEsquerdo().setPai(pai);
                balancearRemocao(no.getFilhoEsquerdo());
            } else if (no.getFilhoDireito() != null && no.getFilhoEsquerdo() == null) {
                if (pai == null) {
                    this.raiz = no.getFilhoDireito();
                } else {
                    if (pai.getFilhoEsquerdo() == no) {
                        pai.setFilhoEsquerdo(no.getFilhoDireito());
                    } else {
                        pai.setFilhoDireito(no.getFilhoDireito());
                    }
                }
                no.getFilhoDireito().setPai(pai);
                balancearRemocao(no.getFilhoDireito());
            }

            
            else if (no.getFilhoEsquerdo() != null && no.getFilhoDireito() != null) {
                NoRB sucessor = encontrarSucessor(no);
                balancearRemocao(sucessor);
                if (sucessor != null) {
                    Object temp = sucessor.getElement();
                    remover(sucessor.getElement());
                    no.setElement(temp);
                    return key;
                }
            }
        }
        tamanho--;
        return key;
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

    public void balancearInsercao(NoRB no) {
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

    public void balancearRemocao(NoRB no) {
        System.out.println("Balanceando remoção");
        while (no != raiz && no.getCor().equals("N")) {

            NoRB pai = no.getPai();
            NoRB irmao;

            if (no == pai.getFilhoEsquerdo()) {
                irmao = pai.getFilhoDireito();

                // Caso 1: Irmão é vermelho
                if (irmao != null && irmao.getCor().equals("R")) {
                    System.out.println("Caso 1: Irmão é vermelho");
                    irmao.setCor("N");
                    pai.setCor("R");
                    rotacaoEsquerda(pai);
                    irmao = pai.getFilhoDireito();
                }

                // Caso 2: Irmão é preto e ambos os filhos são pretos
                if (irmao != null && (irmao.getFilhoEsquerdo() == null || irmao.getFilhoEsquerdo().getCor().equals("N")) && (irmao.getFilhoDireito() == null || irmao.getFilhoDireito().getCor().equals("N"))) {
                    System.out.println("Caso 2: Irmão é preto e ambos os filhos são pretos");
                    irmao.setCor("R");
                    no = pai;
                } else {
                    // Caso 3: Irmão é preto e filho direito é vermelho
                    if (irmao == null || irmao.getFilhoDireito() == null || irmao.getFilhoDireito().getCor().equals("N")) {
                        System.out.println("Caso 3: Irmão é preto e filho direito é vermelho");
                        if (irmao != null) {
                            irmao.getFilhoEsquerdo().setCor("N");
                            irmao.setCor("R");
                            rotacaoDireita(irmao);
                        }
                        irmao = pai.getFilhoDireito();
                    }

                    // Caso 4: Irmão é preto e filho direito é preto
                    System.out.println("Caso 4: Irmão é preto e filho direito é preto");
                    if (irmao != null) {
                        irmao.setCor(pai.getCor());
                        pai.setCor("N");
                        irmao.getFilhoDireito().setCor("N");
                        rotacaoEsquerda(pai);
                    }
                    no = raiz;
                }
            } else {
                irmao = pai.getFilhoEsquerdo();

                if (irmao.getCor().equals("R")) {
                    System.out.println("Caso 1: Irmão é vermelho");
                    irmao.setCor("N");
                    pai.setCor("R");
                    rotacaoDireita(pai);
                    irmao = pai.getFilhoEsquerdo();
                }

                if ((irmao != null && (irmao.getFilhoEsquerdo() == null || irmao.getFilhoEsquerdo().getCor().equals("N")) && (irmao.getFilhoDireito() == null || irmao.getFilhoDireito().getCor().equals("N")))) {
                    System.out.println("Caso 2: Irmão é preto e ambos os filhos são pretos");
                    irmao.setCor("R");
                    no = pai;
                } else {
                    if (irmao == null || irmao.getFilhoEsquerdo() == null || irmao.getFilhoEsquerdo().getCor().equals("N")) {
                        System.out.println("Caso 3: Irmão é preto e filho esquerdo é vermelho");
                        if (irmao != null) {
                            irmao.getFilhoDireito().setCor("N");
                            irmao.setCor("R");
                            rotacaoEsquerda(irmao);
                        }
                        irmao = pai.getFilhoEsquerdo();
                    }

                    System.out.println("Caso 4: Irmão é preto e filho esquerdo é preto");
                    if (irmao != null) {
                        irmao.setCor(pai.getCor());
                        pai.setCor("N");
                        irmao.getFilhoEsquerdo().setCor("N");
                        rotacaoDireita(pai);
                    }
                    no = raiz;
                }
            }
        }
        no.setCor("N");
    }

    public NoRB encontrarSucessor(NoRB no) {
        if (no.getFilhoDireito() != null) {
            NoRB sucessor = no.getFilhoDireito();
            while (sucessor.getFilhoEsquerdo() != null) {
                sucessor = sucessor.getFilhoEsquerdo();
            }
            return sucessor;
        }
        return null;
    }

    public void mostrar() {

        if (isEmpty()) {
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
        while (no != null && no != raiz) {
            no = no.getPai();
            profundidade++;
        }
        return profundidade;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }
}