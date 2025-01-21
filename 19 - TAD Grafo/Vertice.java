public class Vertice {
    private String nome;
    private int indice;
    
    public Vertice(String nome, int indice) {
        this.nome = nome;
        this.indice = indice;
    }
    
    public String getNome() {
        return nome;
    }
    
    public int getIndice() {
        return indice;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setIndice(int indice) {
        this.indice = indice;
    }
}