public class Vector implements IVector {
    private Object[] objects;
    private int tamanho, n = 0;
    public Vector(int tamanho) {
        this.tamanho = tamanho;
        objects = new Object[tamanho];
    }
    public Object elemAtRank(int r) throws VectorException {
        if (isEmpty()) {
            throw new VectorException("Vector vazio!");
        }
        if (r >= n || r < 0) {
            throw new VectorException("Índice inválido!");
        }
        return objects[r];
    }
    public Object replaceAtRank(int r, Object obj) throws VectorException {
        if (isEmpty()) {
            throw new VectorException("Vector vazio!");
        }
        if (r >= n || r < 0) {
            throw new VectorException("Índice inválido!");
        }
        Object temp = objects[r];
        objects[r] = obj;
        return temp;
    }
    public void insertAtRank(int r, Object obj) throws VectorException {
        if (r > n || r < 0) {
            throw new VectorException("índice inválido!");
        }
        if (n == tamanho) {
            tamanho *= 2;
            Object[] aux = new Object[tamanho];
            for (int i = 0; i < n; i++) {
                aux[i] = objects[i];
            }
            objects = aux;
        }
        if (r == n) {
            objects[r] = obj;
        } else {
            for (int i = n; i > r; i--) {
                objects[i] = objects[i - 1];
            }
            objects[r] = obj;
        }
        n++;
    }
    public Object removeAtRank(int r) throws VectorException {
        if (isEmpty()) {
            throw new VectorException("Vector vazio!");
        }
        if (r >= n || r < 0) {
            throw new VectorException("Índice inválido!");
        }
        Object temp = objects[r];
        for (int i = r; i < n - 1; i++) {
            objects[i] = objects[i + 1];
        }
        n--;
        return temp;
    }
    public int size() {
        return n;
    }
    public boolean isEmpty() {
        return n == 0;
    }
}