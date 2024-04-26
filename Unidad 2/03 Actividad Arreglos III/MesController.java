import java.util.Scanner;

public class MesController {
    public static int obtenerNumeroMesDesdeUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de mes (1-12): ");
        return scanner.nextInt();
    }

    public static void mostrarResultado(int dias, String nombreMes) {
        if (dias == -1) {
            System.out.println("Número de mes inválido.");
        } else {
            System.out.println("El mes de " + nombreMes + " tiene " + dias + " días.");
        }
    }
}
