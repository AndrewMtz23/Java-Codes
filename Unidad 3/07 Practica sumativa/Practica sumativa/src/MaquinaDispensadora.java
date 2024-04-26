public class MaquinaDispensadora {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        while (true) {
            System.out.println("1. Agregar pedido");
            System.out.println("2. Atender pedido");
            System.out.println("3. Ver pedidos pendientes");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = Integer.parseInt(System.console().readLine());

            switch (opcion) {
                case 1:
                    controlador.agregarPedido();
                    break;
                case 2:
                    controlador.atenderPedido();
                    break;
                case 3:
                    controlador.verPedidosPendientes();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }
}
