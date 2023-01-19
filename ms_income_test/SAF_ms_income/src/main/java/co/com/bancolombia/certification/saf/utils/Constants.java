package co.com.bancolombia.certification.saf.utils;

public enum Constants {

    USER("andres.padilla@merakiorg.onmicrosoft.com"),
    PASSWORD("Povo3164");

    private String value;

    private Constants(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
