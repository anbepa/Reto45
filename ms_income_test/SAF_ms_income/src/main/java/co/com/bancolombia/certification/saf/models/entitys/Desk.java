package co.com.bancolombia.certification.saf.models.entitys;


import co.com.bancolombia.certification.saf.models.builders.DeskDataBuilder;

public class Desk {


    private final String principalBalance;
    private final String remunerativeBalance;
    private final String moratoriumBalance;
    private final String state;
    private final String producto;
    private final String proceso;
    private final String evento;
    private final String escenario;
    private final String movimiento;
    private final String tipo;
    private final String concepto;
    private final String valor;

    public String getProducto() {
        return producto;
    }

    public String getProceso() {
        return proceso;
    }

    public String getEvento() {
        return evento;
    }

    public String getEscenario() {
        return escenario;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public String getTipo() {
        return tipo;
    }

    public String getConcepto() {
        return concepto;
    }

    public String getValor() {
        return valor;
    }




    public Desk(DeskDataBuilder deskDataBuilder) {


        this.principalBalance = deskDataBuilder.getPrincipalBalance();
        this.remunerativeBalance = deskDataBuilder.getRemunerativeBalance();
        this.moratoriumBalance = deskDataBuilder.getMoratoriumBalance();
        this.state = deskDataBuilder.getState();
        this.producto = deskDataBuilder.getProducto();
        this.proceso = deskDataBuilder.getProceso();
        this.evento = deskDataBuilder.getEvento();
        this.escenario = deskDataBuilder.getEscenario();
        this.movimiento = deskDataBuilder.getMovimiento();
        this.tipo = deskDataBuilder.getTipo();
        this.concepto = deskDataBuilder.getConcepto();
        this.valor = deskDataBuilder.getValor();
    }


    public String getPrincipalBalance() {
        return principalBalance;
    }

    public String getRemunerativeBalance() {
        return remunerativeBalance;
    }

    public String getMoratoriumBalance() {
        return moratoriumBalance;
    }

    public String getState() {
        return state;
    }


}
