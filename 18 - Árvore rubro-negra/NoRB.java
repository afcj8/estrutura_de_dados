public class NoRB {
    private NoRB pai, fd, fe;
    private Object obj;
    private String cor;
    public NoRB(NoRB pai, Object obj) {
        this.pai = pai;
        this.obj = obj;
        this.cor = "R";
    }
    public NoRB getPai() {
        return pai;
    }
    public NoRB getFilhoDireito() {
        return fd;
    }
    public NoRB getFilhoEsquerdo() {
        return fe;
    }
    public Object getElement() {
        return obj;
    }
    public String getCor() {
        return cor;
    }
    public void setPai(NoRB pai) {
        this.pai = pai;
    }
    public void setFilhoDireito(NoRB fd) {
        this.fd = fd;
    }
    public void setFilhoEsquerdo(NoRB fe) {
        this.fe = fe;
    }
    public void setElement(Object obj) {
        this.obj = obj;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
}