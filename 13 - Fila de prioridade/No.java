public class No {
    private Object elemento;
    private No proximo;
    private int prioridade;
    public No(Object elemento, int prioridade) {
        this.elemento = elemento;
        this.prioridade = prioridade;
    }
    public Object getElemento() {
        return this.elemento;
    }
    public No getProximo() {
        return this.proximo;
    }
    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
    public int getPrioridade() {
        return this.prioridade;
    }
    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }
}