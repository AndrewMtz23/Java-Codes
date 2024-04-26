import java.util.Scanner;

public class view {

    public static void main(String[] args) {
        Controller controller = new Controller();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bienvenido, Seleccione la Opccion que desea Ingresar");
            System.out.println("1. Demostrar Binarios ");
            System.out.println("2. Sumar Digitos ");
            System.out.println("0. para Finalizar");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                while (true) {
                    System.out.println("Bienvenido ");
                    System.out.print("Ingrese tu Numero: ");
                    int numero = scanner.nextInt();
                    if (numero == 1234567890) {
                        System.out.println("Programa Finalizado.");
                        break;
                    }
                    if (controller.esBinario(numero)) {
                        System.out.println(" El Numero " + numero + " Es un Número binario.");
                    } else {
                        System.out.println(" El Numero " + numero +" No es un Número binario.");
                    }
                    System.out.println(); 
                }
        
                scanner.close();
                    break;
                case 2:
                    controller.ejecutarSumaDigitos();
                    break;

                case 0:
                    System.out.println("Programa Finalizado.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. ingrese una valida manix.");
            }

            System.out.println();
        }
    }
}
