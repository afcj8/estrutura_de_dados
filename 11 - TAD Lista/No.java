public class No {
    private Object elemento;
    private No anterior, proximo;
    public No(Object elemento, No anterior, No proximo) {
        this.elemento = elemento;
        this.anterior = anterior;
        this.proximo = proximo;
    }
    public No(Object elemento) {
        this.elemento = elemento;
        this.proximo = null;
        this.anterior = null;
    }
    public No() { }
    public Object getElemento() {
        return elemento;
    }
    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }
    public No getAnterior() {
        return anterior;
    }
    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }
    public No getProximo() {
        return proximo;
    }
    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
}