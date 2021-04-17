package com.example.android_final_project.clients;

public class Client {
    private String clientFullName;
    private String  clientIdentification;
    private String  clientCompanyCode;
    private String  clientPhoneNumber;
    private String  clientEmail;

    public Client(String clientFullName, String clientIdentification, String clientCompanyCode, String clientPhoneNumber, String clientEmail) {
        this.clientFullName = clientFullName;
        this.clientIdentification = clientIdentification;
        this.clientCompanyCode = clientCompanyCode;
        this.clientPhoneNumber = clientPhoneNumber;
        this.clientEmail = clientEmail;
    }

    public String getClientFullName() {
        return clientFullName;
    }

    public void setClientFullName(String clientFullName) {
        this.clientFullName = clientFullName;
    }

    public String getClientIdentification() {
        return clientIdentification;
    }

    public void setClientIdentification(String clientIdentification) {
        this.clientIdentification = clientIdentification;
    }

    public String getClientCompanyCode() {
        return clientCompanyCode;
    }

    public void setClientCompanyCode(String clientCompanyCode) {
        this.clientCompanyCode = clientCompanyCode;
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }
}
