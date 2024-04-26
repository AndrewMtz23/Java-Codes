import java.util.Scanner;
//Aqui tengo el Main
class ControladorMatriz {

    //Crear una matriz de n * m filas (cargar n y m por teclado) debera:
    //Que imprima la Matriz completa, el Numero Mayor y que se cambien la fila 2 y 3

    private ModeloMatriz modelo; private VistaMatriz vista; private Scanner scanner;

    public ControladorMatriz(ModeloMatriz modelo, VistaMatriz vista, Scanner scanner) {
        this.modelo = modelo;
        this.vista = vista;
        this.scanner = scanner;
    }

    public void iniciar() {
        vista.mostrarMensaje("Ingrese el número de filas:");
        int n = scanner.nextInt();
        vista.mostrarMensaje("Ingrese el número de columnas:");
        int m = scanner.nextInt();

        modelo.crearMatriz(n, m);

        boolean continuar = true;
        while (continuar) {
            vista.mostrarMensaje("\n1. Imprimir matriz completa");
            vista.mostrarMensaje("2. Imprimir el elemento mayor");
            vista.mostrarMensaje("3. Intercambiar la segunda fila con la tercera fila");
            vista.mostrarMensaje("4. Salir");
            vista.mostrarMensaje("Ingrese su elección:");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    vista.mostrarMatriz(modelo.obtenerMatriz());
                    break;
                case 2:
                    vista.mostrarMensaje("Elemento Mayor Es: " + modelo.obtenerElementoMayor());
                    break;
                case 3:
                    modelo.intercambiarFilas(1, 2);
                    vista.mostrarMensaje("Las Filas han Sido Intercambiadas.");
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Por favor, seleccione nuevamente.");
            }
        }
    }

    public static void main(String[] args) {
        ModeloMatriz modelo = new ModeloMatriz();
        VistaMatriz vista = new VistaMatriz();
        Scanner scanner = new Scanner(System.in);
        ControladorMatriz controlador = new ControladorMatriz(modelo, vista, scanner);
        controlador.iniciar();
        scanner.close();
    }


}
