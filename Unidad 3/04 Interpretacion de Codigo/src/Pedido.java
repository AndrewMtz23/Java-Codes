import java.util.HashMap;
import java.util.Map;

public class Pedido {
    private String nombreCliente;
    private Map<String, Double> items;

    public Pedido(String nombreCliente) {
        this.nombreCliente = nombreCliente;
        this.items = new HashMap<>();
    }

    public void agregarItem(String nombreItem, double precio) {
        items.put(nombreItem, precio);
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public Map<String, Double> getItems() {
        return items;
    }

    public double calcularTotal() {
        return items.values().stream().mapToDouble(Double::doubleValue).sum();
    }
}
