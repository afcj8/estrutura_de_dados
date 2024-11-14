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

        // Caso o elemento tenha prioridade (elemento > 59)
        if (elemento > 59) {
            No atual = this.inicio;
            No anterior = null;

            // Encontra o último nó com prioridade (elemento > 59)
            while (atual != null && atual.getElemento() > 59) {
                anterior = atual;
                atual = atual.getProximo();
            }

            // Insere o novo nó após o último nó com prioridade
            if (anterior == null) { // Se não houver nenhum nó com prioridade
                novo.setProximo(this.inicio);
                this.inicio = novo;
            } else { // Insere o novo nó após o último nó com prioridade
                anterior.setProximo(novo);
                novo.setProximo(atual);
            }

            // Atualiza o fim da lista, se necessário
            if (novo.getProximo() == null) {
                this.fim = novo;
            }

        } else { // Caso o elemento não tenha prioridade (elemento <= 59)
            No atual = this.inicio;
            No anterior = null;

            // Encontra a posição correta para o elemento não prioritário
            while (atual != null && atual.getElemento() < 60) {
                anterior = atual;
                atual = atual.getProximo();
            }

            // Insere o novo nó no local adequado
            if (anterior == null) { // Insere no início se não houver elementos prioritários
                novo.setProximo(this.inicio);
                this.inicio = novo;
            } else { // Insere no meio ou no final, antes dos elementos prioritários
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
        System.out.print("[");
        while (atual != null) {
            System.out.print(atual.getElemento());
            atual = atual.getProximo();
            if (atual != null) {
                System.out.print(", "); // Adiciona vírgula entre os elementos
            }
        }
        System.out.println("]");
    }
}