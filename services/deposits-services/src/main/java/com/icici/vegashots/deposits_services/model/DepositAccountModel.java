package com.icici.vegashots.deposits_services.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepositAccountModel {

    private String bankId;
    private String custId;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dep_seq")
    @SequenceGenerator(name = "dep_seq", sequenceName = "dep_seq", initialValue = 1000000000)
    private Long accountId;
    private String accountType;
    private String maturityDate;
    private String creationDate;
    private double interestRate;
    private double principalAmount;
    private double maturityAmount;
    private String profile;
}
