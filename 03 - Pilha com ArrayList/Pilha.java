import java.util.ArrayList;

public class Pilha implements IPilha {
    private ArrayList p;
    public Pilha() {
        p = new ArrayList();
    }
    public void push(Object obj) {
        p.add(obj);
    }
    public Object pop() throws PilhaVaziaException {
        if (isEmpty()) {
            throw new PilhaVaziaException("A pilha está vazia");
        } else {
            return p.remove(p.size() - 1);
        }
    }
    public Object top() throws PilhaVaziaException {
        if (isEmpty()) {
            throw new PilhaVaziaException("A pilha está vazia");
        } else {
            return p.get(p.size() - 1);
        }
    }
    public void empty() {
        p.clear();
    }
    public boolean isEmpty() {
        return p.size() == 0;
    }
    public int size() {
        return p.size();
    }
    public void imprimir() {
        System.out.print("Pilha = [ ");
        for (int i = 0; i < size(); i++) {
            System.out.print(p.get(i) + " ");
        }
        System.out.println("]");
    }
}