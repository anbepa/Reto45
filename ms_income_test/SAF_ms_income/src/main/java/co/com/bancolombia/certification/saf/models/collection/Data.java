package co.com.bancolombia.certification.saf.models.collection;

public class Data {
    private String value;
    private String number;
    private String receptionDate;
    private String clientReferent;
    private String typeAnnulment;
    private String reasonAnnulment;
    private String clientBeneficiary;
    private String payment;
    private String collectionChannel;
    private String incomeDate;
    private String receptionTime;



    public String getIncomeDate() {
        return incomeDate;
    }

    public Data(String typeAnnulment, String reasonAnnulment,String incomeDate,String receptionTime) {
        this.typeAnnulment = typeAnnulment;
        this.reasonAnnulment = reasonAnnulment;
        this.receptionTime = receptionTime;
    }

    public String getReceptionTime() {
        return receptionTime;
    }

    public Data(String value, String number, String receptionDate, String clientReferent, String clientBeneficiary, String payment, String collectionChannel) {
        this.value = value;
        this.number = number;
        this.receptionDate = receptionDate;
        this.clientReferent = clientReferent;
        this.clientBeneficiary = clientBeneficiary;
        this.payment = payment;
        this.collectionChannel = collectionChannel;
    }

    public String getTypeAnnulment() {
        return typeAnnulment;
    }

    public void setTypeAnnulment(String typeAnnulment) {
        this.typeAnnulment = typeAnnulment;
    }

    public String getReasonAnnulment() {
        return reasonAnnulment;
    }

    public void setReasonAnnulment(String reasonAnnulment) {
        this.reasonAnnulment = reasonAnnulment;
    }

    public String getCollectionChannel() {
        return collectionChannel;
    }






    public String getClientReferent() {
        return clientReferent;
    }

    public String getClientBeneficiary() {
        return clientBeneficiary;
    }

    public String getPayment() {
        return payment;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    public String getReceptionDate() {
        return receptionDate;
    }
}
