package run.mydata.example.test9;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import run.mydata.example.test9.dao.OrderV9Dao;
import run.mydata.example.test9.domain.OrderV9;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestOrderV9Dao {

    @Resource
    private OrderV9Dao orderDao;

    @Test
    public void add1000() {

    }

}
