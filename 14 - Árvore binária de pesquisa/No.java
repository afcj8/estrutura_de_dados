public class No {
    private No pai, fd, fe;
    private Object obj;
    public No(No pai, Object obj) {
        this.pai = pai;
        this.obj = obj;
    }
    public No getPai() {
        return pai;
    }
    public No getFilhoDireito() {
        return fd;
    }
    public No getFilhoEsquerdo() {
        return fe;
    }
    public Object getElement() {
        return obj;
    }
    public void setPai(No pai) {
        this.pai = pai;
    }
    public void setFilhoDireito(No fd) {
        this.fd = fd;
    }
    public void setFilhoEsquerdo(No fe) {
        this.fe = fe;
    }
    public void setElement(Object obj) {
        this.obj = obj;
    }
}