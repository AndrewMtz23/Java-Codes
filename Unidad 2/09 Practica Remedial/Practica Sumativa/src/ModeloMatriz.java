import java.util.Scanner;

class ModeloMatriz {
    private int[][] matriz;

    public void crearMatriz(int n, int m) {
        matriz = new int[n][m];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println("Ingrese el elemento en la posición [" + i + "][" + j + "]:");
                matriz[i][j] = scanner.nextInt();
            }
        }
    }

    public int[][] obtenerMatriz() {
        return matriz;
    }

    public int obtenerElementoMayor() {
        int mayor = matriz[0][0];
        for (int[] fila : matriz) {
            for (int elemento : fila) {
                if (elemento > mayor) {
                    mayor = elemento;
                }
            }
        }
        return mayor;
    }

    public void intercambiarFilas(int fila1, int fila2) {
        int[] temp = matriz[fila1];
        matriz[fila1] = matriz[fila2];
        matriz[fila2] = temp;
    }
}
