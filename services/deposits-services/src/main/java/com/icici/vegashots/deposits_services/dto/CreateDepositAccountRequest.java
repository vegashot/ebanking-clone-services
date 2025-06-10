package com.icici.vegashots.deposits_services.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateDepositAccountRequest {
    @NotBlank
    @NotNull(message = "bankId cannot be null")
    private String bankId;

    @NotBlank
    @NotNull(message = "custId cannot be null")
    private String custId;

    @NotBlank
    @NotNull(message = "accountType cannot be null")
    private String accountType;

    @NotBlank
    @NotNull(message = "maturityDate cannot be null")
    private String maturityDate;

    @NotBlank
    @NotNull(message = "creationDate cannot be null")
    private String creationDate;

    @NotNull(message = "interestRate cannot be null")
    private double interestRate;

    @NotNull(message = "principalAmount cannot be null")
    private double principalAmount;

    @NotNull(message = "maturityAmount cannot be null")
    private double maturityAmount;

    @NotBlank
    @NotNull(message = "profile cannot be null")
    private String profile;

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(String maturityDate) {
        this.maturityDate = maturityDate;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(double principalAmount) {
        this.principalAmount = principalAmount;
    }

    public double getMaturityAmount() {
        return maturityAmount;
    }

    public void setMaturityAmount(double maturityAmount) {
        this.maturityAmount = maturityAmount;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
