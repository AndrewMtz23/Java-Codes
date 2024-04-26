import java.util.*;

public class PilasColasController {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Bienvenido?");
        System.out.println("¿Cual Deseas Utilizar?");
        System.out.println("1. Usar Pilas");
        System.out.println("2. Usar Colas");
        System.out.print("Seleccione una opción: ");
        int opcionEstructura = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        if (opcionEstructura == 1) {
            Stack<String> pila = new Stack<>();
            menuPilas(scanner, pila);
        } else if (opcionEstructura == 2) {
            Queue<String> cola = new LinkedList<>();
            menuColas(scanner, cola);
        } else {
            System.out.println("Opción no válida. Saliendo del programa...");
        }
        scanner.close();
    }

    public static void menuPilas(Scanner scanner, Stack<String> pila) {
        int opcion;

        do {
            System.out.println("    ");
            System.out.println("Menu: Parte de Pilas");
            System.out.println("    ");
            System.out.println("1. Agregar nombre a la pila");
            System.out.println("2. Quitar nombre de la pila");
            System.out.println("3. Mostrar nombres en la pila en orden inverso");
            System.out.println("4. Mostrar elemento con más caracteres en la pila");
            System.out.println("5. Verificar si la pila está vacía");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese un nombre para la pila: ");
                    String nombre = scanner.nextLine();
                    pila.push(nombre);
                    System.out.println("Nombre agregado a la pila correctamente");
                    break;
                case 2:
                    if (!pila.isEmpty()) {
                        String elementoEliminado = pila.pop();
                        System.out.println("Nombre eliminado de la pila: " + elementoEliminado);
                    } else {
                        System.out.println("La pila está vacía, no se puede eliminar ningún nombre");
                    }
                    break;
                case 3:
                    Stack<String> pilaInversa = new Stack<>();
                    for (int i = pila.size() - 1; i >= 0; i--) {
                        pilaInversa.push(pila.get(i));
                    }
                    System.out.println("Nombres en la pila en orden inverso: " + pilaInversa);
                    break;
                case 4:
                    if (!pila.isEmpty()) {
                        String elementoConMasCaracteres = "";
                        for (String elemento : pila) {
                            if (elemento.length() > elementoConMasCaracteres.length()) {
                                elementoConMasCaracteres = elemento;
                            }
                        }
                        System.out.println("Elemento con más caracteres en la pila: " + elementoConMasCaracteres);
                    } else {
                        System.out.println("La pila está vacía");
                    }
                    break;
                case 5:
                    System.out.println("La pila está vacía: " + pila.isEmpty());
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }

        } while (opcion != 6);
    }

    public static void menuColas(Scanner scanner, Queue<String> cola) {
        int opcion;

        do {
            System.out.println("    ");
            System.out.println("Menu: Parte de Colas");
            System.out.println("    ");
            System.out.println("1. Agregar nombre a la cola");
            System.out.println("2. Quitar nombre de la cola");
            System.out.println("3. Mostrar nombres en la cola");
            System.out.println("4. Verificar si la cola está vacía");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese un nombre para la cola: ");
                    String nombre = scanner.nextLine();
                    cola.offer(nombre);
                    System.out.println("Nombre agregado a la cola correctamente");
                    break;
                case 2:
                    if (!cola.isEmpty()) {
                        String elementoEliminado = cola.poll();
                        System.out.println("Nombre eliminado de la cola: " + elementoEliminado);
                    } else {
                        System.out.println("La cola está vacía, no se puede eliminar ningún nombre");
                    }
                    break;
                case 3:
                    System.out.println("Nombres en la cola: " + cola);
                    break;
                case 4:
                    System.out.println("La cola está vacía: " + cola.isEmpty());
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }

        } while (opcion != 5);
    }
}
