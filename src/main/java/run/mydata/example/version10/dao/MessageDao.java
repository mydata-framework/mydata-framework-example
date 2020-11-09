package run.mydata.example.version10.dao;

import org.springframework.stereotype.Repository;
import run.mydata.dao.base.impl.MyData;
import run.mydata.example.version10.domain.Message;

@Repository
public class MessageDao extends MyData<Message> {
}
