import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Qué árbol desea rellenar? (1 o 2)");
        int arbol = scanner.nextInt();
        Nodo arbol1 = null, arbol2 = null;

        if (arbol == 1) {
            arbol1 = Arbol1.llenarArbol1();
        } else if (arbol == 2) {
            arbol2 = Arbol2.llenarArbol2();
        } else {
            System.out.println("Opción no válida.");
            return;
        }

        System.out.println("Arbol 1 (postorden):");
        imprimirArbolPostorden(arbol1);
        System.out.println();

        System.out.println("Arbol 2 (postorden):");
        imprimirArbolPostorden(arbol2);
        System.out.println();

        scanner.close();
    }

    public static void imprimirArbolPostorden(Nodo raiz) {
        if (raiz == null) {
            return;
        }

        imprimirArbolPostorden(raiz.getIzquierdo());
        imprimirArbolPostorden(raiz.getDerecho());
        System.out.print(raiz.getValor() + " ");
    }
}
