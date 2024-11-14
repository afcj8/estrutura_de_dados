public class No {
    private int elemento;
    private No proximo;
    public No(int elemento) {
        this.elemento = elemento;
    }
    public int getElemento() {
        return this.elemento;
    }
    public No getProximo() {
        return this.proximo;
    }
    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
}