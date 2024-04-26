public class AutolavadoControlador {
    private AutolavadoModelo modelo;
    private AutolavadoVista vista;

    public AutolavadoControlador(AutolavadoModelo modelo, AutolavadoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    Auto auto = vista.solicitarDatosAuto();
                    modelo.registrarAuto(auto);
                    vista.mostrarMensaje("Auto registrado correctamente");
                    break;
                case 2:
                    modelo.lavarAuto();
                    vista.mostrarMensaje("Auto lavado correctamente");
                    break;
                case 3:
                    vista.mostrarAutos(modelo.getColaEspera());
                    break;
                case 4:
                    vista.mostrarAutos(modelo.getAutosLavados());
                    break;
                case 5:
                    vista.mostrarMensaje("Saliendo del programa...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida");
            }
        } while (opcion != 5);
    }
}
