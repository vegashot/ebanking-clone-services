package com.icici.vegashots.deposits_services.controller;

import com.icici.vegashots.deposits_services.dto.CreateDepositAccountRequest;
import com.icici.vegashots.deposits_services.dto.DepositAccountDetailRequest;
import com.icici.vegashots.deposits_services.dto.DepositAccountsListRequest;
import com.icici.vegashots.deposits_services.service.DepositsService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DepositsController {

    DepositsService depositsService;

    public static final Logger LOGGER = LoggerFactory.getLogger(DepositsController.class);

    @Autowired
    DepositsController(DepositsService depositsService){
        this.depositsService=depositsService;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @RequestMapping(value = "/depositAccountDetail", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> depositAccountDetail(@Valid @RequestBody DepositAccountDetailRequest depositAccountDetailRequest){
        ResponseEntity<?> response = null;
        LOGGER.info("depositAccountDetail API called" + depositAccountDetailRequest.getCustId());
        response = depositsService.getDepositAccountDetail(depositAccountDetailRequest.getBankId(),depositAccountDetailRequest.getCustId(),depositAccountDetailRequest.getAccountId());
        return response;
    }

    @RequestMapping(value = "/depositAccountsList", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> depositAccountsList(@Valid @RequestBody DepositAccountsListRequest depositAccountsListRequest){
        ResponseEntity<?> response = null;
        LOGGER.info("depositAccountsList API called" + depositAccountsListRequest.getCustId());
        response = depositsService.getDepositAccountsList(depositAccountsListRequest.getBankId(),depositAccountsListRequest.getCustId());
        return response;
    }

    @RequestMapping(value = "/createDepositAccount", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createDepositAccount(@Valid @RequestBody CreateDepositAccountRequest createDepositAccountRequest){
        ResponseEntity<?> response = null;
        LOGGER.info("createDepositAccount API called" + createDepositAccountRequest.getCustId());
        response = depositsService.createDepositAccount(createDepositAccountRequest);
        return response;
    }



}
