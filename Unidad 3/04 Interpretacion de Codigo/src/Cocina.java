import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Cocina {
    private Queue<String> clientesPendientes;
    private Stack<Pedido> pedidosEnProceso;

    public Cocina() {
        clientesPendientes = new LinkedList<>();
        pedidosEnProceso = new Stack<>();
    }

    public void agregarCliente(String nombreCliente) {
        clientesPendientes.offer(nombreCliente);
        System.out.println("Cliente " + nombreCliente + " agregado a la lista.");
    }

    public void procesarSiguienteCliente() {
        if (!clientesPendientes.isEmpty()) {
            String cliente = clientesPendientes.poll();
            System.out.println("Procesando siguiente cliente: " + cliente);
        } else {
            System.out.println("No hay clientes pendientes.");
        }
    }

    public void verListaClientesPendientes() {
        System.out.println("Clientes pendientes:");
        for (String cliente : clientesPendientes) {
            System.out.println(cliente);
        }
    }

    public void finalizarCliente() {
        if (!clientesPendientes.isEmpty()) {
            String cliente = clientesPendientes.poll();
            System.out.println("Cliente " + cliente + " finalizado.");
        } else {
            System.out.println("No hay clientes pendientes.");
        }
    }

    public void agregarPedido(Pedido pedido) {
        pedidosEnProceso.push(pedido);
        System.out.println("Pedido de " + pedido.getNombreCliente() + " agregado a la lista.");
    }

    public void prepararPedido() {
        if (!pedidosEnProceso.isEmpty()) {
            Pedido pedido = pedidosEnProceso.peek();
            System.out.println("Preparando pedido de " + pedido.getNombreCliente() + ": " + pedido.getItems());
        } else {
            System.out.println("No hay pedidos en proceso.");
        }
    }

    public void completarPedido() {
        if (!pedidosEnProceso.isEmpty()) {
            Pedido pedido = pedidosEnProceso.pop();
            double totalAPagarPedido = pedido.getItems().values().stream().mapToDouble(Double::doubleValue).sum();
            System.out.println("Pedido completado para " + pedido.getNombreCliente() + ": " + pedido.getItems());
            System.out.println("Total a pagar: " + totalAPagarPedido);
        } else {
            System.out.println("No hay pedidos en proceso.");
        }
    }

    public boolean hayClientesPendientes() {
        return !clientesPendientes.isEmpty();
    }

    public Stack<Pedido> getPedidosEnProceso() {
        return pedidosEnProceso;
    }
}
