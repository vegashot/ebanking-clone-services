package com.icici.vegashots.deposits_services.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DepositAccountDetailRequest {

        @NotBlank
        @NotNull(message = "bankId cannot be null")
        private String bankId;

        @NotBlank
        @NotNull(message = "custId cannot be null")
        private String custId;

        @NotNull(message = "accountId cannot be null")
        private Long accountId;

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

        public Long getAccountId() {
            return accountId;
        }

        public void setAccountId(Long accountId) {
            this.accountId = accountId;
        }

}
