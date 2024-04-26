public class Sucursal {
    String nombre;
    Producto[] productos;
    int cantidadArticulos;

    public Sucursal(String nombre, int cantidadArticulos) {
        this.nombre = nombre;
        this.cantidadArticulos = cantidadArticulos;
        this.productos = new Producto[cantidadArticulos];
    }

    public void agregarProducto(Producto producto, int indice) {
        productos[indice] = producto;
    }

    public int calcularTotalCompra() {
        int totalCompra = 0;
        for (int i = 0; i < cantidadArticulos; i++) {
            totalCompra += productos[i].calcularTotal();
        }
        return totalCompra;
    }

    public void mostrarRecaudacionTotal() {
        System.out.println("Recaudación total en " + nombre + ": " + calcularTotalCompra());

        for (Producto producto : productos) {
            System.out.println("Producto vendido en " + nombre + ": " + producto.nombre);
            System.out.println("Cantidad comprada: " + producto.cantidad);
            System.out.println("Cantidad restante en " + nombre + ": " + producto.cantidad);
            System.out.println("------------------------");
        }
    }
}
