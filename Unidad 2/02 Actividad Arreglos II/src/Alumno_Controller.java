import java.util.Scanner;

public class Alumno_Controller {
    //Logica del Valedor

    public static Alumno_Model crearAlumno(Scanner entrada) {
        System.out.print("Introduzca el Nombre del Alumno: ");
        String nombre = entrada.nextLine();

        double notaNumerica;
        do {
            System.out.print("Introduzca la Nota del Alumno (Entre 0 y 10): ");
            notaNumerica = Double.parseDouble(entrada.nextLine());

            if (notaNumerica < 0 || notaNumerica > 10) {
                System.out.println("Error: La Nota debe estar Entre 0 y 10. Inténtelo de Nuevo.");
            }
        } while (notaNumerica < 0 || notaNumerica > 10);

        return new Alumno_Model(nombre, notaNumerica);
    }
}
