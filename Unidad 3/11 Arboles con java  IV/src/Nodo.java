public class Nodo {
    private char valor;
    private Nodo izquierdo;
    private Nodo derecho;

    public Nodo(char valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
    }

    public char getValor() {
        return valor;
    }

    public Nodo getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Nodo getDerecho() {
        return derecho;
    }

    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }
}
