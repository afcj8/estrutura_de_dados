public class Pilha implements IPilha {
    private Fila f1;
    private Fila f2;
    public Pilha() {
        f1 = new Fila(10);
        f2 = new Fila(10);
    }
    public void push(Object obj) throws FilaVaziaException {
        while (!f1.isEmpty()) {
            f2.enqueue(f1.dequeue());
        }
        f1.enqueue(obj);
        while (!f2.isEmpty()) {
            f1.enqueue(f2.dequeue());
        }
    }
    public Object pop() throws FilaVaziaException {
        if (isEmpty()) {
            throw new FilaVaziaException("A pilha está vazia");
        }
        return f1.dequeue();
    }
    public Object top() throws FilaVaziaException {
        if (isEmpty()) {
            throw new FilaVaziaException("A pilha está vazia");
        }
        return f1.first();
    }
    public int size() {
        return f1.size();
    }
    public boolean isEmpty() {
        return f1.isEmpty();
    }
}