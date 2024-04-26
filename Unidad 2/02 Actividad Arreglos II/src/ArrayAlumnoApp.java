import java.util.Scanner;

public class ArrayAlumnoApp {
    //Clase Principal
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        try {
            System.out.println("Bienvenido ");
            System.out.println("Introduzca el Número de Alumnos: ");
            int numAlumnos = Integer.parseInt(entrada.nextLine());

            Alumno_Model[] alumnos = new Alumno_Model[numAlumnos];

            System.out.println();
            for (int i = 0; i < alumnos.length; i++) {
                alumnos[i] = Alumno_Controller.crearAlumno(entrada);
            }

            for (Alumno_Model alumno : alumnos) {
                Alumno_View.mostrarResultado(alumno);
            }

        } catch (NumberFormatException e) {
            System.out.println("Error: Ingrese un número válido para el número de alumnos.");
        } finally {
            entrada.close();
        }

    }

}
