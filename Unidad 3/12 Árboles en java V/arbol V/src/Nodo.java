import java.util.Scanner;

// Modelo
class Nodo {
    int valor;
    Nodo izquierda, derecha;

    Nodo(int item) {
        valor = item;
        izquierda = derecha = null;
    }
}

class ArbolBinario {
    Nodo raiz;

    ArbolBinario() {
        raiz = null;
    }

    void imprimirPostorden() {
        imprimirPostorden(raiz);
    }

    private void imprimirPostorden(Nodo nodo) {
        if (nodo == null)
            return;

        imprimirPostorden(nodo.izquierda);
        imprimirPostorden(nodo.derecha);
        System.out.print(nodo.valor + " ");
    }

    void construirArbol() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el valor de la raíz: ");
        int valorRaiz = scanner.nextInt();
        raiz = new Nodo(valorRaiz);

        boolean continuar = true;
        while (continuar) {
            System.out.print("¿Desea agregar un nodo izquierdo? (S/N): ");
            String respuesta = scanner.next();
            if (respuesta.equalsIgnoreCase("S")) {
                System.out.print("Ingrese el valor del nodo izquierdo: ");
                int valorIzquierdo = scanner.nextInt();
                insertar(raiz, valorIzquierdo, 'I');
            }

            System.out.print("¿Desea agregar un nodo derecho? (S/N): ");
            respuesta = scanner.next();
            if (respuesta.equalsIgnoreCase("S")) {
                System.out.print("Ingrese el valor del nodo derecho: ");
                int valorDerecho = scanner.nextInt();
                insertar(raiz, valorDerecho, 'D');
            }

            System.out.print("¿Desea continuar? (S/N): ");
            respuesta = scanner.next();
            continuar = respuesta.equalsIgnoreCase("S");
        }

        scanner.close();
    }

    private void insertar(Nodo nodo, int valor, char lado) {
        if (nodo == null)
            return;

        if (lado == 'I') {
            if (nodo.izquierda == null)
                nodo.izquierda = new Nodo(valor);
            else
                insertar(nodo.izquierda, valor, lado);
        } else if (lado == 'D') {
            if (nodo.derecha == null)
                nodo.derecha = new Nodo(valor);
            else
                insertar(nodo.derecha, valor, lado);
        }
    }
}


