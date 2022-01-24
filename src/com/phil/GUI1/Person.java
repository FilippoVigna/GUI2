package com.phil.GUI1;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Person {
    private String name;
    private String email;
    private String phonenumber;
    private LocalDate dateofbirth;

    public Person(String name, String email, String phonenumber, LocalDate dateofbirth) {
        this.name = name;
        this.email = email;
        this.phonenumber = phonenumber;
        this.dateofbirth = dateofbirth;
    }

    public Person(String name, String email, String phonenumber, String dateofbirth) {
        this.name = name;
        this.email = email;
        this.phonenumber = phonenumber;
        this.setDateofbirth(dateofbirth);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setDateofbirth(LocalDate dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public LocalDate getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = LocalDate.parse(dateofbirth, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public int getAge() {
        LocalDate today = LocalDate.now();
        Period period = Period.between(this.dateofbirth, today);
        return period.getYears();
    }
}
