package co.com.bancolombia.certification.test.models;

public class DatosDireccion {

    private String   ciudad;
    private String   codigopostal;


    public DatosDireccion(String ciudad, String codigopostal) {
        this.ciudad = ciudad;
        this.codigopostal = codigopostal;

    }

    public String getCiudad() {
        return ciudad;
    }

    public String getCodigopostal() {

        return codigopostal;
    }

}
