package com.mydata.example.example3.controller;

import com.mydata.example.example3.dao.AccountDao;
import com.mydata.example.example3.domain.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class AccountController {
    @Resource
    private AccountDao accountDao;

    @GetMapping("/save")
    public Account saveOne(){
        Account account = new Account();
        account.setName("LiuTao");
        account.setAmount(1000D);
        account.setCreateTime(new Date());
        accountDao.save(account);//version=1
        return account;
    }

    @GetMapping("/saveAndUpdate")
    public Account saveTwoTime(){
        Account account = new Account();
        account.setName("LiuTao");
        account.setAmount(1000D);
        account.setCreateTime(new Date());
        accountDao.save(account);//version == 1
        accountDao.update(account);//version == 2
        accountDao.update(account);//version == 3
        return account;
    }

    @GetMapping("/saveList")
    @ResponseBody
    public List<Account> saveList(){
        Account account1 = new Account();
        account1.setName("LiuTao");
        account1.setAmount(1000D);
        account1.setCreateTime(new Date());

        Account account2 = new Account();
        account2.setName("LiuTao");
        account2.setAmount(1000D);
        account2.setCreateTime(new Date());

        List<Account> list = new ArrayList<>();
        list.add(account1);
        list.add(account2);

        accountDao.saveList(list); // account1 version == 1   &&   account2 version == 1
        return list;
    }


    @GetMapping("/updateTwo")
    public String saveTwo(@RequestParam("id")Long id){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Account account = accountDao.getById(id);
                System.out.println("thread1: version = "+account.getVersion());
                try {
                    Thread.sleep(1000 * 5);
                } catch (InterruptedException e) {
                }
                account.setAmount(900D);
                accountDao.update(account);
                System.out.println("thread1: version = "+account.getVersion());
            }
        };

        Account account2 = accountDao.getById(id);
        System.out.println("thread2: version = "+account2.getVersion());

        new Thread(runnable).start();

        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
        }


        account2.setAmount(900D);
        accountDao.update(account2); // throw com.mydata.exception.ObjectOptimisticLockingFailureException
        System.out.println("thread2: version = "+account2.getVersion());

        return "ok";
    }


}
