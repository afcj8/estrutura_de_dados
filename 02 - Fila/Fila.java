package fila;

public class Fila implements IFila {
    int inicio = 0, fim = 0, tamanho;
    Object objects[];
    public Fila(int tamanho) {
        this.tamanho = tamanho;
        objects = new Object[tamanho];
    }
    public void enqueue(Object obj) {
        if (size() == tamanho - 1) {
            tamanho *= 2;
            Object[] a = new Object[tamanho];
            int i = inicio;
            for (int f = 0; f < size(); f++) {
                a[f] = objects[i];
                i = (i + 1) % tamanho;
            }
            fim = size();
            inicio = 0;
            objects = a;
        }
        objects[fim] = obj;
        fim = (fim + 1) % tamanho;
    }
    public Object dequeue() throws FilaVaziaException {
        if (isEmpty()) {
            throw new FilaVaziaException("A fila está vazia");
        } else {
            Object temp = objects[inicio];
            inicio = (inicio + 1) % tamanho;
            return temp;
        }
    }
    public Object first() throws FilaVaziaException {
        if (isEmpty()) {
            throw new FilaVaziaException("A fila está vazia");
        } else {
            return this.objects[inicio];
        }
    }
    public int size() {
        return (tamanho - inicio + fim) % tamanho;
    }
    public boolean isEmpty() {
        return fim == inicio;
    }
}