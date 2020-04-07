package run.mydata.example.test5;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import run.mydata.example.test5.dao.OrdersDao;
import run.mydata.example.test5.domain.Orders;

import javax.annotation.Resource;

import java.util.List;

import static run.mydata.helper.Param.*;  import static run.mydata.em.Operate.*; import static run.mydata.helper.OrderBy.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestBegin3 {


    @Before
    private void saveList(){

    }

    @Test
    public void testC_() {
        List<Orders> list = ordersDao.getList(ps(p("custId", C_EQ, "id")));
        System.out.println(list);
    }


}
