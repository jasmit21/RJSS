package com.example.rjss;

public class table {
    private String date;
    private String details;
    private String amount;

    public table(String date, String details, String amount) {
        this.date = date;
        this.details = details;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public String getDetails() {
        return details;
    }

    public String getAmount() {
        return amount;
    }
}
