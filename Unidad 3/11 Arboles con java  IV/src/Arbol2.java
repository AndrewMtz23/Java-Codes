import java.util.Scanner;

public class Arbol2 {
    public static Nodo crearArbol2() {
        return null; // Árbol se creará con los valores ingresados
    }

    public static Nodo llenarArbol2() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el valor para el nodo F:");
        Nodo raiz = new Nodo(scanner.next().charAt(0));
        raiz.setIzquierdo(new Nodo('F'));

        System.out.println("Ingrese el valor para el nodo L:");
        raiz.getIzquierdo().setDerecho(new Nodo(scanner.next().charAt(0)));

        System.out.println("Ingrese el valor para el nodo O:");
        raiz.setDerecho(new Nodo(scanner.next().charAt(0)));

        System.out.println("Ingrese el valor para el nodo A:");
        raiz.getDerecho().setIzquierdo(new Nodo(scanner.next().charAt(0)));

        System.out.println("Ingrese el valor para el nodo F:");
        raiz.getDerecho().setDerecho(new Nodo(scanner.next().charAt(0)));

        scanner.close();
        return raiz;
    }
}
