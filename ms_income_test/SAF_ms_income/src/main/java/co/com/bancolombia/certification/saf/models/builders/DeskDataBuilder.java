package co.com.bancolombia.certification.saf.models.builders;

import co.com.bancolombia.certification.saf.models.entitys.Desk;
import co.com.bancolombia.certification.saf.utils.Builder;



public class DeskDataBuilder implements Builder<Desk> {


    private  String remunerativeBalance;
    private  String moratoriumBalance;
    private  String state;
    private  String principalBalance;
    private  String producto;
    private  String proceso;
    private  String evento;
    private  String escenario;
    private  String movimiento;
    private  String tipo;
    private  String concepto;
    private  String valor;



    @Override
    public Desk build(){
        return new Desk(this);
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



    public DeskDataBuilder withPrincipalBalance(String principalBalance) {
        this.principalBalance = principalBalance;
        return this;
    }
    public DeskDataBuilder withRemunerativeBalance(String remunerativeBalance) {
        this.remunerativeBalance = remunerativeBalance;
        return this;
    }

    public DeskDataBuilder withMoratoriumBalance(String moratoriumBalance) {
        this.moratoriumBalance = moratoriumBalance;
        return this;
    }
    public DeskDataBuilder withState(String state) {
        this.state = state;
        return this;
    }



    public DeskDataBuilder withProducto(String producto) {
        this.producto = producto;
        return this;
    }
    public DeskDataBuilder withProceso(String proceso) {
        this.proceso = proceso;
        return this;
    }

    public DeskDataBuilder withValor(String valor) {
        this.valor = valor;
        return this;
    }
    public DeskDataBuilder withEvento(String evento) {
        this.evento = evento;
        return this;
    }
    public DeskDataBuilder withEscenario(String escenario) {
        this.escenario = escenario;
        return this;
    }
    public DeskDataBuilder withMovimiento(String movimiento) {
        this.movimiento = movimiento;
        return this;
    }

    public DeskDataBuilder withTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }
    public DeskDataBuilder withConcepto(String concepto) {
        this.concepto = concepto;
        return this;
    }



    public Desk debitAnnulment(){
        withProducto("Confirming");
        withProceso("Aplicación de pago");
        withEvento("Aplicación de pago obligación al día solo a capital");
        withEscenario("Anulación");
        withMovimiento("1410054480");
        withTipo("DEBIT");
        withConcepto("Valor a Aplicar Capital");
        withValor("1500000");
        return build();
    }

    public Desk credit(){
        withProducto("Confirming");
        withProceso("Aplicación de pago");
        withEvento("Aplicación de pago obligación al día solo a capital");
        withEscenario("Creación");
        withMovimiento("1410054480");
        withTipo("CREDIT");
        withConcepto("Valor a Aplicar Capital");
        withValor("1500000.0");
        return build();
    }

    public Desk creditAnnulment(){
        withProducto("Confirming");
        withProceso("Aplicación de pago");
        withEvento("Aplicación de pago obligación al día solo a capital");
        withEscenario("Anulación");
        withMovimiento("2990054441");
        withTipo("CREDIT");
        withConcepto("Valor a Aplicar Cartera");
        withValor("1500000");
        return build();
    }




    public Desk scenaryOneObligationAnnulment(){
        withPrincipalBalance("1500000.0000");
        withRemunerativeBalance("0.0000");
        withMoratoriumBalance("0.0000");
        withState("CURRENT");
        return build();
    }

    public Desk scenaryTwoObligation(){
        withPrincipalBalance("0.0000");
        withRemunerativeBalance("0.0000");
        withMoratoriumBalance("0.0000");
        withState("CANCELED");
        return build();
    }

    public Desk scenaryTwoObligationAnnulment(){
        withPrincipalBalance("1700000.0000");
        withRemunerativeBalance("208.4600");
        withMoratoriumBalance("0.0000");
        withState("CURRENT");
        return build();
    }

    public static DeskDataBuilder inThe(){
        return new DeskDataBuilder();
    }

    public static DeskDataBuilder withNumber(){
        return new DeskDataBuilder();
    }
}
