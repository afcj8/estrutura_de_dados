public interface IFila {
    // Insere um elemento no fim da fila
    void enqueue(Object obj);
    // Remove e retorna o elemento do início da fila
    Object dequeue() throws FilaVaziaException;
    // Retorna o elemento do início sem removê-lo
    Object first() throws FilaVaziaException;
    // Retorna o número de elementos armazenados
    int size();
    // Indica se há elementos na fila
    boolean isEmpty();
}