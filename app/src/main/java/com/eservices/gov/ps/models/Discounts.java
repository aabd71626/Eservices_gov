package com.eservices.gov.ps.models;

public class Discounts {
    private int num;
    private int codeNum;
    private String additionsTitle;
    private String amount;
    private String description;
    private String amountMoney;

    public Discounts() {
    }

    public Discounts(int num, int codeNum, String additionsTitle, String amount, String description, String amountMoney) {
        this.num = num;
        this.codeNum = codeNum;
        this.additionsTitle = additionsTitle;
        this.amount = amount;
        this.description = description;
        this.amountMoney = amountMoney;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getCodeNum() {
        return codeNum;
    }

    public void setCodeNum(int codeNum) {
        this.codeNum = codeNum;
    }

    public String getAdditionsTitle() {
        return additionsTitle;
    }

    public void setAdditionsTitle(String additionsTitle) {
        this.additionsTitle = additionsTitle;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAmountMoney() {
        return amountMoney;
    }

    public void setAmountMoney(String amountMoney) {
        this.amountMoney = amountMoney;
    }
}
