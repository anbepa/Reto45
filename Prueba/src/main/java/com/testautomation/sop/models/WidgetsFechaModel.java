package com.testautomation.sop.models;

public class WidgetsFechaModel {


    private String idCaso;

    public String getIdCaso() {
        return idCaso;
    }

    public String getSelectDate() {
        return selectDate;
    }

    public WidgetsFechaModel(String idCaso, String selectDate) {
        this.idCaso = idCaso;
        this.selectDate = selectDate;
    }

    private String selectDate;




}
