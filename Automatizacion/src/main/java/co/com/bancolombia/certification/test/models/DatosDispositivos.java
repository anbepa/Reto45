package co.com.bancolombia.certification.test.models;

public class DatosDispositivos {

    private String   computador;
    private String   version;
    private String   lenguaje;
    private String   dispositivo;
    private String   modelo;
    private String   sistema;


    public DatosDispositivos(String computador, String version, String lenguaje, String dispositivo, String modelo, String sistema) {
        this.computador = computador;
        this.version = version;
        this.lenguaje = lenguaje;
        this.dispositivo = dispositivo;
        this.modelo = modelo;
        this.sistema = sistema;
    }

    public String getComputador() {
        return computador;
    }

    public String getVersion() {
        return version;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public String getModelo() {
        return modelo;
    }

    public String getSistema() {
        return sistema;
    }
}
