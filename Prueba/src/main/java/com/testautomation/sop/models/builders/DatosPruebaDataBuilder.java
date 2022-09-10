package com.testautomation.sop.models.builders;

import com.testautomation.sop.models.entitys.DatosPruebaFormModels;
import com.testautomation.sop.utils.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DatosPruebaDataBuilder implements Builder<DatosPruebaFormModels> {


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
    private  String lastName;
    private  String email;
    private  String age;

    public String getSelectDate() {
        return selectDate;
    }



    private  String salary;
    private  String department;
    private  String selectDate;

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    private  String date;
    private  String time;

    public String getTypeSearch() {
        return typeSearch;
    }

    private  String typeSearch;

    public DatosPruebaDataBuilder(Map<String,String> AgregarEliminarRegistrosDataBuilder) {
        this.firstName = AgregarEliminarRegistrosDataBuilder.get("firstName");
        this.lastName = AgregarEliminarRegistrosDataBuilder.get("lastName");
        this.email = AgregarEliminarRegistrosDataBuilder.get("email");
        this.age = AgregarEliminarRegistrosDataBuilder.get("age");
        this.salary = AgregarEliminarRegistrosDataBuilder.get("salary");
        this.department = AgregarEliminarRegistrosDataBuilder.get("department");
        this.typeSearch = AgregarEliminarRegistrosDataBuilder.get("typeSearch");
        this.selectDate = AgregarEliminarRegistrosDataBuilder.get("selectDate");
        this.date = AgregarEliminarRegistrosDataBuilder.get("date");
        this.time = AgregarEliminarRegistrosDataBuilder.get("time");
    }

    protected static DatosPruebaFormModels objcredentials2;

    private List<DatosPruebaDataBuilder> listUserData = new ArrayList<>();


    public static DatosPruebaDataBuilder PersonInformation(List<Map<String, String>> DataPerson) {
        return new DatosPruebaDataBuilder(DataPerson);
    }

    public DatosPruebaDataBuilder(List<Map<String, String>> dataCard) {

        createConstructor(dataCard);
    }



    private void createConstructor(List<Map<String, String>> dataCard) {
        for (Map<String, String> data : dataCard) {
            listUserData.add(new DatosPruebaDataBuilder(data));
        }
    }

    public static void setPersona(DatosPruebaFormModels objcredentials) {

        DatosPruebaDataBuilder.objcredentials2 = objcredentials;
    }
    @Override
    public DatosPruebaFormModels build() {
        DatosPruebaFormModels credentialsuser = new DatosPruebaFormModels(this);
        DatosPruebaDataBuilder.setPersona(credentialsuser);
        return credentialsuser;
    }

    public List<DatosPruebaDataBuilder> getListPersona() {

        return listUserData;
    }
}
