import java.util.Scanner;

public class AutolavadoVista {
    private Scanner scanner;

    public AutolavadoVista() {
        scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("    ");
        System.out.println("Bienvenido al Auto Lavado");
        System.out.println("1. Registrar Nuevo Auto");
        System.out.println("2. Lavar Auto");
        System.out.println("3. Ver cola de Espera");
        System.out.println("4. Ver Autos Lavados");
        System.out.println("5. Salir");
        System.out.print("Ingrese una Opción: ");
        return scanner.nextInt();
    }

    public Auto solicitarDatosAuto() {
        System.out.print("Ingrese el modelo del auto: ");
        String modelo = scanner.next();
        System.out.print("Ingrese la placa del auto: ");
        String placa = scanner.next();
        return new Auto(modelo, placa);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarAutos(Iterable<Auto> autos) {
        for (Auto auto : autos) {
            System.out.println(auto);
        }
    }

    public static void main(String[] args) {
        AutolavadoModelo modelo = new AutolavadoModelo();
        AutolavadoVista vista = new AutolavadoVista();
        AutolavadoControlador controlador = new AutolavadoControlador(modelo, vista);
        controlador.iniciar();
    }
}
