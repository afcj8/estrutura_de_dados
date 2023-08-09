package TadLista;

public interface ILista {
    // Verifica se o nó p é o primeiro
    boolean isFirst(No p) throws ListaException;
    // Verifica se nó p é o último
    boolean isLast(No p) throws ListaException;
    // Retorna o primeiro nó
    Object first() throws ListaException;
    // Retorna o último nó
    Object last() throws ListaException;
    // Retorna o nó que está depois do nó p
    Object after(No p) throws ListaException;
    // Retorna o nó que está antes do nó p
    Object before(No p) throws ListaException;
    // Substitui o objeto do nó p pelo objeto obj
    Object replaceElement(No p, Object obj) throws ListaException;
    // Troca de posição o objeto do nó p com o objeto do nó q
    void swapElements(No p, No q) throws ListaException;
    // Insere o objeto obj depois do objeto do nó p
    No insertAfter(No p, Object obj);
    // Insere o objeto obj antes do objeto do nó p
    No insertBefore(No p, Object obj);
    // Insere no início
    No insertFirst(Object obj);
    // Insere no final
    No insertLast(Object obj);
    // Remove o objeto do nó p
    Object remove(No p) throws ListaException;
    // Retorna se está vazio ou não
    boolean isEmpty() throws ListaException;
    // Retorna o tamanho
    int size();
    // Percorre a lista e imprime no console
    void percorrer();
}