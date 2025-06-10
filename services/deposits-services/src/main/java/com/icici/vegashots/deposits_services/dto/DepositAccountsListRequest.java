package com.icici.vegashots.deposits_services.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DepositAccountsListRequest {
    @NotBlank
    @NotNull(message = "bankId cannot be null")
    private String bankId;

    @NotBlank
    @NotNull(message = "custId cannot be null")
    private String custId;

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
}
