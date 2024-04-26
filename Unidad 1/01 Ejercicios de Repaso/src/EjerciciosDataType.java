import java.util.Scanner;

public class EjerciciosDataType {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("Ejercicios de Manejo de DataType");
            System.out.println("Bienvenido, Seleccione el Ejercicio a Ejecutar:");
            System.out.println("1. valor de c-a-b");
            System.out.println("2. Valor de G");
            System.out.println("3. Decadas");
            System.out.println("4. Cumpleaños Siguiente");
            System.out.println("5. Tabla del 8");
            System.out.println("0. Salir");

            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                //Ejercicio 1: ¿Cuánto vale  c – a – b  ? (siendo c=30, a=5 y b= 5) ?
                    int c = 30, a = 5, b = 5;
                    int resultado = c - a - b;
                    System.out.println("El Resultado de c-a-b Es: " + resultado);
                    break;

                case 2:
                //Ejercicio 2: Dada la siguiente secuencia de instrucciones, ¿cuánto vale g?
                //int e, f, g;
                //e=6;
                //f=7;
                //g = e * f / 2 + 5 – (e – f); 
                    int e = 6, f = 7, g;
                    g = e * f / 2 + 5 - (e - f);
                    System.out.println("El Valor de g es: " + g);
                    break;

                case 3:
                //Ejercicio 3: Solicitar a un usuario su edad y dar a conocer cuantas decadas tiene
                    System.out.println("Ingrese su Edad:");
                    int edad = scanner.nextInt();
                    int decadas = edad / 10;
                    System.out.println("Tienes " + decadas + " décadas.");
                    break;

                case 4:    
                //Ejercicio 4: Del ejercicio anterior ahora modifica para que calcule la edad que tendra al siguiente año.
                    System.out.println("Ingrese su Edad:");
                    int edad1 = scanner.nextInt();
                    int edadSiguienteAnio = edad1 + 1;
                    System.out.println("El Próximo Año Cumpliras " + edadSiguienteAnio + " años.");
                    break;

                case 5:
                // Ejercicio 5: Crear un programa que permita mostrar la tabla del 8 de forma descendente
                    System.out.println("Tabla del 8 en forma descendente:");
                    for (int i = 10; i >= 1; i--) {
                        System.out.println("8 x " + i + " = " + (8 * i));
                    }
                    break;

                case 0:
                    System.out.println("Programa Finalizado.");
                    break;

                default:
                    System.out.println("Opción no válida. Inténtelo de Nuevo.");
                    break;
                }

            } while (opcion != 0);
        scanner.close();
    }
}
