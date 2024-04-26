public class Producto {
    String nombre;
    int precio;
    int cantidad;

    public Producto(String nombre, int precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int calcularTotal() {
        return precio * cantidad;
    }
}
