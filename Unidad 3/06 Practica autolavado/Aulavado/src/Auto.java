public class Auto {
    private String placa;
    private String modelo;

    public Auto(String placa, String modelo) {
        this.placa = placa;
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    @Override
    public String toString() {
        return placa + " - " + modelo;
    }
}
