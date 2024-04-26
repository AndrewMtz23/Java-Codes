import java.util.Scanner;

public class Tree {
    Node root;
    Scanner scanner;

    public Tree(Scanner scanner) {
        this.root = null;
        this.scanner = scanner;
    }

    public void insert(int val) {
        root = insertRec(root, val);
    }

    private Node insertRec(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }

        System.out.println("¿En qué lado de " + root.val + " desea insertar el valor? (1 para izquierda, 2 para derecha):");
        int lado = scanner.nextInt();
        if (lado == 1) {
            root.left = insertRec(root.left, val);
        } else if (lado == 2) {
            root.right = insertRec(root.right, val);
        } else {
            System.out.println("Opción no válida.");
        }

        return root;
    }

    public Node search(int val) {
        return searchRec(root, val);
    }

    private Node searchRec(Node root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        if (val < root.val) {
            return searchRec(root.left, val);
        }

        return searchRec(root.right, val);
    }

    public void delete(int val) {
        root = deleteRec(root, val);
    }

    private Node deleteRec(Node root, int val) {
        if (root == null) {
            return root;
        }

        if (val < root.val) {
            root.left = deleteRec(root.left, val);
        } else if (val > root.val) {
            root.right = deleteRec(root.right, val);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.val = minValue(root.right);

            root.right = deleteRec(root.right, root.val);
        }

        return root;
    }

    private int minValue(Node root) {
        int minv = root.val;
        while (root.left != null) {
            minv = root.left.val;
            root = root.left;
        }
        return minv;
    }

    public void preorder() {
        System.out.println("Recorrido preorden:   ");
        preorderRec(root);
        System.out.println("     ");
    }

    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    public void inorder(Node root, String espacio, boolean esDerecho) {
        if (root != null) {
            String direccion = esDerecho ? "└── " : "├── ";
            String nuevoEspacio = espacio + (esDerecho ? "    " : "│   ");
            inorder(root.right, nuevoEspacio, false);
            System.out.println(espacio + direccion + root.val);
            inorder(root.left, nuevoEspacio, true);
        }
    }
}
