public class Fila implements IFila {
    private Pilha p1;
    private Pilha p2;
    public Fila() {
        this.p1 = new Pilha(10);
        this.p2 = new Pilha(10);
    }
    public void enqueue(Object obj) {
        p1.push(obj);
    }
    public Object dequeue() throws PilhaVaziaException {
        if (isEmpty()) {
            throw new PilhaVaziaException("A fila está vazia");
        } else {
            while (!p1.isEmpty()) {
                p2.push(p1.pop());
            }
            Object temp = p2.pop();
            while (!p2.isEmpty()) {
                p1.push(p2.pop());
            }
            return temp;
        }
    }
    public Object first() throws PilhaVaziaException {
        if (isEmpty()) {
            throw new PilhaVaziaException("A fila está vazia");
        } else {
            while (!p1.isEmpty()) {
                p2.push(p1.pop());
            }
            Object primeiro = p2.top();
            while (!p2.isEmpty()) {
                p1.push(p2.pop());
            }
            return primeiro;
        }
    }
    public int size() {
        return p1.size();
    }
    public boolean isEmpty() {
        return p1.isEmpty();
    }
}