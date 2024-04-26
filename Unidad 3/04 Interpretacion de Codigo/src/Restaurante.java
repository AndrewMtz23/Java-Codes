import java.util.Scanner;

public class Restaurante {
    public static void main(String[] args) {
        Cocina cocina = new Cocina();
        Scanner scanner = new Scanner(System.in);

        boolean volverMenuClientes = false;
        boolean volverMenuPedidos = false;

        do {
            System.out.println("Menú de Cliente:");
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Procesar Siguiente Cliente");
            System.out.println("3. Ver Lista de Clientes Pendientes");
            System.out.println("4. Finalizar Cliente");

            System.out.print("Ingrese una opción: ");
            int opcionCliente = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcionCliente) {
                case 1:
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombreCliente = scanner.nextLine();
                    cocina.agregarCliente(nombreCliente);
                    break;
                case 2:
                    cocina.procesarSiguienteCliente();
                    break;
                case 3:
                    cocina.verListaClientesPendientes();
                    break;
                case 4:
                    cocina.finalizarCliente();
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                    break;
            }

            System.out.print("¿Desea realizar otra operación de cliente? (s/n): ");
            volverMenuClientes = scanner.nextLine().equalsIgnoreCase("s");

            if (volverMenuClientes && cocina.hayClientesPendientes()) {
                continue; // Volver al menú de clientes si todavía hay clientes pendientes
            }

            do {
                System.out.println("\nMenú de Pedidos:");
                System.out.println("1. Agregar Pedido");
                System.out.println("2. Preparar Pedido");
                System.out.println("3. Completar Pedido");
                System.out.println("4. Volver al Menú de Clientes");

                System.out.print("Ingrese una opción: ");
                int opcionPedido = scanner.nextInt();
                scanner.nextLine(); // Consume la nueva línea

                switch (opcionPedido) {
                    case 1:
                        // Código para agregar un pedido
                        if (cocina.hayClientesPendientes()) {
                            System.out.print("Ingrese el nombre del cliente: ");
                            String nombreClientePedido = scanner.nextLine();
                            Pedido pedido = new Pedido(nombreClientePedido);
                    
                            String nombreProducto;
                            do {
                                System.out.print("Ingrese el nombre del producto (o 'fin' para terminar): ");
                                nombreProducto = scanner.nextLine();
                                if (!nombreProducto.equalsIgnoreCase("fin")) {
                                    System.out.print("Ingrese el precio del producto: ");
                                    double precioProducto = scanner.nextDouble();
                                    scanner.nextLine(); 
                                    pedido.agregarItem(nombreProducto, precioProducto);
                                }
                            } while (!nombreProducto.equalsIgnoreCase("fin"));
                    
                            cocina.agregarPedido(pedido);
                        } else {
                            System.out.println("No hay clientes pendientes para agregar pedidos.");
                        }
                        break;
                    case 2:
                        // Código para preparar un pedido
                        if (!cocina.getPedidosEnProceso().isEmpty()) {
                            cocina.prepararPedido();
                        } else {
                            System.out.println("No hay pedidos en proceso.");
                        }
                        break;
                    case 3:
                        // Código para completar un pedido
                        if (!cocina.getPedidosEnProceso().isEmpty()) {
                            cocina.completarPedido();
                        } else {
                            System.out.println("No hay pedidos en proceso.");
                        }
                        break;
                    case 4:
                        volverMenuPedidos = true;
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                        break;
                }

                if (opcionPedido == 4) {
                    break; 
                }

                System.out.print("¿Desea realizar otra operación de pedido? (s/n): ");
            } while (scanner.nextLine().equalsIgnoreCase("s"));

        } while (volverMenuClientes || volverMenuPedidos);

        scanner.close();
    }
}
