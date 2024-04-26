import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class Modelo {
    private Stack<Integer> pila;
    private Queue<Integer> cola;
    private Nodo raiz;

    public Modelo() {
        pila = new Stack<>();
        cola = new LinkedList<>();
        raiz = null;
    }

    // Métodos para operaciones con Pila
    public void insertarEnPila(int valor) {
        pila.push(valor);
    }

    public int extraerDePila() {
        if (!pila.isEmpty()) {
            return pila.pop();
        }
        throw new IllegalStateException("La pila está vacía");
    }

    public void mostrarPila() {
        System.out.println("Contenido de la pila: " + pila);
    }

    // Métodos para operaciones con Cola
    public void insertarEnCola(int valor) {
        cola.add(valor);
    }

    public int extraerDeCola() {
        if (!cola.isEmpty()) {
            return cola.poll();
        }
        throw new IllegalStateException("La cola está vacía");
    }

    public void mostrarCola() {
        System.out.println("Contenido de la cola: " + cola);
    }

    // Métodos para operaciones con Árbol Binario
    public void insertarEnArbol(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    private Nodo insertarRec(Nodo raiz, int valor) {
        if (raiz == null) {
            return new Nodo(valor);
        }
        if (valor < raiz.valor) {
            raiz.izquierda = insertarRec(raiz.izquierda, valor);
        } else if (valor > raiz.valor) {
            raiz.derecha = insertarRec(raiz.derecha, valor);
        }
        return raiz;
    }

    public void eliminarEnArbol(int valor) {
        raiz = eliminarRec(raiz, valor);
    }

    private Nodo eliminarRec(Nodo raiz, int valor) {
        if (raiz == null) {
            return null;
        }
        if (valor < raiz.valor) {
            raiz.izquierda = eliminarRec(raiz.izquierda, valor);
        } else if (valor > raiz.valor) {
            raiz.derecha = eliminarRec(raiz.derecha, valor);
        } else {
            if (raiz.izquierda == null) {
                return raiz.derecha;
            } else if (raiz.derecha == null) {
                return raiz.izquierda;
            }
            raiz.valor = minimoValor(raiz.derecha);
            raiz.derecha = eliminarRec(raiz.derecha, raiz.valor);
        }
        return raiz;
    }

    private int minimoValor(Nodo raiz) {
        int min = raiz.valor;
        while (raiz.izquierda != null) {
            min = raiz.izquierda.valor;
            raiz = raiz.izquierda;
        }
        return min;
    }

    public boolean buscarEnArbol(int valor) {
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(Nodo raiz, int valor) {
        if (raiz == null) {
            return false;
        }
        if (raiz.valor == valor) {
            return true;
        }
        return valor < raiz.valor
                ? buscarRec(raiz.izquierda, valor)
                : buscarRec(raiz.derecha, valor);
    }

    public void recorrerInorden() {
        recorrerInordenRec(raiz);
    }

    private void recorrerInordenRec(Nodo raiz) {
        if (raiz != null) {
            recorrerInordenRec(raiz.izquierda);
            System.out.print(raiz.valor + " ");
            recorrerInordenRec(raiz.derecha);
        }
    }

    public void mostrarArbol() {
        System.out.print("Recorrido inorden en árbol binario: ");
        mostrarArbolRec(raiz);
        System.out.println();
    }

    private void mostrarArbolRec(Nodo raiz) {
        if (raiz != null) {
            mostrarArbolRec(raiz.izquierda);
            System.out.print(raiz.valor + " ");
            mostrarArbolRec(raiz.derecha);
        }
    }
}
