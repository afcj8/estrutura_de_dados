import java.util.ArrayList;
import java.util.Iterator;

public class ArvoreBinariaPesquisa {
    private No raiz;
    private Comparador c = new Comparador();
    private int tamanho;
    private ArrayList<No> aux;

    // Construtores da classe ArvoreBinariaPesquisa

    public ArvoreBinariaPesquisa() {
        this.raiz = null;
        this.tamanho = 0;
    }

    public ArvoreBinariaPesquisa(Object obj) {
        this.raiz = new No(null,obj);
        this.tamanho++;
    }

    // Método getComparador - retorna o comparador da árvore

    public Comparador getComparador() {
        return c;
    }
    
    // Método setComparador - modifica o comparador da árvore

    public void setComparador(Comparador c) {
        this.c = c;
    }

    // Método getRaiz - retorna a raiz da árvore

    public No getRaiz() {
        return this.raiz;
    }

    // Método setRaiz - modifica a raiz da árvore

    public void setRaiz(No p) {
        this.raiz = p;
    }

    // Método isRoot - verifica se um nó é raiz

    public boolean isRoot(No no) {
        return no == this.raiz;
    }

    // Método isInternal - verifica se um nó é interno

    public boolean isInternal(No no) {
        return no.getFilhoEsquerdo() != null || no.getFilhoDireito() != null;
    }

    // Método isExternal - verifica se um nó é externo ou folha

    public boolean isExternal(No no) {
        return no.getFilhoEsquerdo() == null && no.getFilhoDireito() == null;
    }

    // Método pesquisar - pesquisa um nó na árvore

    public No pesquisar(No no, Object key) {

        if (isExternal(no)) {
            return no;
        }

        // Se a chave for igual ao elemento do nó, retorna o nó

        if ((int)key == (int)no.getElement()) {
            return no;
        }

        // Se a chave for menor que o elemento do nó, pesquisa o filho esquerdo
        // Caso contrário, pesquisa o filho direito

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

    // Método incluir - inclui um nó na árvore

    public No incluir(Object key) {
        No pai = pesquisar(raiz, key);
        No novo = new No(pai, key);

        // Se a árvore estiver vazia, o novo nó será a raiz

        if (pai == null) {
            raiz = novo;
            tamanho++;
            return novo;
        }

        // Se o nó já existir, retorna o nó

        if (novo.getElement() == pai.getElement()) {
            return pai;
        }

        // Se a chave for menor que o elemento do nó pai, o novo nó será o filho esquerdo
        // Caso contrário, o novo nó será o filho direito

        if (c.compare(key, pai.getElement()) < 0) {
            pai.setFilhoEsquerdo(novo);
        } else {
            pai.setFilhoDireito(novo);
        }
        tamanho++;
        return novo;
    }

    // Método encontrarSucessor - encontra o sucessor de um nó
    // O sucessor de um nó é o nó que tem a menor chave maior que a chave do nó

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

    // Método remover - remove um nó da árvore

    public Object remover(Object key) {
        No v = pesquisar(raiz, key);
        No pai = v.getPai();

        // Se o nó não existir, retorna null

        if (v.getElement() != key) {
            return null;
        }

        // Se só houver um nó na árvore, remove o nó

        if (isRoot(v) && isExternal(v)) {
            raiz = null;
            tamanho--;
            return key;
        }

        // Se o nó for uma folha, remove o nó, ou seja, se o nó não tiver filhos

        if (isExternal(v)) {
            if (pai.getFilhoEsquerdo() != null && pai.getFilhoEsquerdo().equals(v)) {
                pai.setFilhoEsquerdo(null);
            } else if (pai.getFilhoDireito() != null && pai.getFilhoDireito().equals(v)) {
                pai.setFilhoDireito(null);
            }
        } 
        
        // Se o nó for interno, remove o nó e ajusta os filhos do pai

        else if (isInternal(v)) {
            if (v.getFilhoEsquerdo() != null && v.getFilhoDireito() == null) {
                if (pai.getFilhoEsquerdo() == v) {
                    pai.setFilhoEsquerdo(v.getFilhoEsquerdo());
                } else if (pai.getFilhoDireito() == v) {
                    pai.setFilhoDireito(v.getFilhoEsquerdo());
                }
                v.getFilhoEsquerdo().setPai(pai);
            } else if (v.getFilhoDireito() != null && v.getFilhoEsquerdo() == null) {
                if (pai.getFilhoEsquerdo() == v) {
                    pai.setFilhoEsquerdo(v.getFilhoDireito());
                } else if (pai.getFilhoDireito() == v) {
                    pai.setFilhoDireito(v.getFilhoDireito());
                }
                v.getFilhoDireito().setPai(pai);
            }             
            // Se o nó tiver dois filhos, encontra o sucessor do nó e remove o nó
            
            else if (v.getFilhoEsquerdo() != null && v.getFilhoDireito() != null) {
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

    // Método mostrar - exibe a árvore

    public void mostrar() {

        // Se a árvore estiver vazia, exibe a mensagem "Árvore vazia!"

        if (raiz == null) {
            System.out.println("Árvore vazia!");
            return;
        }

        // Cria uma matriz para armazenar os elementos da árvore

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

    // Método preOrdem - percorre a árvore em pré-ordem
    // Em uma travessia pré-ordem, um nó é visitado antes de seus descendentes

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

    // Método emOrdem - percorre a árvore em ordem
    // Em uma travessia em ordem, um nó é visitado depois do seu filho esquerdo e antes do seu filho direito

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

    // Método posOrdem - percorre a árvore em pós-ordem
    // Em uma travessia pós-ordem, um nó é visitado depois de seus descendentes

    public void posOrdem(No no) {
        if (isInternal(no)) {
            if (no.getFilhoEsquerdo() != null) {
                posOrdem(no.getFilhoEsquerdo());
            }
        }
        if (isInternal(no)) {
            if (no.getFilhoDireito() != null) {
                posOrdem(no.getFilhoDireito());
            }
        }
        aux.add(no); // visite
    }

    // Método height - retorna a altura de um nó
    // O nível de um nó x é o comprimento do caminho de x até a raiz

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

    // Método depth - retorna a profundidade de um nó em relação à raiz
    // A profundidade de um nó é a distância deste nó até a raiz.

    public int depth(No v) {
        int profundidade = 0;
        while (v != raiz) {
            v = v.getPai();
            profundidade++;
        }
        return profundidade;
    }

    // Método elements - retorna um iterador com os elementos da árvore

    public Iterator elements() {
        aux = new ArrayList<No>();
        emOrdem(raiz);
        return aux.iterator();
    }

    // Método nos - retorna um iterador com os nós da árvore

    public Iterator nos() {
        aux = new ArrayList<No>();
        emOrdem(raiz);
        return aux.iterator();
    }

    // Método size - retorna o número de nós da árvore

    public int size() {
        return tamanho;
    }

    // Método isEmpty - verifica se a árvore está vazia

    public boolean isEmpty() {
        return raiz == null;
    }
}