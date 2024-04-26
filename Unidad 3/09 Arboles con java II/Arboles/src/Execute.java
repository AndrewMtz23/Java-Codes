import java.util.Scanner;

public class Execute {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tree tree = new Tree(scanner);

        System.out.println("Ingrese el valor inicial del árbol:");
        int valorInicial = scanner.nextInt();
        tree.insert(valorInicial);

        while (true) {
            System.out.println("Ingrese el valor a insertar (o 'fin' para terminar):");
            String input = scanner.next();
            if (input.equalsIgnoreCase("fin")) {
                break;
            }
            int valor = Integer.parseInt(input);
            tree.insert(valor);
        }

        scanner.close();

        // Imprimiendo el árbol en orden
        System.out.println("Arbol en orden:");
        tree.inorder(tree.root, "");
    }
}
