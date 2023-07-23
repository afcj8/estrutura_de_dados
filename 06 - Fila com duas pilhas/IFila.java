import pilha.PilhaVaziaException;

public interface IFila {
    void enqueue(Object obj);
    Object dequeue() throws PilhaVaziaException;
    Object first() throws PilhaVaziaException;
    int size();
    boolean isEmpty();
}