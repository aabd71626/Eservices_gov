package com.eservices.gov.ps.models;

public class Dues {
    private String dateTime;
    private String forDues;
    private String forEmployee;
    private String duesFunds;
    private String notes;

    public Dues() {
    }

    public Dues(String dateTime, String forDues, String forEmployee, String duesFunds, String notes) {
        this.dateTime = dateTime;
        this.forDues = forDues;
        this.forEmployee = forEmployee;
        this.duesFunds = duesFunds;
        this.notes = notes;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getForDues() {
        return forDues;
    }

    public void setForDues(String forDues) {
        this.forDues = forDues;
    }

    public String getForEmployee() {
        return forEmployee;
    }

    public void setForEmployee(String forEmployee) {
        this.forEmployee = forEmployee;
    }

    public String getDuesFunds() {
        return duesFunds;
    }

    public void setDuesFunds(String duesFunds) {
        this.duesFunds = duesFunds;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
