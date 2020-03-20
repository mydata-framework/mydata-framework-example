package run.mydata.example.test5;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import run.mydata.em.Operate;
import run.mydata.em.StatisticsType;
import run.mydata.example.test5.dao.AccountDao;
import run.mydata.example.test5.domain.Account;
import run.mydata.example.test5.vo.IdNumberBean;
import run.mydata.helper.OrderBy;
import run.mydata.helper.PageData;
import run.mydata.helper.Param;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static run.mydata.em.Operate.EQ;
import static run.mydata.em.Operate.GT;
import static run.mydata.helper.Param.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestBegin1 {
    @Resource
    private AccountDao accountDao;


    /**
     * 保存
     * 批量保存
     */
    @Test
    @Transactional
    public void test1Save() {
        Account account = new Account();
        account.setNumber("18516568898");
        account.setBalance(1000D);
        account.setType(1);
        accountDao.save(account);

        List<Account> accountList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Account item = new Account();
            item.setNumber(100 + i + "");
            item.setBalance(1000D);
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
    public void test2Update() {
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
    public void test3Delete() {
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
    public void test4Count() {
        Long count = accountDao.getCount(null);
        System.out.println(count);

        Long count1 = accountDao.getCount(ps(p("id", GT, 100)));
        System.out.println(count1);

        Long groupbyCount = accountDao.getGroupbyCount(ps(p("id", GT, 100)), "type");
        System.out.println(groupbyCount);
    }

    /**
     * List 查询
     */
    @Test
    public void test5GetList() {
        List<Account> all = accountDao.getAll();
        System.out.println(all);

        List<Account> list1 = accountDao.getList(ps(p("id", GT, 10)));
        System.out.println(list1);

        List<Account> listOrderBy = accountDao.getListOrderBy(ps(p("id", GT, 10)), OrderBy.getOrderBys(new OrderBy("id", true)));
        System.out.println(listOrderBy);

        List<Account> listOrderBy1 = accountDao.getListOrderBy(ps(p("id", GT, 50)), OrderBy.os(OrderBy.o("id")));
        System.out.println(listOrderBy1);
    }

    /**
     * 分页查询
     */
    @Test
    public void test6GetPage() {
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

    /**
     * 分页查询, 排序
     */
    @Test
    public void test7GetPageAndOrder() {
        Integer pageNum = 1;
        Integer pageSize = 10;
        PageData<Account> pageData = accountDao.getPageInfo(pageNum, pageSize, ps(p("id", GT, 10)), OrderBy.os(OrderBy.o("id"), OrderBy.o("createTime")));

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

    /**
     * 统计查询
     */
    @Test
    public void test8Statistics() {
        Double maxBalance = accountDao.getStatisticsValue(StatisticsType.MAX, "balance", null);
        System.out.println(maxBalance);

        Double minBalance = accountDao.getStatisticsValue(StatisticsType.MIN, "balance", null);
        System.out.println(minBalance);

        Double sum = accountDao.getStatisticsValue(StatisticsType.SUM, "balance", getParams(new Param("id", GT, 90)));
        System.out.println(sum);
    }

    /**
     * 单属性序列查询
     */
    @Test
    public void test90V() {
        List<Long> idList = (List) accountDao.getVList("id", getParams(new Param("id", GT, 20)));
        System.out.println(idList);
    }


    /**
     * 原生sql支持,(不推荐使用sql)
     */
    @Test
    public void test91NativeQuery1() {
        Account account = accountDao.nativeQuery("SELECT * FROM account WHERE id = ?", Arrays.asList(100).toArray(), Account.class);
        System.out.println(account);
    }

    /**
     * 原生sql支持,(不推荐使用sql)
     */
    @Test
    public void test92NativeQuery2() {
        String number = accountDao.nativeQuery("SELECT number FROM account WHERE id = ?", arr(100), String.class);
        System.out.println(number);
    }

    /**
     * 原生sql支持,(不推荐使用sql)
     */
    @Test
    public void test93NativeQueryList() {
        List<Account> accounts = accountDao.nativeQueryList("SELECT * FROM account WHERE id IN (?,?,?)", arr(10, 20, 30), Account.class);
        System.out.println(accounts);

        List<String> numbers = accountDao.nativeQueryList("SELECT number FROM account WHERE id > ?", arr(90), String.class);
        System.out.println(numbers);
    }


    /**
     * 原生sql支持, 分页查询 , (不推荐使用)
     */
    @Test
    public void test94NativeQueryPage() {
        Integer pageNum = 1;
        Integer pageSize = 10;
        PageData<IdNumberBean> pageData = accountDao.nativeQueryPage(pageNum, pageSize, "SELECT id,number num FROM account WHERE id > ?", arr(50), IdNumberBean.class);

        long totalCount = pageData.getTotalCount();
        long totalPage = pageData.getTotalPage();
        List<IdNumberBean> dataList = pageData.getDataList();
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

    /**
     * 原生sql支持, sql执行操作 , (不推荐使用)
     */
    @Test
    public void test95NativeExecute() {
        int updatedNum = accountDao.nativeExecute("UPDATE account SET number = ? WHERE id = ?", arr("new number", 100));
        System.out.println(updatedNum);
    }

    /**
     * 原生sql支持, sql执行操作 , (不推荐使用)
     */
    @Test
    public void test96NativeExecute2() {
        int updatedNum = accountDao.nativeExecute("DELETE FROM account", null);
        System.out.println(updatedNum);
    }

    @Test
    public void test0(){
        try {
            accountDao.nativeExecute("TRUNCATE TABLE account",null);
        } catch (Exception e) {
        }
    }
}
