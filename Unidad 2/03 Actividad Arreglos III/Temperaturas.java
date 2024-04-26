import java.util.Scanner;

public class Temperaturas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[][] temperatura = new double[7][2];
        boolean existeTemperatura;
        int indice, cantDias = 7;
        double tempMax, tempMin;

        // Recorrido para rellenar la tabla (7 días con temp mínima y máxima)
        for (indice = 0; indice < cantDias; indice++) {
            System.out.print("Temperatura del ");
            switch (indice) {
                case 0: System.out.println("lunes"); break;
                case 1: System.out.println("martes"); break;
                case 2: System.out.println("miércoles"); break;
                case 3: System.out.println("jueves"); break;
                case 4: System.out.println("viernes"); break;
                case 5: System.out.println("sábado"); break;
                case 6: System.out.println("domingo"); break;
            }
            System.out.print("Temperatura Mínima: ");
            temperatura[indice][0] = sc.nextDouble();
            System.out.print("Temperatura Máxima: ");
            temperatura[indice][1] = sc.nextDouble();
        }

        // Mostrar temperatura media
        System.out.println("\nInformación de Temperaturas");
        System.out.println("------------------------------");
        for (indice = 0; indice < cantDias; indice++) {
            System.out.println("\nDía " + (indice + 1) + " (" + obtenerNombreDia(indice) + ")");
            System.out.println("Temperatura Mínima: " + temperatura[indice][0]);
            System.out.println("Temperatura Máxima: " + temperatura[indice][1]);
            System.out.println("Temperatura Media: " + (temperatura[indice][0] + temperatura[indice][1]) / 2);
        }

        // Calcular temperatura mínima más pequeña
        tempMin = temperatura[0][0];
        for (indice = 0; indice < cantDias; indice++) {
            if (temperatura[indice][0] < tempMin) {
                tempMin = temperatura[indice][0];
            }
        }

        // Mostrar los días con menos temperatura
        System.out.println("------------------------------");
        System.out.println("\nDías con Menos temperatura");
        System.out.println("------------------------------");
        for (indice = 0; indice < cantDias; indice++) {
            if (temperatura[indice][0] == tempMin) {
                System.out.println("Día " + (indice + 1) + " (" + obtenerNombreDia(indice) + ")");
            }
        }

        // Días con temperatura máxima cercana
        existeTemperatura = false;
        System.out.println("------------------------------");
        System.out.println("\nDía(s) con Temperatura Máxima Cercana");
        System.out.println("------------------------------");
        System.out.print("Introduce una Temperatura Máxima: ");
        tempMax = sc.nextDouble();
        double tolerancia = 0.01;

        // Crear un arreglo para almacenar las diferencias y días correspondientes
        double[][] diferencias = new double[cantDias][2];

        for (indice = 0; indice < cantDias; indice++) {
            diferencias[indice][0] = Math.abs(temperatura[indice][1] - tempMax);
            diferencias[indice][1] = indice;
        }

        // Ordenar el arreglo de diferencias de manera ascendente
        for (int i = 0; i < cantDias - 1; i++) {
            for (int j = 0; j < cantDias - i - 1; j++) {
                if (diferencias[j][0] > diferencias[j + 1][0]) {
                    // Intercambiar posiciones
                    double tempDif = diferencias[j][0];
                    diferencias[j][0] = diferencias[j + 1][0];
                    diferencias[j + 1][0] = tempDif;

                    double tempDia = diferencias[j][1];
                    diferencias[j][1] = diferencias[j + 1][1];
                    diferencias[j + 1][1] = tempDia;
                }
            }
        }

        // Mostrar los días con temperatura máxima cercana de manera ascendente
        for (int i = 0; i < cantDias; i++) {
            int dia = (int) diferencias[i][1];
            System.out.println("Día " + (dia + 1) + " (" + obtenerNombreDia(dia) + ")");
            existeTemperatura = true;
        }

        if (!existeTemperatura) {
            System.out.println("No hay ningún día con dicha temperatura máxima cercana.");
        }

        sc.close(); // Cerrar el scanner al finalizar
    }

    private static String obtenerNombreDia(int indice) {
        switch (indice) {
            case 0: return "lunes";
            case 1: return "martes";
            case 2: return "miércoles";
            case 3: return "jueves";
            case 4: return "viernes";
            case 5: return "sábado";
            case 6: return "domingo";
            default: return "Desconocido";
        }
    }
}
