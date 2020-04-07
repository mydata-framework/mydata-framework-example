package run.mydata.example.test5.dao;

import org.springframework.stereotype.Repository;
import run.mydata.dao.base.impl.MyData;
import run.mydata.example.test5.domain.Product;

@Repository
public class ProductDao extends MyData<Product> {
}
