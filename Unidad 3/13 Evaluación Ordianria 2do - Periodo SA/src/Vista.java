import java.util.Scanner;

public class Vista {
    private Scanner scanner;

    public Vista() {
        scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("\nElija una opción:");
        System.out.println("1. Operaciones con Pila");
        System.out.println("2. Operaciones con Cola");
        System.out.println("3. Operaciones con Árbol Binario");
        System.out.println("4. Salir");
        return scanner.nextInt();
    }

    public int leerValor() {
        System.out.print("Ingrese un valor: ");
        return scanner.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
