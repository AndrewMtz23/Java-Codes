import java.util.Scanner;

public class Tree {
    Node root;
    Scanner scanner;

    public Tree(Scanner scanner) {
        this.root = null;
        this.scanner = scanner;
    }

    public void insert(int val) {
        if (root == null) {
            root = new Node(val);
            return;
        }

        Node currentNode = root;
        while (true) {
            System.out.println("¿En qué lado de " + currentNode.val + " desea insertar el valor? (/ para izquierda, \\ para derecha, fin para terminar)");
            String lado = scanner.next();
            if (lado.equalsIgnoreCase("fin")) {
                break;
            }
            if (lado.equals("/")) {
                
                if (currentNode.left == null) {
                    currentNode.left = new Node(val);
                    break;
                } else {
                    currentNode = currentNode.left;
                }

            } else if (lado.equals("\\")) {

                if (currentNode.right == null) {
                    currentNode.right = new Node(val);
                    break;
                } else {
                    currentNode = currentNode.right;
                }

            } else {
                System.out.println("Opción no válida.");
            }
        }
    }

    public void insertIzquierda(Node root, int val) {
        if (root.left == null) {
            root.left = new Node(val);
        } else {
            System.out.println("Ya existe un nodo en el lado izquierdo de " + root.val);
        }
    }

    public void insertDerecha(Node root, int val) {
        if (root.right == null) {
            root.right = new Node(val);
        } else {
            System.out.println("Ya existe un nodo en el lado derecho de " + root.val);
        }
    }

    // Método para recorrer el árbol en orden
    public void inorder(Node root, String espacio) {
        if (root != null) {
            inorder(root.right, espacio + "   ");
            System.out.println(espacio + "/-- " + root.val);
            inorder(root.left, espacio + "   ");
        }
    }
}
