import java.util.Scanner;

public class numeroView {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        numeroControlador controlNumero = new numeroControlador();
        boolean salir = false;

        while (!salir) {
            System.out.println("Que Opcion Deseas utilizar");
            System.out.println("1. Utilizar un Arreglo");
            System.out.println("2. Utilizar un ArrayList");
            System.out.println("3. Salir del Programa");

            int opcionPrincipal = leer.nextInt();

            switch (opcionPrincipal) {
                
                case 3 -> {
                    System.out.println("Gracias por usar mi Programa.");
                    salir = true;
                }

                case 1 -> {
                    // Utilizar un arreglo
                    boolean continuar = true;
                    
                    while (continuar) {
                        System.out.println("Menu de opciones");
                        System.out.println("1. Ingresar un nuevo numero");
                        System.out.println("2. Buscar un numero");
                        System.out.println("3. Eliminar un numero");
                        System.out.println("4. Mostrar el arreglo");
                        System.out.println("5. Volver al menu principal");
                        System.out.println("Que opcion deseas realizar:");

                        int opcion = leer.nextInt();

                        switch (opcion) {
                            
                            case 1 -> {
                                System.out.println("Dame el Numero que Quieres Registrar:");
                                int numero = leer.nextInt();

                                if (controlNumero.agregarArreglo(numero)) {
                                    System.out.println("El Guardado Exitoso");
                                } else {
                                    System.err.println("No se pueden agregar mas numeros, el arreglo esta lleno.");
                                }
                            }
   
                            case 2 -> {
                                System.out.println("Ingresa el numero a buscar:");
                                int numeroB = leer.nextInt();
                                int posicionJ = controlNumero.buscarArreglo(numeroB);

                                if (posicionJ != -1) {
                                    System.out.println("El numero '" + numeroB + "' se encuentra en tu arreglo");
                                } else {
                                    System.out.println("El numero '" + numeroB + "' no se encontro en el arreglo.");
                                }
                            }
      
                            case 3 -> {
                                System.out.println("Ingresa el numero que deseas eliminar:");
                                int numeroEliminar = leer.nextInt();

                                if (controlNumero.eliminarArreglo(numeroEliminar)) {
                                    System.out.println("el numero " + numeroEliminar + "se encontro y fue eliminado exitosamente.");
                                } else {
                                    System.err.println("No se encontro el numero " + numeroEliminar + " en el arreglo.");
                                }

                            }

                            case 4 -> {

                                String contenidoArreglo = controlNumero.obtenerArreglo();
                                System.out.println("Contenido del arreglo:\n" + contenidoArreglo);
                            }

                            case 5 -> {
                                System.out.println("Volviendo al Menu Principal.");
                                continuar = false;
                            }

                            default -> System.err.println("La Opcion no es valida.");
                        }
                    }
                }
                   
                case 2 -> {
                    boolean continuar1 = true;

                    while (continuar1) {
                        System.out.println("1. Ingresar Numero");
                        System.out.println("2. Buscar un Numero");
                        System.out.println("3. Eliminar Numero");
                        System.out.println("4. Mostrar ArrayList");
                        System.out.println("5. Volver al Menu");
                        System.out.println("¿Que Opcion deseas Realizar:");
                        int opcion = leer.nextInt();
                        
                        switch (opcion) {
                            case 1 -> {
                                System.out.println("Dame el numero que quieres registrar:");
                                int numero = leer.nextInt();
                                if (controlNumero.agregarArrayList(numero)) {
                                    System.out.println("Guardado exitoso");
                                } else {
                                    System.err.println("El ArrayList esta lleno.");
                                }
                            }
                                   
                            case 2 -> {
                                System.out.println("Ingresa el numero a buscar:");
                                int numeroBuscar = leer.nextInt();
                                int posicionJ1 = controlNumero.buscarArrayList(numeroBuscar);

                                if (posicionJ1 != -1) {
                                    System.out.println("El numero '" + numeroBuscar + "' se encuentro en el arraylist");
                                } else {
                                    System.out.println("El numero '" + numeroBuscar + "' no se encontro en el arraylist.");
                                }
                            }
                                  
                            case 3 -> {
                                System.out.println("Ingresa el Numero que deseas eliminar del ArrayList:");
                                int numeroEliminarArrayList = leer.nextInt();

                                if (controlNumero.eliminarArrayList(numeroEliminarArrayList)) {
                                    System.out.println("El numero " + numeroEliminarArrayList + " se encontro y fue eliminado exitosamente.");
                                } else {
                                    System.err.println("No se encontro el numero " + numeroEliminarArrayList + " en el ArrayList.");
                                }
                            } 
                                
                            case 4 -> {
                                String contenidoArrayList = controlNumero.obtenerArrayList();
                                System.out.println("Contenido del ArrayList:\n" + contenidoArrayList);

                            }
                                 
                            case 5 -> {
                                System.out.println("Volviendo al menu principal.");
                                continuar1 = false;
                            }
                            default -> System.err.println("La Opcion no es válida.");
                        }
                    }
                }

                default -> System.err.println("La Opcion no es Valida.");
            }
        }
    }
}
