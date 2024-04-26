import java.util.Scanner;

public class Controller {

    public void ejecutarSumaNaturales() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Ingrese tu Numero: ");
            int numeroN = scanner.nextInt();

            int resultado = sumaNaturales(numeroN);
            System.out.println("La Suma de los Números de 1 hasta " + numeroN + " Es: " + resultado);

            System.out.print("¿Deseas Calcular otro Número? (Sí/No): ");
            String respuesta = scanner.next().toLowerCase();

            if (respuesta.equals("no")) {
                break;
            }
        }
        scanner.close();
    }

    public int sumaNaturales(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + sumaNaturales(n - 1);
        }
    }

    public void ejecutarContadorDigitos() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Ingresa un Número: ");
            int numeroIngresado = scanner.nextInt();

            if (numeroIngresado == 0) {
                System.out.println("Fin");
                break;
            }

            int cantidadDigitos = contarDigitos(numeroIngresado);
            System.out.println("El número " + numeroIngresado + " tiene " + cantidadDigitos + " dígitos.");
        }
        scanner.close();
    }

    public int contarDigitos(int numero) {
        if (Math.abs(numero) < 10) {
            return 1;
        } else {
            return 1 + contarDigitos(numero / 10);
        }
    }

    public void ejecutarPotenciaNumerosRecursiva() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Ingresa tu Numero: ");
            double base = scanner.nextDouble();

            System.out.print("Ingrese el Exponente para tu Numero: ");
            int exponente = scanner.nextInt();

            double resultado = calcularPotencia(base, exponente);
            System.out.println("El Numero " + base + " Elevado a la " + exponente + " es: " + resultado);

            System.out.print("¿Desea Calcular otro Numero? (Sí/No): ");
            String respuesta = scanner.next().toLowerCase();

            if (respuesta.equals("no")) {
                break;
            }
        }
        scanner.close();
    }

    public double calcularPotencia(double base, int exponente) {
        if (exponente == 0) {
            return 1;
        } else {
            return base * calcularPotencia(base, exponente - 1);
        }
    }
}
