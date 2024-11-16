public class No {
    private Object obj;
    private No pai, filhoEsquerdo, filhoDireito;

    public No(No pai, Object obj) {
        this.setObj(obj);
        this.setPai(pai);
    }

    public No getPai() {
        return pai;
    }

    public No getFilhoEsquerdo() {
        return filhoEsquerdo;
    }

    public No getFilhoDireito() {
        return filhoDireito;
    }

    public Object getObj() {
        return obj;
    }

    public void setPai(No pai) {
        this.pai = pai;
    }

    public void setFilhoEsquerdo(No filhoEsquerdo) {
        this.filhoEsquerdo = filhoEsquerdo;
    }

    public void setFilhoDireito(No filhoDireito) {
        this.filhoDireito = filhoDireito;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}