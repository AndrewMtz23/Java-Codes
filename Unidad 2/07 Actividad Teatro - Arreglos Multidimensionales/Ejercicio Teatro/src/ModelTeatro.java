import java.util.Arrays;

public class ModelTeatro {
    private char[][] asientos;

    public ModelTeatro(int filas, int columnas) {
        asientos = new char[filas][columnas];
        // Inicializar todos los asientos como disponibles ('O')
        for (char[] fila : asientos) {
            Arrays.fill(fila, 'O');
        }
    }

    public boolean reservarAsiento(int fila, int columna) {
        if (fila < 0 || fila >= asientos.length || columna < 0 || columna >= asientos[0].length) {
            System.out.println("El asiento seleccionado está fuera de los límites del teatro.");
            return false;
        }
        if (asientos[fila][columna] == 'O') {
            asientos[fila][columna] = 'X'; // Asiento reservado
            System.out.println("Asiento reservado correctamente.");
            return true;
        } else {
            System.out.println("Lo sentimos, ese asiento ya está ocupado.");
            return false;
        }
    }

    public boolean cancelarReserva(int fila, int columna) {
        if (fila < 0 || fila >= asientos.length || columna < 0 || columna >= asientos[0].length) {
            System.out.println("El asiento seleccionado está fuera de los límites del teatro.");
            return false;
        }
        if (asientos[fila][columna] == 'X') {
            asientos[fila][columna] = 'O'; // Asiento disponible
            System.out.println("Reserva cancelada correctamente.");
            return true;
        } else {
            System.out.println("No se puede cancelar la reserva. El asiento no está reservado.");
            return false;
        }
    }

    public char[][] getAsientos() {
        return asientos;
    }
}
