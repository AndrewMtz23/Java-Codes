import java.util.Scanner;

public class GestionSucursales {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear dos instancias de la clase Sucursal
        System.out.println("Ingrese la cantidad de artículos para la Sucursal 1:");
        int cantidadArticulos1 = scanner.nextInt();
        Sucursal sucursal1 = new Sucursal("Sucursal 1", cantidadArticulos1);
        capturarInformacion(sucursal1, scanner);

        System.out.println("Ingrese la cantidad de artículos para la Sucursal 2:");
        int cantidadArticulos2 = scanner.nextInt();
        Sucursal sucursal2 = new Sucursal("Sucursal 2", cantidadArticulos2);
        capturarInformacion(sucursal2, scanner);

        // Calcular y mostrar el total de cada sucursal y la recaudación total
        System.out.println("Total de la compra en " + sucursal1.nombre + ": " + sucursal1.calcularTotalCompra());
        sucursal1.mostrarRecaudacionTotal();

        System.out.println("Total de la compra en " + sucursal2.nombre + ": " + sucursal2.calcularTotalCompra());
        sucursal2.mostrarRecaudacionTotal();
    }

    private static void capturarInformacion(Sucursal sucursal, Scanner scanner) {
        for (int i = 0; i < sucursal.cantidadArticulos; i++) {
            System.out.println("Ingrese información para el artículo " + (i + 1) + " en " + sucursal.nombre + ":");
            System.out.println("Digite el producto:");
            scanner.nextLine();  // Limpiar el buffer antes de leer la línea
            String nombreProducto = scanner.nextLine();

            System.out.println("Digite precio:");
            int precioProducto = scanner.nextInt();

            System.out.println("Digite cantidad:");
            int cantidadProducto = scanner.nextInt();

            System.out.println("Cuantos quedan en stock?");
            int cantidadEnStock = scanner.nextInt();

            // Crear un objeto Producto y agregarlo a la sucursal
            Producto producto = new Producto(nombreProducto, precioProducto, cantidadProducto);
            sucursal.agregarProducto(producto, i);

            // Actualizar la cantidad en stock
            producto.cantidad -= cantidadProducto;
            producto.cantidad += cantidadEnStock;
        }
    }
}
