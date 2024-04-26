public class Alumno_View {
    // Presenta la Info del Usuario: 
    public static void mostrarResultado(Alumno_Model alumno) {
        System.out.println("La nota de " + alumno.getNombre() + " es " + alumno.getNotaNumerica() + ", " + alumno.getNotaCualitativa());
    }
}

