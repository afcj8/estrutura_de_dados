import java.util.ArrayList;

public class ArvoreAVL {
    private NoAVL raiz;
    Comparador c = new Comparador();
    private int tamanho;
    private ArrayList<NoAVL> aux = new ArrayList<NoAVL>();

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
}