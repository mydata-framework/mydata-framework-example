package com.mydata.example.test5;

import com.mydata.em.StatisticsType;
import com.mydata.example.test5.dao.OrdersDao;
import com.mydata.example.test5.domain.Orders;
import com.mydata.helper.PageData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.mydata.helper.Param.*;
import static com.mydata.em.Operate.*;
import static com.mydata.helper.OrderBy.*;

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
    public void testQuery() {
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
    public void testUpdate() {
        Orders orders1 = ordersDao.getOne(ps(p("custId", EQ, 17)));//time 1
        orders1.setMoney(1777D);
        ordersDao.update(orders1);//time 10

        ordersDao.update(ps(p("custId", EQ, 17)), m("money", 777));//time 1
    }

    /**
     * 删除
     */
    @Test
    @Transactional
    public void testDelete() {
        ordersDao.delete(ps(p("custId", EQ, 18)));
    }

    /**
     * count 查询
     */
    @Test
    public void testCount() {
        Long count = ordersDao.getCount(null);
        System.out.println(count);
    }

    /**
     * List 查询
     */
    @Test
    public void testGetList() {
        List<Orders> list = ordersDao.getList(ps(p("id", GT, 180)));
        System.out.println(list);
    }

    /**
     * 分页查询
     */
    @Test
    public void testGetPageAndOrder() {
        PageData<Orders> pageInfo = ordersDao.getPageInfo(1, 10, null, os(o("id",false)));
        System.out.println(pageInfo);
    }

    /**
     * 统计查询
     */
    @Test
    public void testStatistics() {
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
    public void testV() {
        List<Object> ids = ordersDao.getVList("id", null);
        System.out.println(ids);
        List<Object> sorded = ids.stream().sorted().collect(Collectors.toList());
        System.out.println(sorded);
    }


}
