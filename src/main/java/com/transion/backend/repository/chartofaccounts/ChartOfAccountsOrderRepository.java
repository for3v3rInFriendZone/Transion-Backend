package com.transion.backend.repository.chartofaccounts;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transion.backend.model.chartofaccounts.ChartOfAccountsOrder;

@Repository
public interface ChartOfAccountsOrderRepository extends CrudRepository<ChartOfAccountsOrder, Long>{

}
