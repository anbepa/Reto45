package com.testautomation.sop.models;

public class WidgetsFechaHoraModel {

    private String idCaso;
    private String dateAndTime;

    public WidgetsFechaHoraModel(String idCaso, String dateAndTime) {
        this.idCaso = idCaso;
        this.dateAndTime = dateAndTime;
    }

    public String getIdCaso() {
        return idCaso;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }
}
