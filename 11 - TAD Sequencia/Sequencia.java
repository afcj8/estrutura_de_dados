import TadLista.Lista;
import TadLista.No;

public class Sequencia extends Lista implements ISequencia {
    private No inicio, fim;
    private int n;
    public Sequencia() {
        inicio = new No(null);
        fim = new No(null);
        inicio.setProximo(fim);
        fim.setAnterior(inicio);
    }
    public No elemAtRank(int r) throws Excecao {
        if (size() == 0) {
            throw new Excecao("Sequência vazia!");
        }
        if (r < 0 || r >= size()) {
            throw new Excecao("Índice inválido");
        }
        return atRank(r);
    }
    public Object replaceAtRank(int r, Object obj) throws Excecao {
        if (size() == 0) {
            throw new Excecao("Sequência vazia!");
        }
        if (r < 0 || r >= size()) {
            throw new Excecao("Índice inválido!");
        }
        No n = atRank(r);
        Object temp = n.getElemento();
        n.setElemento(obj);
        return temp;
    }

    public No insertAtRank(int r, Object obj) throws Excecao {
        if (r < 0 || r >= size()) {
            throw new Excecao("Índice inválido!");
        }
        No novoNo = new No(obj);
        No aux = atRank(r);
        No pre = aux.getAnterior();
        novoNo.setProximo(aux);
        novoNo.setAnterior(pre);
        aux.setAnterior(novoNo);
        pre.setProximo(novoNo);
        n++;
        return novoNo;
    }
    public Object removeAtRank(int r) throws Excecao {
        if (size() == 0) {
            throw new Excecao("Sequência vazia!");
        }
        if (r < 0 || r >= size()) {
            throw new Excecao("Índice inválido!");
        }
        No aux = atRank(r);
        Object temp = aux.getElemento();
        No pos = aux.getProximo();
        No pre = aux.getAnterior();
        pos.setAnterior(pre);
        pre.setProximo(pos);
        aux.setProximo(null);
        aux.setAnterior(null);
        aux = null;
        n++;
        return temp;
    }
    public No atRank(int r) {
        No no = inicio.getProximo();
        for (int i = 0; i < r; i++) {
            no = inicio.getProximo();
        }
        return no;
    }
    public int rankOf(No no) {
        No n = inicio.getProximo();
        int r = 0;
        while (n != no && n != fim) {
            n = n.getProximo();
            r++;
        }
        return r;
    }
}