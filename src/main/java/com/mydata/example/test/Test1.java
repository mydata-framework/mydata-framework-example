package com.mydata.example.test;

import com.mydata.em.Operate;
import com.mydata.example.test.dao.AccountDao;
import com.mydata.example.test.domain.Account;
import com.mydata.helper.OrderBy;
import com.mydata.helper.PageData;
import com.mydata.helper.Param;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.mydata.em.Operate.EQ;
import static com.mydata.em.Operate.GT;
import static com.mydata.helper.OrderBy.o;
import static com.mydata.helper.OrderBy.os;
import static com.mydata.helper.Param.*;

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
    @Test
    @Transactional
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
        if (account2 != null) {
            System.out.println(account2);
            account2.setDel(true);
            accountDao.update(account2);
        }

        Account account3 = accountDao.getById(1);
        System.out.println(account3);


        Integer num = accountDao.deleteById(1);
        System.out.println(num);

        Integer num2 = accountDao.delete(ps(p("id", EQ, 1)));
        System.out.println(num2);

        Integer num4 = accountDao.deleteById(1, 2, 3);
        System.out.println(num4);
    }

    /**
     * count 查询
     */
    @Test
    public void testCount() {
        Long count = accountDao.getCount(null);
        System.out.println(count);

        Long count1 = accountDao.getCount(ps(p("id", GT, 100)));
        System.out.println(count1);

        Long groupbyCount = accountDao.getGroupbyCount(ps(p("id", GT, 100)), "type");
        System.out.println(groupbyCount);
    }

    /**
     * getList 查询
     */
    @Test
    public void testGetList() {
        List<Account> all = accountDao.getAll();
        System.out.println(all);

        List<Account> list1 = accountDao.getList(ps(p("id", GT, 10)));
        System.out.println(list1);

        List<Account> listOrderBy = accountDao.getListOrderBy(ps(p("id", GT, 10)), OrderBy.getOrderBys(new OrderBy("id", true)));
        System.out.println(listOrderBy);

        List<Account> listOrderBy1 = accountDao.getListOrderBy(ps(p("id", GT, 50)), os(o("id")));
        System.out.println(listOrderBy1);
    }

    @Test
    public void testGetPage(){
        Integer pageNum = 1;
        Integer pageSize = 10;
        PageData<Account> pageData = accountDao.getPageInfo(pageNum, pageSize, ps(p("id", GT, 10)));

        long totalCount = pageData.getTotalCount();
        long totalPage = pageData.getTotalPage();
        List<Account> dataList = pageData.getDataList();
        int curPage = pageData.getCurPage();
        int pageSize1 = pageData.getPageSize();
        Boolean isNext = pageData.getIsNext();
        Boolean isPrev = pageData.getIsPrev();

        System.out.println(totalCount);
        System.out.println(totalPage);
        System.out.println(dataList);
        System.out.println(curPage);
        System.out.println(pageSize1);
        System.out.println(isNext);
        System.out.println(isPrev);
    }


}
