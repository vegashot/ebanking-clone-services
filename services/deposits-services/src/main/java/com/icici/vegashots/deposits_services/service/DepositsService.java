package com.icici.vegashots.deposits_services.service;

import com.icici.vegashots.deposits_services.dto.CreateDepositAccountRequest;
import com.icici.vegashots.deposits_services.dto.DepositAccountDetailRequest;
import com.icici.vegashots.deposits_services.dto.DepositAccountDetailResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

public interface DepositsService {

    ResponseEntity<?> getDepositAccountDetail(String bankId, String custId, Long accountId);

    ResponseEntity<?> createDepositAccount(@Valid CreateDepositAccountRequest createDepositAccountRequest);

    ResponseEntity<?> getDepositAccountsList(String bankId, String custId);
}
