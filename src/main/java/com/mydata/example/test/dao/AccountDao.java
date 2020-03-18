package com.mydata.example.test.dao;

import com.mydata.dao.base.impl.MyData;
import com.mydata.example.test.domain.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDao extends MyData<Account> {
}
