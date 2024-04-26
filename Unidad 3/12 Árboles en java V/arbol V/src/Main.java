// Controlador
public class Main {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        arbol.construirArbol();

        System.out.println("Recorrido en postorden del árbol binario es: ");
        arbol.imprimirPostorden();
    }
}