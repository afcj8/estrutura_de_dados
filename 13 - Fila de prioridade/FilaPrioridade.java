public class FilaPrioridade {
    private No inicio;
    private No fim;

    public FilaPrioridade() {
        this.inicio = null;
        this.fim = null;
    }

    public void inserir(int elemento) {
        No novo = new No(elemento);

        // Verifica se a lista está vazia
        if (this.inicio == null) {
            this.inicio = novo;
            this.fim = novo;
            return;
        }

        // Verifica se o elemento tem prioridade (elemento > 59)
        if (elemento > 59) {
            novo.setProximo(this.inicio);
            this.inicio = novo;
        } else {
            No atual = this.inicio;
            No anterior = null;

            // Percorre a lista até encontrar onde o elemento deve ser inserido
            while (atual != null && atual.getElemento() < 60) {
                anterior = atual;
                atual = atual.getProximo();
            }

            // Insere o novo nó no local adequado
            if (anterior == null) { // Insere no início
                novo.setProximo(this.inicio);
                this.inicio = novo;
            } else { // Insere no meio ou no final
                anterior.setProximo(novo);
                novo.setProximo(atual);
            }

            // Atualiza o fim da lista, se necessário
            if (atual == null) {
                this.fim = novo;
            }
        }
    }

    public int remover() throws FilaPrioridadeException {
        if (this.inicio == null) {
            throw new FilaPrioridadeException("Fila vazia!");
        }
        int elemento = this.inicio.getElemento();
        this.inicio = this.inicio.getProximo();
        if (this.inicio == null) {
            this.fim = null;
        }
        return elemento;
    }

    public int inicio() throws FilaPrioridadeException {
        if (this.inicio == null) {
            throw new FilaPrioridadeException("Fila vazia!");
        }
        return this.inicio.getElemento();
    }

    public boolean vazia() {
        return this.inicio == null;
    }

    public void mostrar() {
        No atual = this.inicio;
        while (atual != null) {
            System.out.println(atual.getElemento() + " - " + atual.getProximo());
            atual = atual.getProximo();
        }
    }
}