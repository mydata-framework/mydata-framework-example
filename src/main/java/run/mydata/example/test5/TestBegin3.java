package run.mydata.example.test5;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import run.mydata.example.test5.dao.OrdersDao;
import run.mydata.example.test5.dao.ProductDao;
import run.mydata.example.test5.domain.Orders;
import run.mydata.example.test5.domain.Product;

import javax.annotation.Resource;

import java.util.Arrays;
import java.util.List;

import static run.mydata.helper.Param.*;
import static run.mydata.em.Operate.*;
import static run.mydata.helper.OrderBy.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestBegin3 {
    @Resource
    private ProductDao productDao;

    @Test
    public void init() {
        if (productDao.getCount(null) > 0) {
            return;
        }
        Product p1 = new Product("香蕉", 100, 50, 50);
        Product p2 = new Product("苹果", 100, 50, 50);
        Product p3 = new Product("李子", 100, 10, 90);
        Product p4 = new Product("草莓", 100, 90, 10);
        Product p5 = new Product("猕猴桃", 100, 60, 40);
        Product p6 = new Product("芒果", 100, 100, 0);
        productDao.saveList(Arrays.asList(p1, p2, p3, p4, p5, p6));
    }

    @Test
    public void testC_EQ() {
        List<Product> list = productDao.getList(ps(p("inventory", C_EQ, "sellInventory")));
        System.out.println(list);
    }

    @Test
    public void testC_NOT_EQ() {
        List<Product> list = productDao.getList(ps(p("inventory", C_NOT_EQ, "sellInventory")));
        System.out.println(list);
    }

    @Test
    public void testC_GT() {
        List<Product> list = productDao.getList(ps(p("sellInventory", C_GT, "surplusInventory")));
        System.out.println(list);
    }

    @Test
    public void testC_LT() {
        List<Product> list = productDao.getList(ps(p("sellInventory", C_LT, "surplusInventory")));
        System.out.println(list);
    }

    @Test
    public void testC_GE() {
        List<Product> list = productDao.getList(ps(p("sellInventory", C_GE, "surplusInventory")));
        System.out.println(list);
    }

    @Test
    public void testC_LE() {
        List<Product> list = productDao.getList(ps(p("sellInventory", C_LE, "surplusInventory")));
        System.out.println(list);
    }

}
