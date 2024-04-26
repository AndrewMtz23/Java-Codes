import java.util.Scanner;

public class ViewTeatro {

    public void mostrarEstadoAsientos(char[][] asientos) {
        System.out.println("Estado de los asientos:");
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                System.out.print(asientos[i][j] + " ");
            }
            System.out.println(); // Nueva línea después de cada fila
        }
    }

    public int[] obtenerFilaColumna() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la fila del asiento: ");
        int fila = scanner.nextInt();
        System.out.print("Ingrese la columna del asiento: ");
        int columna = scanner.nextInt();
        return new int[]{fila, columna};
    }

    public int mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nMenú del Teatro:");
        System.out.println("1. Apartar asiento");
        System.out.println("2. Cancelar apartado");
        System.out.println("3. Mostrar asientos apartados");
        System.out.println("4. Salir del programa");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }
    
    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema de gestión de asientos del teatro!");

        // Crear el modelo y la vista
        ModelTeatro model = new ModelTeatro(5, 10); // Teatro con 5 filas y 10 columnas
        ViewTeatro view = new ViewTeatro();

        // Crear el controlador y gestionar los asientos
        ControllerTeatro controller = new ControllerTeatro(model, view);
        controller.gestionarAsientos();
    }
}
