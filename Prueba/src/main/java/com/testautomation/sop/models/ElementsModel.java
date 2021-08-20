package com.testautomation.sop.models;

public class ElementsModel {
    private String idCaso;
    private String firstName;
    private String lastName;
    private String email;
    private String age;
    private String salary;
    private String department;



    public ElementsModel(String idCaso, String firstName, String lastName, String email, String age, String salary, String department) {
        this.idCaso = idCaso;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.salary = salary;
        this.department = department;

    }

    public String getIdCaso() {
        return idCaso;
    }

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
}
