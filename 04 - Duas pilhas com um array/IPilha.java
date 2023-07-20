/**
 * V -> pilha vermelha
 * P -> pilha preta
 */

public interface IPilha {
    public int sizeV();
    public int sizeP();
    public boolean isEmptyV();
    public boolean isEmptyP();
    public Object topV() throws PilhaVaziaException;
    public Object topP() throws PilhaVaziaException;
    public void pushV(Object obj);
    public void pushP(Object obj);
    public Object popV() throws PilhaVaziaException;
    public Object popP() throws PilhaVaziaException;
}