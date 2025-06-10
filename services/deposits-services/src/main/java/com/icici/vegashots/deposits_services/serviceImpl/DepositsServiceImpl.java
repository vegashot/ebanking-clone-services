package com.icici.vegashots.deposits_services.serviceImpl;

import com.icici.vegashots.deposits_services.dto.CreateDepositAccountRequest;
import com.icici.vegashots.deposits_services.dto.CreateDepositAccountResponse;
import com.icici.vegashots.deposits_services.dto.DepositAccountDetailResponse;
import com.icici.vegashots.deposits_services.dto.DepositAccountsListResponse;
import com.icici.vegashots.deposits_services.model.DepositAccountModel;
import com.icici.vegashots.deposits_services.repo.DepositsRepository;
import com.icici.vegashots.deposits_services.service.DepositsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepositsServiceImpl implements DepositsService {

    DepositsRepository depositsRepository;

    @Autowired
    DepositsServiceImpl(DepositsRepository depositsRepository){
        this.depositsRepository=depositsRepository;
    }

    @Override
    public ResponseEntity<List<DepositAccountsListResponse>> getDepositAccountsList(String bankId, String custId) {
        List<DepositAccountModel> model =  depositsRepository.findAllByCustId(custId);
        List<DepositAccountsListResponse> response = new ArrayList<>();
        for(DepositAccountModel data:model){
            DepositAccountsListResponse dto = new DepositAccountsListResponse();
            dto.setAccountId(data.getAccountId());
            dto.setCustId(data.getCustId());
            dto.setBankId(data.getBankId());
            dto.setAccountType(data.getAccountType());
            response.add(dto);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> createDepositAccount(CreateDepositAccountRequest createDepositAccountRequest) {
        DepositAccountModel depositAccountModel = new DepositAccountModel();
        depositAccountModel.setBankId(createDepositAccountRequest.getBankId());
        depositAccountModel.setCustId(createDepositAccountRequest.getCustId());
        depositAccountModel.setAccountType(createDepositAccountRequest.getAccountType());
        depositAccountModel.setMaturityDate(createDepositAccountRequest.getMaturityDate());
        depositAccountModel.setCreationDate(createDepositAccountRequest.getCreationDate());
        depositAccountModel.setInterestRate(createDepositAccountRequest.getInterestRate());
        depositAccountModel.setPrincipalAmount(createDepositAccountRequest.getPrincipalAmount());
        depositAccountModel.setMaturityAmount(createDepositAccountRequest.getMaturityAmount());
        depositAccountModel.setProfile(createDepositAccountRequest.getProfile());

        DepositAccountModel createdAccount = depositsRepository.save(depositAccountModel);
        CreateDepositAccountResponse response = new CreateDepositAccountResponse();
        response.setStatus(HttpStatus.CREATED);
        response.setMessage("Deposit account created successfully !");
        response.setAccountId(createdAccount.getAccountId());
        response.setAccountType(createdAccount.getAccountType());
        response.setMaturityAmount(createdAccount.getMaturityAmount());
        response.setMaturityDate(createdAccount.getMaturityDate());
        response.setInterestRate(createdAccount.getInterestRate());
        response.setPrincipalAmount(createdAccount.getPrincipalAmount());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getDepositAccountDetail(String bankId, String custId, Long accountId){
        Optional<DepositAccountModel> response = depositsRepository.findById(accountId);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
