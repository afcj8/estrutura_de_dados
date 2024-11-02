public interface IPilha {
    public int size();
    public boolean isEmpty();
    public Object top() throws FilaVaziaException;
    public void push(Object obj) throws FilaVaziaException;
    public Object pop() throws FilaVaziaException;
}