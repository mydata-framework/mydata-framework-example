package run.mydata.example.version10.dao;

import org.springframework.stereotype.Repository;
import run.mydata.dao.base.impl.MyData;
import run.mydata.example.version10.domain.Book;

@Repository
public class BookDao extends MyData<Book> {
}
