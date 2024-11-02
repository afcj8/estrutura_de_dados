public interface IPilha {
    // Retorna o número de elementos armazenados
    public int size();
    // Indica se há ou não elementos na pilha
    public boolean isEmpty();
    // Retorna o último elemento inserido sem removê-lo
    public Object top() throws PilhaVaziaException;
    // Insere um elemento
    public void push(Object obj);
    // Remove e retorna o último elemento inserido
    public Object pop() throws PilhaVaziaException;
    // Esvazia a pilha
    public void empty();
}