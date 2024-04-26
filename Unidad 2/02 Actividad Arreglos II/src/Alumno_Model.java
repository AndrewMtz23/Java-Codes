public class Alumno_Model {
    //Este we encapsula la Estructura del Valedor
    private String nombre;
    private double notaNumerica;
    private String notaCualitativa;

    public Alumno_Model(String nombre, double notaNumerica) {
        this.nombre = nombre;
        this.notaNumerica = notaNumerica;
        asignarNotaCualitativa();
    }

    public String getNombre() {
        return nombre;
    }

    public double getNotaNumerica() {
        return notaNumerica;
    }

    public String getNotaCualitativa() {
        return notaCualitativa;
    }

    private void asignarNotaCualitativa() {
        if (notaNumerica < 5) {
            notaCualitativa = "Suspenso (NA)";
        } else if (notaNumerica < 7) {
            notaCualitativa = "Bien (SA)";
        } else if (notaNumerica < 9) {
            notaCualitativa = "Notable (DE)";
        } else {
            notaCualitativa = "Sobresaliente (AU)";
        }
    }
}
