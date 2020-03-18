package com.mydata.example.test;

import com.mydata.em.Operate;
import com.mydata.example.test.dao.AccountDao;
import com.mydata.example.test.domain.Account;
import com.mydata.helper.Param;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.mydata.helper.Param.*;
import static com.mydata.em.Operate.*;
import static com.mydata.helper.OrderBy.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Test1 {
    @Resource
    private AccountDao accountDao;


    /**
     * 保存
     * 批量保存
     */
    @Test
    @Transactional
    public void testSave() {
        Account account = new Account();
        account.setNumber("18516568898");
        account.setBalance(1000000D);
        account.setType(1);
        accountDao.save(account);

        List<Account> accountList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Account item = new Account();
            item.setNumber(100 + i + "");
            item.setBalance(1000000D);
            item.setType(1);
            accountList.add(item);
        }
        accountDao.saveList(accountList);
    }

    /**
     * 更新
     */
    @Test
    @Transactional
    public void testUpdate() {
        Account account = accountDao.getOne(Param.getParams(new Param("id", Operate.EQ, 1)));
        System.out.println(account.toString());

        account.setBalance(99999D);
        accountDao.update(account);

        Account account1 = accountDao.getById(1);
        System.out.println(account1.toString());

        Integer updated = accountDao.update(
                Param.getParams(new Param("id", Operate.EQ, 1), new Param("version", Operate.EQ, account1.getVersion())),
                Param.getMap("balance", 88888D, "version", account1.getVersion() + 1)
        );
        System.out.println(updated);


        Account account2 = accountDao.getById(1);
        System.out.println(account2.toString());
    }

    /**
     * 删除
     */
    public void testDelete() {
        Account account = accountDao.getOne(ps(p("id", EQ, 1)));
        System.out.println(account);

        if (account != null) {
            Long version = account.getVersion();
            Integer updated = accountDao.update(ps(p("id", EQ, 1), p("version", EQ, version)), m("del", true, "version", version + 1));
            System.out.println(updated);
            Account account1 = accountDao.getById(1);
            System.out.println(account1);
        }

        Account account2 = accountDao.getById(1);
        System.out.println(account2);
        account2.setDel(true);
        accountDao.update(account2);


    }


}
