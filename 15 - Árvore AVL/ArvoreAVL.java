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
}