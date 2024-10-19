public interface IVector {
    // Retorna o elemento no índice r, sem removê-lo
    Object elemAtRank(int r) throws VectorException;
    // Substitui o elemento do índice r, por obj
    Object replaceAtRank(int r, Object obj) throws VectorException;
    // Insere um novo elemento obj no índice r
    void insertAtRank(int r, Object obj) throws VectorException;
    // Remove o elemento do índice r
    Object removeAtRank(int r) throws VectorException;
    // Retorna a quantidade de elementos
    int size();
    // Retorna se está vazio ou não
    boolean isEmpty();
}