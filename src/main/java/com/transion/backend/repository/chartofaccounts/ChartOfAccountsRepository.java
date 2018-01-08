package com.transion.backend.repository.chartofaccounts;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transion.backend.model.chartofaccounts.ChartOfAccounts;

@Repository
public interface ChartOfAccountsRepository extends CrudRepository<ChartOfAccounts, Long>{

}
