package com.mydata.example.example3.controller;

import com.mydata.example.example3.dao.AccountDao;
import com.mydata.example.example3.domain.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
public class AccountController {
    @Resource
    private AccountDao accountDao;

    @GetMapping("/saveOne")
    public String saveOne(){
        Account account = new Account();
        account.setName("LiuTao");
        account.setAmount(1000D);
        account.setCreateTime(new Date());

        accountDao.save(account);
        return "ok";
    }

    @GetMapping("/get")
    @ResponseBody
    public Account get(@RequestParam("id")Long id){
        Account account = accountDao.getById(id);
        return account;
    }

    @GetMapping("/updateTwo")
    public String saveTwo(@RequestParam("id")Long id){
        Account account = accountDao.getById(id);
        account.setAmount(900D);
        accountDao.update(account);

        account.setAmount(800D);
        accountDao.update(account);

        return "ok";
    }


}
