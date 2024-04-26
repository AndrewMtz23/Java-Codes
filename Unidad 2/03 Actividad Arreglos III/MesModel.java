public class MesModel {
    private static final int[] diasPorMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String[] nombresMeses = {"", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

    public static int obtenerDias(int numeroMes) {
        if (numeroMes >= 1 && numeroMes <= 12) {
            return diasPorMes[numeroMes];
        } else {
            return -1; // -1 indica que el número de mes es inválido
        }
    }

    public static String obtenerNombreMes(int numeroMes) {
        if (numeroMes >= 1 && numeroMes <= 12) {
            return nombresMeses[numeroMes];
        } else {
            return "Mes inválido";
        }
    }
}
