import java.util.Scanner;
import java.util.Random;

public class Sudoku {

    public static void main(String[] args) {
        int[][] board = new int[9][9]; // Tablero de sudoku 9x9
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Inicializar el tablero con ceros (casillas vacías)
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = 0;
            }
        }

        // Generar el sudoku válido
        generateSudoku(board, random);

        // Dejar la mitad del tablero vacía
        leaveHalfEmpty(board);

        // Mostrar el tablero generado al usuario
        System.out.println("Sudoku generado:");
        printBoard(board);

        // Solicitar al usuario ingresar valores para los espacios vacíos
        System.out.println("Ingresa los valores del sudoku (0 para casillas vacías):");
        fillEmptySpaces(board, scanner);

        // Comprobar si la solución es correcta
        if (isSolutionCorrect(board)) {
            System.out.println("¡Felicidades! Has completado el Sudoku correctamente.");
        } else {
            System.out.println("Lo siento, has perdido. La solución ingresada no es correcta.");
        }
    }

    // Método para generar un sudoku válido
    private static void generateSudoku(int[][] board, Random random) {
        // Llenar la diagonal principal con números aleatorios
        for (int i = 0; i < 9; i += 3) {
            fillDiagonal(board, i, i, random);
        }

        // Medio resuelva el sudoku generao
        solveSudoku(board);
    }

    // Esta wea hace que no se resuelva por completo
    private static void leaveHalfEmpty(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    board[i][j] = 0;
                }
            }
        }
    }
    //¿Deam, que estou haciendo? jajsjajs
    // Método para llenar con números aleatorios
    private static void fillDiagonal(int[][] board, int row, int col, Random random) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num;
                do {
                    num = random.nextInt(9) + 1;
                } while (!isValid(board, row + i, col + j, num));
                board[row + i][col + j] = num;
            }
        }
    }

    // Método para verificar si un número es válido en una posición específica del tablero
    private static boolean isValid(int[][] board, int row, int col, int num) {
        // Verificar fila y columna
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        // Verificar lo de 3x3
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    // Metodo que Resuelve el Sudoku
    private static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if (solveSudoku(board)) {
                                return true;
                            } else {
                                board[row][col] = 0; // Deshacer la asignación si no conduce a una solución válida
                            }
                        }
                    }
                    return false; // No hay solución posible en esta configuracion, o ya fue
                }
            }
        }
        return true; // Si se Puedo :D
    }

    // Método para imprimir el tablero del sudoku
    private static void printBoard(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Método para llenar los espacios vacíos con valores ingresados por el usuario
    private static void fillEmptySpaces(int[][] board, Scanner scanner) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    System.out.print("Ingresa el valor para la fila " + (i + 1) + ", columna " + (j + 1) + ": ");
                    int value = scanner.nextInt();
                    if (isValid(board, i, j, value)) {
                        board[i][j] = value;
                    } else {
                        System.out.println("Valor inválido. Por favor, ingresa un valor válido.");
                        j--; // Retroceder para volver a solicitar el mismo valor
                    }
                }
            }
        }
    }

    // Método para comprobar si la solución es correcta
    private static boolean isSolutionCorrect(int[][] board) {
        // Verificar filas y columnas
        for (int i = 0; i < 9; i++) {
            boolean[] rowCheck = new boolean[10];
            boolean[] colCheck = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != 0 && rowCheck[board[i][j]]) {
                    return false;
                }
                rowCheck[board[i][j]] = true;
                if (board[j][i] != 0 && colCheck[board[j][i]]) {
                    return false;
                }
                colCheck[board[j][i]] = true;
            }
        }

        // Verificar cuadrantes 3x3
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                boolean[] quadrantCheck = new boolean[10];
                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        if (board[i][j] != 0 && quadrantCheck[board[i][j]]) {
                            return false;
                        }
                        quadrantCheck[board[i][j]] = true;
                    }
                }
            }
        }

        return true;
    }
}
