package com.testautomation.sop.models.entitys;


import com.testautomation.sop.models.builders.DatosPruebaDataBuilder;

public class DatosPruebaFormModels {


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAge() {
        return age;
    }

    public String getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    private  String firstName;

    public String getTypeSearch() {
        return typeSearch;
    }

    private  String lastName;
    private  String email;
    private  String age;
    private  String salary;
    private  String department;
    private  String typeSearch;

    public String getSelectDate() {
        return selectDate;
    }



    private  String selectDate;
    private  String date;
    private  String time;

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public DatosPruebaFormModels(DatosPruebaDataBuilder datosPruebaDataBuilder) {
        this.firstName = datosPruebaDataBuilder.getListPersona().get(0).getFirstName();
        this.lastName = datosPruebaDataBuilder.getListPersona().get(0).getLastName();
        this.email = datosPruebaDataBuilder.getListPersona().get(0).getEmail();
        this.age = datosPruebaDataBuilder.getListPersona().get(0).getAge();
        this.salary = datosPruebaDataBuilder.getListPersona().get(0).getSalary();
        this.department = datosPruebaDataBuilder.getListPersona().get(0).getDepartment();
        this.typeSearch = datosPruebaDataBuilder.getListPersona().get(0).getTypeSearch();
        this.selectDate = datosPruebaDataBuilder.getListPersona().get(0).getSelectDate();
        this.date = datosPruebaDataBuilder.getListPersona().get(0).getDate();
        this.time = datosPruebaDataBuilder.getListPersona().get(0).getTime();


    }


}
