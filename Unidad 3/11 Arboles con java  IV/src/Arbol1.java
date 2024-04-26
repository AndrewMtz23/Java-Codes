import java.util.Scanner;

public class Arbol1 {
    public static Nodo crearArbol1() {
        return null; // Árbol se creará con los valores ingresados
    }

    public static Nodo llenarArbol1() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el valor para el nodo B:");
        Nodo raiz = new Nodo(scanner.next().charAt(0));
        raiz.setIzquierdo(new Nodo('B'));

        System.out.println("Ingrese el valor para el nodo C:");
        raiz.getIzquierdo().setDerecho(new Nodo(scanner.next().charAt(0)));

        System.out.println("Ingrese el valor para el nodo D:");
        raiz.setDerecho(new Nodo(scanner.next().charAt(0)));

        System.out.println("Ingrese el valor para el nodo E:");
        raiz.getDerecho().setIzquierdo(new Nodo(scanner.next().charAt(0)));

        System.out.println("Ingrese el valor para el nodo F:");
        raiz.getDerecho().setDerecho(new Nodo(scanner.next().charAt(0)));

        scanner.close();
        return raiz;
    }
}
