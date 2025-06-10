package com.icici.vegashots.deposits_services.repo;

import com.icici.vegashots.deposits_services.model.DepositAccountModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepositsRepository extends JpaRepository<DepositAccountModel,Long> {

    List<DepositAccountModel> findAllByCustId(String custId);
}

