package com.example.retrofitpractice;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Model1 {
    @SerializedName("name")
    String NAME;
    @SerializedName("email_id")
    String EMAIL;
    @SerializedName("designation")
    String DESIGNATION;
    @SerializedName("")
    String DEPARTMENT;
    @SerializedName("postings")
    String ADDRESS;
    @SerializedName("")
    String MOBILE;
    @SerializedName("office_no")
    String LANDLINE;
    @SerializedName("")
    String PASSWORD;
    @SerializedName("")
    List<String> linked;
    public Model1(){}
    public Model1(String NAME, String EMAIL, String DESIGNATION, String DEPARTMENT, String ADDRESS, String MOBILE, String LANDLINE, String PASSWORD) {
        this.NAME = NAME;
        this.EMAIL = EMAIL;
        this.DESIGNATION = DESIGNATION;
        this.DEPARTMENT = DEPARTMENT;
        this.ADDRESS = ADDRESS;
        this.MOBILE = MOBILE;
        this.LANDLINE = LANDLINE;
        this.PASSWORD = PASSWORD;
        this.linked=new ArrayList<>();
    }
    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public void setDESIGNATION(String DESIGNATION) {
        this.DESIGNATION = DESIGNATION;
    }

    public void setDEPARTMENT(String DEPARTMENT) {
        this.DEPARTMENT = DEPARTMENT;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public void setMOBILE(String MOBILE) {
        this.MOBILE = MOBILE;
    }

    public void setLANDLINE(String LANDLINE) {
        this.LANDLINE = LANDLINE;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getNAME() {
        return NAME;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public String getDESIGNATION() {
        return DESIGNATION;
    }

    public String getDEPARTMENT() {
        return DEPARTMENT;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public String getMOBILE() {
        return MOBILE;
    }

    public String getLANDLINE() {
        return LANDLINE;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public List<String> getLinked() {
        return linked;
    }

    public void setLinked(List<String> linked) {
        this.linked = linked;
    }
}
