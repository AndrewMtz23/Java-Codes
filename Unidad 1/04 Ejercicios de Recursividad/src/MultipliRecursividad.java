public class MultipliRecursividad {

    int factor;

    void tabla(int x) {
        if (x > 0) {
            factor = x;
            for (int i = 10; i >= 1; i--) {
                int resultado = (i * factor);
                System.out.println(i + " * " + factor + " = " + resultado);
            }
            tabla(x - 1);
        }
    }

    public static void main(String[] args) {
        MultipliRecursividad mur = new MultipliRecursividad();
        mur.tabla(8);
    }
}
