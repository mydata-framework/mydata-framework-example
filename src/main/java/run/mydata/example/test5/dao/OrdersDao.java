package run.mydata.example.test5.dao;

import run.mydata.dao.base.impl.MyData;
import run.mydata.example.test5.domain.Orders;
import org.springframework.stereotype.Repository;

@Repository
public class OrdersDao extends MyData<Orders> {
}
