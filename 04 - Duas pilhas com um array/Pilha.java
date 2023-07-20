public class Pilha implements IPilha {
    private int topoV, topoP, tamanho;
    private Object[] pilha;
    public Pilha(int tamanho) {
        this.tamanho = tamanho;
        topoV = -1;
        topoP = tamanho;
        pilha = new Object[tamanho];
    }
    public void pushV(Object obj) {
        if (topoV + 1 == topoP) {
            Object[] a = new Object[tamanho * 2];
            for (int i = 0; i < topoV; i++) {
                a[i] = pilha[i];
            }
            for (int j = topoP + tamanho; j < tamanho * 2; j++) {
                a[j] = pilha[j - tamanho];
            }
            pilha = a;
            topoP += tamanho;
            tamanho *= 2;
        }
        pilha[++topoV] = obj;
    }
    public void pushP(Object obj) {
        if (topoV + 1 == topoP) {
            Object[] a = new Object[tamanho * 2];
            for (int i = 0; i < topoV; i++) {
                a[i] = pilha[i];
            }
            for (int j = topoP + tamanho; j < tamanho * 2; j++) {
                a[j] = pilha[j - tamanho];
            }
            pilha = a;
            topoP += tamanho;
            tamanho *= 2;
        }
        pilha[--topoP] = obj;
    }
    public Object popV() throws PilhaVaziaException {
        if (isEmptyV()) {
            throw new PilhaVaziaException("A pilha está vazia");
        } else {
            return pilha[topoV--];
        }
    }
    public Object popP() throws PilhaVaziaException {
        if (isEmptyP()) {
            throw new PilhaVaziaException("A pilha está vazia");
        } else {
            return pilha[topoP++];
        }
    }
    public Object topV() throws PilhaVaziaException {
        if (isEmptyV()) {
            throw new PilhaVaziaException("A pilha está vazia");
        } else {
            return pilha[topoV];
        }
    }
    public Object topP() throws PilhaVaziaException {
        if (isEmptyP()) {
            throw new PilhaVaziaException("A pilha está vazia");
        } else {
            return pilha[topoP];
        }
    }
    public boolean isEmptyV() {
        return topoV == -1;
    }
    public boolean isEmptyP() {
        return topoP == tamanho;
    }
    public int sizeV() {
        return topoV + 1;
    }
    public int sizeP() {
        return tamanho - topoP;
    }
    public void mostrar() {
        System.out.print("Pilha rubro-negra = { ");
        for (int i = 0; i <  tamanho; i++) {
            System.out.print(pilha[i] + " ");
        }
        System.out.println("}");
    }
}