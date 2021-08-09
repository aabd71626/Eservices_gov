package com.eservices.gov.ps.models;

public class Salary {
    private String num;
    private String dateTime;
    private String category;
    private String type;
    private String inBank;
    private String procedure;

    public Salary() {
    }

    public Salary(String num, String dateTime, String category, String type, String inBank) {
        this.num = num;
        this.dateTime = dateTime;
        this.category = category;
        this.type = type;
        this.inBank = inBank;
    }

    public Salary(String num, String dateTime, String category, String type, String inBank, String procedure) {
        this.num = num;
        this.dateTime = dateTime;
        this.category = category;
        this.type = type;
        this.inBank = inBank;
        this.procedure = procedure;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInBank() {
        return inBank;
    }

    public void setInBank(String inBank) {
        this.inBank = inBank;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }
}
