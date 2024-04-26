import java.util.Scanner;

public class Multiplos {

    public static void asignaValores(int[] num, int TAMANIO, int num_multiplo) {
        for (int i = 0; i < TAMANIO; i++) {
            num[i] = num_multiplo * (i + 1);
        }
    }

    public static void mostrarArray(int[] num, int TAMANIO) {
        for (int i = 0; i < TAMANIO; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int TAMANIO;
        int num_multiplo;

        System.out.print("Introduce el tamaño del array: ");
        TAMANIO = scanner.nextInt();

        // Definimos el array
        int[] num = new int[TAMANIO];

        // Definimos el número con el que rellenaremos el array con sus multiplos
        System.out.print("Introduce el Número con el que Rellenar: ");
        num_multiplo = scanner.nextInt();

        // Invocamos a las funciones
        asignaValores(num, TAMANIO, num_multiplo);
        mostrarArray(num, TAMANIO);
    }
}
