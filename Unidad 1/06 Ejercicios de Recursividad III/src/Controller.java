import java.util.Scanner;

public class Controller {
    //Logica de la primera wea 
    public boolean esBinario(int numero) {
        // Esta wea aplica la recursividad del primero xd
    return esBinarioRecursivo(numero);
    }

    private boolean esBinarioRecursivo(int numero) {
        if (numero == 0 || numero == 1) {
            return true;
        }
        int ultimoDigito = numero % 10;
        return (ultimoDigito == 0 || ultimoDigito == 1) && esBinarioRecursivo(numero / 10);
    }
   
    public int contarDigitos(int numero) {
        if (Math.abs(numero) < 10) {
            return 1;
        } else {
            return 1 + contarDigitos(numero / 10);
        }
    }

    //Logia del Segundo xd
    public void ejecutarSumaDigitos() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Ingresa un Número para sumar sus dígitos: ");
            int numeroIngresado = scanner.nextInt();

            if (numeroIngresado == 0) {
                System.out.println("Fin");
                break;
            }
            int sumaDigitos = sumarDigitos(numeroIngresado);
            System.out.println("La Suma de los dígitos de " + numeroIngresado + " es: " + sumaDigitos);
        }
        scanner.close();
    }

    public int sumarDigitos(int numero) {
        if (numero == 0) {
            return 0;
        } else {
            return numero % 10 + sumarDigitos(numero / 10);
        }
    }
}
