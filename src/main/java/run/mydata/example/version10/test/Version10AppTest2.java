package run.mydata.example.version10.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import run.mydata.example.version10.dao.MessageDao;
import run.mydata.example.version10.domain.Message;

import javax.annotation.Resource;

import java.util.List;

import static run.mydata.helper.OrderBy.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Version10AppTest2 {

//    @Resource
//    private MessageDao messageDao;
//
//    @Test
//    public void testadd() {
//        for (int i = 100; i < 200; i++) {
//            Message msg = new Message();
//            msg.setSenderId(Long.valueOf(i));
//            msg.setReceivedId(Long.valueOf(i) + 10);
//            msg.setMsgInfo("内容 : " + i);
//            messageDao.save(msg);
//        }
//    }
//
//    @Test
//    public void testQuery() {
//        List<Message> list = messageDao.getListOrderByTableNameDesc(1, 10, null, os(o("id", DESC)));
//        System.out.println(list);
//    }
//
//    @Test
//    public void main() {
//    }
}
