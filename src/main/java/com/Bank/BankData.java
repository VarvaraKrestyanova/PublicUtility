package com.Bank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BankData {

    @JsonProperty("Cur_ID")
    int cur_ID;                 //170
    @JsonProperty("Date")
    String date;                //2020-10-28T00:00:00
    @JsonProperty("Cur_Abbreviation")
    String cur_Abbreviation;    //AUD
    @JsonProperty("Cur_Scale")
    int cur_Scale;              //1
    @JsonProperty("Cur_Name")
    String cur_Name;            //Австралийский доллар
    @JsonProperty("Cur_OfficialRate")
    double cur_OfficialRate;    //1.8192

    public int getCur_ID() {
        return cur_ID;
    }

    public void setCur_ID(int cur_ID) {
        this.cur_ID = cur_ID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCur_Abbreviation() {
        return cur_Abbreviation;
    }

    public void setCur_Abbreviation(String cur_Abbreviation) {
        this.cur_Abbreviation = cur_Abbreviation;
    }

    public int getCur_Scale() {
        return cur_Scale;
    }

    public void setCur_Scale(int cur_Scale) {
        this.cur_Scale = cur_Scale;
    }

    public String getCur_Name() {
        return cur_Name;
    }

    public void setCur_Name(String cur_Name) {
        this.cur_Name = cur_Name;
    }

    public double getCur_OfficialRate() {
        return cur_OfficialRate;
    }

    public void setCur_OfficialRate(double cur_OfficialRate) {
        this.cur_OfficialRate = cur_OfficialRate;
    }
}