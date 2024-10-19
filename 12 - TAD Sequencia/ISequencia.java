import TadLista.No;

public interface ISequencia {
    // Métodos VECTOR
    No elemAtRank(int r) throws Excecao;
    Object replaceAtRank(int r, Object obj) throws Excecao;
    No insertAtRank(int r, Object obj) throws Excecao;
    Object removeAtRank(int r) throws Excecao;
    // Métodos "PONTE"
    No atRank(int r) throws Excecao;
    int rankOf(No n);
}