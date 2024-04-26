import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Scanner;

public class Controlador {
    private Queue<Pedido> colaPedidos = new LinkedList<>();
    private Stack<Producto> pilaProductos = new Stack<>();
    private Scanner scanner = new Scanner(System.in);

    public Controlador() {
        // Inicializar productos disponibles
        pilaProductos.push(new Producto("Refresco", 10));
        pilaProductos.push(new Producto("Agua", 20));
        pilaProductos.push(new Producto("Galletas", 15));
    }

    public void agregarPedido() {
        System.out.print("Ingrese el producto que desea comprar: ");
        String producto = scanner.nextLine();
        colaPedidos.add(new Pedido(producto));
        System.out.println("Pedido agregado: " + producto);
    }

    public void atenderPedido() {
        if (!colaPedidos.isEmpty() && !pilaProductos.isEmpty()) {
            Pedido pedido = colaPedidos.poll();
            Producto producto = pilaProductos.pop();
            producto.setCantidad(producto.getCantidad() - 1);
            System.out.println("Se atendió el pedido de " + pedido.getProducto());
        } else {
            System.out.println("No hay pedidos pendientes o productos disponibles");
        }
    }

    public void verPedidosPendientes() {
        if (!colaPedidos.isEmpty()) {
            System.out.println("Pedidos pendientes:");
            for (Pedido pedido : colaPedidos) {
                System.out.println("- " + pedido.getProducto());
            }
        } else {
            System.out.println("No hay pedidos pendientes");
        }
    }
}
