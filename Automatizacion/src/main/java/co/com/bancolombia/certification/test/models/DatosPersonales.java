package co.com.bancolombia.certification.test.models;


public class DatosPersonales {

    private String nombres;
    private String apellidos;
    private String correo;
    private String mes;
    private String dia;
    private String ano;


    public DatosPersonales(String nombres, String apellidos, String correo, String mes, String dia, String ano) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.mes = mes;
        this.dia = dia;
        this.ano = ano;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public String getMes() {
        return mes;
    }

    public String getDia() {
        return dia;
    }

    public String getAno() {
        return ano;
    }
}
