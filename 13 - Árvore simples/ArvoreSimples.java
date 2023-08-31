import java.util.ArrayList;
import java.util.Iterator;

public class ArvoreSimples {
    // Atributos da árvore
    No raiz;
    int tamanho;
    private ArrayList<No> aux;
    // Construtor
    public ArvoreSimples(Object o) {
        raiz = new No(null, o);
        tamanho = 1;
    }
    // Retorna a raiz da árvore
    public No root() {
        return raiz;
    }
    // Retorna o No pai de um No
    public No parent(No v) {
        return v.parent();
    }
    // Retorna os filhos de um No
    public Iterator children(No v) {
        return v.children();
    }
    // Testa se um No é interno
    public boolean isInternal(No v)	{
        return (v.childrenNumber() > 0);
    }
    // Testa se um No é externo
    public boolean isExternal(No v)	{
        return (v.childrenNumber() == 0);
    }
    // Testa se um No é a raiz
    public boolean isRoot(No v) {
        return v == raiz;
    }
    // Adiciona um filho a um No
    public No addChild(No v, Object o) {
        No novo = new No(v, o);
        v.addChild(novo);
        tamanho++;
        return novo;
    }
    /** Remove um No
     *  Só pode remover Nos externos e que tenham um pai (não seja raiz)
     */
    public Object remove(No v) throws InvalidNoException {
        No pai = v.parent();
        if (pai != null || isExternal(v))
            pai.removeChild(v);
        else
            throw new InvalidNoException();
        Object o = v.element();
        tamanho--;
        return o;
    }
    // Substitui e retorna o objeto do nó v pelo objeto o
    public Object replace(No v, Object o)	{
        Object temp = v.element();
        v.setElement(o);
        return temp;
    }
    // Troca dois elementos de posição
    public void swapElements(No v, No w) {
        Object aux = v.element();
        v.setElement(w.element());
        w.setElement(aux);
    }
    // Retorna a profundidade de um No
    public int depth(No v) {
        int profundidade = profundidade(v);
        return profundidade;
    }
    private int profundidade(No v) {
        if (v == raiz)
            return 0;
        else
            return 1 + profundidade(parent(v));
    }
    // Retorna a altura da árvore
    public int height(No v) {
        if (isExternal(v)) {
            return 0;
        }
        int h = 0;
        Iterator filhos = children(v);
        while (filhos.hasNext()) {
            h = Math.max(h, height((No)filhos.next()));
        }
        return 1 + h;
    }
    private void preOrdem(No v) {
        aux.add(v); // visite
        Iterator filhos = children(v);
        while (filhos.hasNext()) {
            preOrdem((No)filhos.next());
        }
    }
    // Retorna um iterator com os elementos armazenados na árvore
    public Iterator elements() {
        aux = new ArrayList<No>();
        preOrdem(raiz);
        return aux.iterator();
    }
    // Retorna um iterator com as posições (Nos) da árvore
    public Iterator nos() {
        aux = new ArrayList<No>();
        preOrdem(raiz);
        return aux.iterator();
    }
    // Retorna o número de elementos da árvore
    public int size() {
        return tamanho;
    }
    // Retorna se a ávore está vazia. Sempre vai ser falso, pois não permitimos remover a raiz
    public boolean isEmpty() {
        return false;
    }
}