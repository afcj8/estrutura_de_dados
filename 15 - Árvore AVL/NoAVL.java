public class NoAVL {
    private NoAVL pai, fd, fe;
    private Object obj;
    private int fb;
    public NoAVL(NoAVL pai, Object obj) {
        this.setElement(obj);
        this.setPai(pai);
        this.setFb(0);
    }
    public NoAVL getPai() {
        return pai;
    }
    public NoAVL getFilhoDireito() {
        return fd;
    }
    public NoAVL getFilhoEsquerdo() {
        return fe;
    }
    public Object getElement() {
        return obj;
    }
    public int getFb() {
        return fb;
    }
    public void setPai(NoAVL pai) {
        this.pai = pai;
    }
    public void setFilhoDireito(NoAVL fd) {
        this.fd = fd;
    }
    public void setFilhoEsquerdo(NoAVL fe) {
        this.fe = fe;
    }
    public void setElement(Object obj) {
        this.obj = obj;
    }
    public void setFb(int fb) {
        this.fb = fb;
    }
}