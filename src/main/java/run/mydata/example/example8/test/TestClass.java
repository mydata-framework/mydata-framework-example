package run.mydata.example.example8.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import run.mydata.example.example8.dao.ShortByteTableDao;
import run.mydata.example.example8.domain.ShortByteTable;

import javax.annotation.Resource;

/**
 * @author tao.liu
 * @date 2020/7/11
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestClass {

    @Resource
    private ShortByteTableDao shortByteTableDao;

    @Test
    public void testAdd(){
        ShortByteTable domain = new ShortByteTable();
        domain.setAge(new Short("8"));
        domain.setDes("desc");
        domain.setIdDelte(false);
        domain.setIsDisable(new Byte("0"));
        Integer i = shortByteTableDao.save(domain);
        System.out.println(i);
    }


}
