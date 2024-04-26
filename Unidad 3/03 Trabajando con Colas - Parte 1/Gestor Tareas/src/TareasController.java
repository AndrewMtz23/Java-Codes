import java.util.*;

public class TareasController {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<String> tareasPendientes = new LinkedList<>();
        Stack<String> tareasEnProceso = new Stack<>();

        int opcion;
        do {
            System.out.println("    ");
            System.out.println("Gestor de Tareas");
            System.out.println("1. Agregar tarea pendiente"); //ya esta xd
            System.out.println("2. Procesar siguiente tarea");
            System.out.println("3. Finalizar tarea actual");
            System.out.println("4. Ver todas las tareas pendientes");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    agregarTarea(tareasPendientes, scanner);
                    break;
                case 2:
                    procesarSiguienteTarea(tareasPendientes, tareasEnProceso);
                    break;
                case 3:
                    finalizarTareaActual(tareasEnProceso);
                    break;
                case 4:
                    verTareasPendientes(tareasPendientes);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }

        } while (opcion != 6);

        scanner.close();
    }
    public static void agregarTarea(Queue<String> tareasPendientes, Scanner scanner) {
        System.out.print("Ingrese la tarea pendiente: ");
        String nuevaTarea = scanner.nextLine();
        tareasPendientes.offer(nuevaTarea);
        System.out.println("Tarea agregada correctamente");
    }

    public static void procesarSiguienteTarea(Queue<String> tareasPendientes, Stack<String> tareasEnProceso) {
        if (!tareasPendientes.isEmpty()) {
            String tareaActual = tareasPendientes.poll();
            tareasEnProceso.push(tareaActual);
            System.out.println("Tarea '" + tareaActual + "' en proceso");
        } else {
            System.out.println("No hay tareas pendientes");
        }
    }

    public static void finalizarTareaActual(Stack<String> tareasEnProceso) {
        if (!tareasEnProceso.isEmpty()) {
            String tareaFinalizada = tareasEnProceso.pop();
            System.out.println("Tarea '" + tareaFinalizada + "' finalizada");
        } else {
            System.out.println("No hay tareas en proceso");
        }
    }

    public static void verTareasPendientes(Queue<String> tareasPendientes) {
        System.out.println("--- Tareas Pendientes ---");
        int index = 1;
        for (String tarea : tareasPendientes) {
            System.out.println(index + ". " + tarea);
            index++;
        }
    }
}

