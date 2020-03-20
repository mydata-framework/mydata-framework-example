package run.mydata.example.test5;

import run.mydata.em.StatisticsType;
import run.mydata.example.test5.dao.OrdersDao;
import run.mydata.example.test5.domain.Orders;
import run.mydata.helper.PageData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static run.mydata.helper.Param.*;
import static run.mydata.em.Operate.*;
import static run.mydata.helper.OrderBy.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestBegin2 {

    @Resource
    private OrdersDao ordersDao;

    /**
     * 自动分表
     */
    @Test
    public void testSave100SplitTable() {
        for (Long i = 1L; i <= 100; i++) {
            Orders order = new Orders();
            order.setProductId(i);
            order.setCustId(i);
            order.setMoney(i.doubleValue());
            ordersDao.save(order);
        }
    }

    /**
     * 自动分表
     */
    @Test
    public void testSave100SplitTable2() {
        ArrayList<Orders> ordersArrayList = new ArrayList<>();
        for (Long i = 101L; i <= 200; i++) {
            Orders order = new Orders();
            order.setProductId(i);
            order.setCustId(i);
            order.setMoney(i.doubleValue());
            ordersArrayList.add(order);
        }
        ordersDao.saveList(ordersArrayList);
    }

    /**
     * 查询
     */
    @Test
    public void test101Query() {
        Orders orders = ordersDao.getById(56);
        System.out.println(orders);//10 time

        Orders orders1 = ordersDao.getOne(ps(p("custId", EQ, 17)));
        System.out.println(orders1);//1 time
    }


    /**
     * 更新
     */
    @Test
    @Transactional
    public void test102Update() {
        Orders orders1 = ordersDao.getOne(ps(p("custId", EQ, 17)));//time 1
        if (orders1 != null) {
            orders1.setMoney(1777D);
            ordersDao.update(orders1);//time 10
        }

        ordersDao.update(ps(p("custId", EQ, 17)), m("money", 777));//time 1
    }

    /**
     * 删除
     */
    @Test
    @Transactional
    public void test103Delete() {
        ordersDao.delete(ps(p("custId", EQ, 18)));
    }

    /**
     * count 查询
     */
    @Test
    public void test104Count() {
        Long count = ordersDao.getCount(null);
        System.out.println(count);
    }

    /**
     * List 查询
     */
    @Test
    public void test105GetList() {
        List<Orders> list = ordersDao.getList(ps(p("id", GT, 180)));
        System.out.println(list);
    }

    /**
     * 分页查询
     */
    @Test
    public void test106GetPageAndOrder() {
        PageData<Orders> pageInfo = ordersDao.getPageInfo(1, 10, null, os(o("id",false)));
        System.out.println(pageInfo);
    }

    /**
     * 统计查询
     */
    @Test
    public void test107Statistics() {
        Double maxMoney = ordersDao.getStatisticsValue(StatisticsType.MAX, "money", null);
        System.out.println(maxMoney);

        Double minMoney = ordersDao.getStatisticsValue(StatisticsType.MIN, "money", null);
        System.out.println(minMoney);

        Double sumMoney = ordersDao.getStatisticsValue(StatisticsType.SUM, "money", null);
        System.out.println(sumMoney);
    }

    /**
     * 单属性序列查询
     */
    @Test
    public void test108V() {
        List<Object> ids = ordersDao.getVList("id", null);
        System.out.println(ids);
        List<Object> sorded = ids.stream().sorted().collect(Collectors.toList());
        System.out.println(sorded);
    }


}
