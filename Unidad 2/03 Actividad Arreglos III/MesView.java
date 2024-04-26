public class MesView {
    public static void main(String[] args) {
        int numeroMes = MesController.obtenerNumeroMesDesdeUsuario();
        int dias = MesModel.obtenerDias(numeroMes);
        String nombreMes = MesModel.obtenerNombreMes(numeroMes);

        MesController.mostrarResultado(dias, nombreMes);
    }
}
