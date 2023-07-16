public interface IPilha {
    Object top() throws PilhaVaziaException;
    void push(Object obj);
    Object pop() throws PilhaVaziaException;
    boolean isEmpty();
    int size();
    void empty();
}