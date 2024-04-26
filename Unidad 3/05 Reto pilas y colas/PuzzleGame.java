package reto;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

public class PuzzleGame {

    private static final int SIZE = 3;
    private static final int EMPTY_CELL = SIZE * SIZE;
    private static final int[][] SOLVED_BOARD = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, EMPTY_CELL}
    };

    private static int[][] puzzleBoard = new int[SIZE][SIZE];
    private static Deque<int[][]> moveHistory = new ArrayDeque<>();
    private static Queue<int[][]> undoHistory = new ArrayDeque<>();

    public static void main(String[] args) {
        initializeBoard();
        shuffleBoard();

        displayObjective();  // Muestra el objetivo primero

        while (!isPuzzleSolved()) {
            displayBoard();  // Muestra el tablero después de mostrar el objetivo
            movePiece();
        }

        System.out.println("¡Felicidades! Has resuelto el puzzle.");
    }

    private static void initializeBoard() {
        int value = 1;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                puzzleBoard[i][j] = value++;
            }
        }
        puzzleBoard[SIZE - 1][SIZE - 1] = EMPTY_CELL;
    }

    private static void shuffleBoard() {
        moveHistory.clear();  // Limpiar la pila antes de barajar

        int[][] flatArray = Arrays.stream(puzzleBoard)
                .map(int[]::clone)
                .toArray(int[][]::new);

        for (int i = 0; i < SIZE * SIZE; i++) {
            int randomRow1 = (int) (Math.random() * SIZE);
            int randomCol1 = (int) (Math.random() * SIZE);

            int randomRow2 = (int) (Math.random() * SIZE);
            int randomCol2 = (int) (Math.random() * SIZE);

            int temp = flatArray[randomRow1][randomCol1];
            flatArray[randomRow1][randomCol1] = flatArray[randomRow2][randomCol2];
            flatArray[randomRow2][randomCol2] = temp;

            moveHistory.add(cloneBoard(flatArray));  // Añadir el tablero a la pila
        }

        puzzleBoard = flatArray;
    }

    private static void displayObjective() {
        int[][] orderedBoard = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, EMPTY_CELL}
        };

        System.out.println("Tu objetivo es ordenar los números de la siguiente forma:");
        displayBoard(orderedBoard, "Objetivo:");
    }

    private static void displayBoard(int[][] board, String message) {
        System.out.println(message);
        for (int[] row : board) {
            for (int tile : row) {
                System.out.print((tile == EMPTY_CELL ? " " : tile) + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void displayBoard() {
        System.out.println("Tablero actual:");
        for (int[] row : puzzleBoard) {
            for (int tile : row) {
                System.out.print((tile == EMPTY_CELL ? " " : tile) + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void movePiece() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa el número del espacio que deseas mover (1-8), o 0 para salir: ");

        try {
            int tileNumber = scanner.nextInt();

            if (tileNumber == 0) {
                System.out.println("¡Adiós! Gracias por jugar.");
                System.exit(0);
            }

            int[] tilePosition = findTile(tileNumber);
            int[] emptyPosition = findTile(EMPTY_CELL);

            if (tilePosition == null || emptyPosition == null) {
                System.out.println("Número inválido. Intenta de nuevo.");
                return;
            }

            if (isValidMove(tilePosition, emptyPosition)) {
                undoHistory.clear();
                undoHistory.add(cloneBoard(puzzleBoard));  // Guardar el tablero antes del movimiento

                puzzleBoard[emptyPosition[0]][emptyPosition[1]] = puzzleBoard[tilePosition[0]][tilePosition[1]];
                puzzleBoard[tilePosition[0]][tilePosition[1]] = EMPTY_CELL;

                moveHistory.add(cloneBoard(puzzleBoard));  // Añadir el tablero a la pila
            } else {
                System.out.println("Movimiento inválido. Intenta de nuevo.");
            }
        } catch (Exception e) {
            System.out.println("Error en la entrada. Asegúrate de ingresar un número válido.");
            scanner.next();  // Consumir la entrada incorrecta para evitar un bucle infinito
        }
    }

    // Resto del código...

    private static int[] findTile(int tile) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (puzzleBoard[i][j] == tile) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private static boolean isValidMove(int[] tilePosition, int[] emptyPosition) {
        if (tilePosition == null || emptyPosition == null) {
            return false;
        }

        int rowDiff = Math.abs(tilePosition[0] - emptyPosition[0]);
        int colDiff = Math.abs(tilePosition[1] - emptyPosition[1]);

        return (rowDiff == 1 && colDiff == 0) || (rowDiff == 0 && colDiff == 1);
    }

    private static boolean isPuzzleSolved() {
        return Arrays.deepEquals(puzzleBoard, SOLVED_BOARD);
    }

    private static int[][] cloneBoard(int[][] board) {
        int[][] clone = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            System.arraycopy(board[i], 0, clone[i], 0, SIZE);
        }
        return clone;
    }
}
