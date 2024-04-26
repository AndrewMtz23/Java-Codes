import java.util.Scanner;
import java.util.Stack;

public class PilasController {

    public static void main(String[] args) {
        Stack<String> pila = new Stack<>();

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Bienvenido");
            System.out.println("1. Agregar nombre a la pila");
            System.out.println("2. Quitar último nombre de la pila");
            System.out.println("3. Mostrar nombres en la pila");
            System.out.println("4. Mostrar elemento con más caracteres en la pila");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese un nombre para la pila: ");
                    String nombre = scanner.nextLine();
                    pila.push(nombre);
                    PilasView.mostrarMensaje("Nombre agregado a la pila correctamente");
                    break;
                case 2:
                    if (!pila.isEmpty()) {
                        String elementoEliminado = pila.pop();
                        PilasView.mostrarMensaje("Nombre eliminado de la pila: " + elementoEliminado);
                    } else {
                        PilasView.mostrarMensaje("La pila está vacía, no se puede eliminar ningún nombre");
                    }
                    break;
                case 3:
                    Stack<String> pilaInversa = new Stack<>();
                    for (int i = pila.size() - 1; i >= 0; i--) {
                        pilaInversa.push(pila.get(i));
                    }
                    PilasView.mostrarPila(pilaInversa);
                    break;
                case 4:
                    if (!pila.isEmpty()) {
                        String elementoConMasCaracteres = "";
                        for (String elemento : pila) {
                            if (elemento.length() > elementoConMasCaracteres.length()) {
                                elementoConMasCaracteres = elemento;
                            }
                        }
                        PilasView.mostrarElementoConMasCaracteres(elementoConMasCaracteres);
                    } else {
                        PilasView.mostrarMensaje("La pila está vacía");
                    }
                    break;
                case 5:
                    PilasView.mostrarMensaje("Saliendo del programa...");
                    break;
                default:
                    PilasView.mostrarMensaje("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }

        } while (opcion != 5);
        scanner.close();
    }
}
