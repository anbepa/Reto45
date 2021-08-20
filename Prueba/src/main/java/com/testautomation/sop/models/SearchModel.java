package com.testautomation.sop.models;

public class SearchModel {

    private String typeSearch;
    private String idCaso;

    public SearchModel(String typeSearch, String idCaso) {
        this.typeSearch = typeSearch;
        this.idCaso = idCaso;
    }

    public String getTypeSearch() {
        return typeSearch;
    }

    public String getIdCaso() {
        return idCaso;
    }
}
