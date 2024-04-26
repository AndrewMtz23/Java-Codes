public class ControllerTeatro {
    private ModelTeatro model;
    private ViewTeatro view;

    public ControllerTeatro(ModelTeatro model, ViewTeatro view) {
        this.model = model;
        this.view = view;
    }

    public void gestionarAsientos() {
        int opcion;
        do {
            opcion = view.mostrarMenu();
            switch (opcion) {
                case 1:
                    int[] posicionReserva = view.obtenerFilaColumna();
                    model.reservarAsiento(posicionReserva[0], posicionReserva[1]);
                    break;
                case 2:
                    int[] posicionCancelacion = view.obtenerFilaColumna();
                    model.cancelarReserva(posicionCancelacion[0], posicionCancelacion[1]);
                    break;
                case 3:
                    view.mostrarEstadoAsientos(model.getAsientos());
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 4);
    }
}
