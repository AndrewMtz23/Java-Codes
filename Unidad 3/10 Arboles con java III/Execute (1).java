import java.util.Scanner;

public class Execute {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tree tree = new Tree(scanner);

        System.out.println("Ingrese el valor inicial del árbol:");
        int valorInicial = scanner.nextInt();
        tree.insert(valorInicial);

        while (true) {
            System.out.println("1. Insertar valor");
            System.out.println("2. Buscar valor");
            System.out.println("3. Eliminar nodo");
            System.out.println("4. Recorrido preorden");
            System.out.println("5. Salir");
            System.out.println("Ingrese la opción:");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el valor a insertar:");
                    int valorInsertar = scanner.nextInt();
                    tree.insert(valorInsertar);
                    break;
                case 2:
                    System.out.println("Ingrese el valor a buscar:");
                    int valorBuscar = scanner.nextInt();
                    Node nodo = tree.search(valorBuscar);
                    if (nodo != null) {
                        System.out.println("Valor encontrado en el árbol.");
                    } else {
                        System.out.println("Valor no encontrado en el árbol.");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el valor a eliminar:");
                    int valorEliminar = scanner.nextInt();
                    tree.delete(valorEliminar);
                    break;
                case 4:
                    tree.preorder();
                    break;
                case 5:
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}
