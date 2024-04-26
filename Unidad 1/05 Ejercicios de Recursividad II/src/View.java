import java.util.Scanner;

public class View {

    public static void main(String[] args) {
        Controller controller = new Controller();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione un Ejercicio a Ejecutar:");
            System.out.println("1. Eje.8: Suma de Números");
            System.out.println("2. Eje.9: Contador de Dígitos");
            System.out.println("3. Eje.10: Potencia de Números");
            System.out.println("0. Finalizar Programa");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    controller.ejecutarSumaNaturales();
                    break;
                case 2:
                    controller.ejecutarContadorDigitos();
                    break;
                case 3:
                    controller.ejecutarPotenciaNumerosRecursiva();
                    break;
                case 0:
                    System.out.println("Programa Finalizado.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Error, Seleccione una opción válida.");
            }
        }
    }
}
