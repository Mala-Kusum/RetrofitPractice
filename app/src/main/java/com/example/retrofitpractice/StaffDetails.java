package com.example.retrofitpractice;
import com.google.gson.annotations.SerializedName;

public class StaffDetails {
    @SerializedName("name")
    String NAME;
    @SerializedName("email_id")
    String EMAIL;
    @SerializedName("designation")
    String DESIGNATION;
    @SerializedName("postings")
    String ADDRESS;
    @SerializedName("office_no")
    String LANDLINE;


    public StaffDetails(){}
    public StaffDetails(String NAME, String EMAIL, String DESIGNATION, String DEPARTMENT, String ADDRESS, String MOBILE, String LANDLINE, String PASSWORD) {
        this.NAME = NAME;
        this.EMAIL = EMAIL;
        this.DESIGNATION = DESIGNATION;
        this.ADDRESS = ADDRESS;
        this.LANDLINE = LANDLINE;
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

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public void setLANDLINE(String LANDLINE) {
        this.LANDLINE = LANDLINE;
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

    public String getADDRESS() {
        return ADDRESS;
    }

    public String getLANDLINE() {
        return LANDLINE;
    }

}
