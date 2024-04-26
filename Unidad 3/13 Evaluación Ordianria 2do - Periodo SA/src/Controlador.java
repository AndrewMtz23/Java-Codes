public class Controlador {
    private Vista vista;
    private Modelo modelo;

    public Controlador() {
        vista = new Vista();
        modelo = new Modelo();
    }

    public void iniciar() {
        while (true) {
            int opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    operacionesConPila();
                    break;
                case 2:
                    operacionesConCola();
                    break;
                case 3:
                    operacionesConArbol();
                    break;
                case 4:
                    vista.mostrarMensaje("Saliendo del programa...");
                    System.exit(0);
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida");
                    break;
            }
        }
    }

    private void operacionesConPila() {
        int opcion;
        do {
            vista.mostrarMensaje("\nOperaciones con Pila:");
            vista.mostrarMensaje("1. Insertar en pila");
            vista.mostrarMensaje("2. Extraer de pila");
            vista.mostrarMensaje("3. Mostrar pila");
            vista.mostrarMensaje("4. Volver al menú principal");
            opcion = vista.leerValor();
            switch (opcion) {
                case 1:
                    int valorPila = vista.leerValor();
                    modelo.insertarEnPila(valorPila);
                    break;
                case 2:
                    try {
                        int valorExtraido = modelo.extraerDePila();
                        vista.mostrarMensaje("Valor extraído de la pila: " + valorExtraido);
                    } catch (IllegalStateException e) {
                        vista.mostrarMensaje("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    modelo.mostrarPila();
                    break;
            }
        } while (opcion != 4);
    }

    private void operacionesConCola() {
        int opcion;
        do {
            vista.mostrarMensaje("\nOperaciones con Cola:");
            vista.mostrarMensaje("1. Insertar en cola");
            vista.mostrarMensaje("2. Extraer de cola");
            vista.mostrarMensaje("3. Mostrar cola");
            vista.mostrarMensaje("4. Volver al menú principal");
            opcion = vista.leerValor();
            switch (opcion) {
                case 1:
                    int valorCola = vista.leerValor();
                    modelo.insertarEnCola(valorCola);
                    break;
                case 2:
                    try {
                        int valorExtraido = modelo.extraerDeCola();
                        vista.mostrarMensaje("Valor extraído de la cola: " + valorExtraido);
                    } catch (IllegalStateException e) {
                        vista.mostrarMensaje("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    modelo.mostrarCola();
                    break;
            }
        } while (opcion != 4);
    }

    private void operacionesConArbol() {
        int opcion;
        do {
            vista.mostrarMensaje("\nOperaciones con Árbol Binario:");
            vista.mostrarMensaje("1. Insertar en árbol binario");
            vista.mostrarMensaje("2. Eliminar de árbol binario");
            vista.mostrarMensaje("3. Buscar en árbol binario");
            vista.mostrarMensaje("4. Recorrer inorden en árbol binario");
            vista.mostrarMensaje("5. Mostrar árbol");
            vista.mostrarMensaje("6. Volver al menú principal");
            opcion = vista.leerValor();
            switch (opcion) {
                case 1:
                    int valorArbol = vista.leerValor();
                    modelo.insertarEnArbol(valorArbol);
                    break;
                case 2:
                    int valorEliminar = vista.leerValor();
                    modelo.eliminarEnArbol(valorEliminar);
                    break;
                case 3:
                    int valorBuscar = vista.leerValor();
                    boolean encontrado = modelo.buscarEnArbol(valorBuscar);
                    vista.mostrarMensaje("El valor " + valorBuscar + (encontrado ? " sí" : " no") + " está en el árbol binario");
                    break;
                case 4:
                    vista.mostrarMensaje("Recorrido inorden en árbol binario:");
                    modelo.recorrerInorden();
                    break;
                case 5:
                    modelo.mostrarArbol();
                    break;
            }
        } while (opcion != 6);
    }

    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        controlador.iniciar();
    }
}
