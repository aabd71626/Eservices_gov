package com.eservices.gov.ps.models;

public class Differences {
    private String dateTime;
    private String payableSalaries;
    private String total;

    public Differences() {
    }

    public Differences(String dateTime, String payableSalaries, String total) {
        this.dateTime = dateTime;
        this.payableSalaries = payableSalaries;
        this.total = total;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getPayableSalaries() {
        return payableSalaries;
    }

    public void setPayableSalaries(String payableSalaries) {
        this.payableSalaries = payableSalaries;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
