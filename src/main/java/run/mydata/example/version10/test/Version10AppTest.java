package run.mydata.example.version10.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import run.mydata.em.Operate;
import run.mydata.example.version10.dao.BookDao;
import run.mydata.example.version10.domain.Book;
import run.mydata.helper.Param;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Version10AppTest {

    @Resource
    private BookDao bookDao;

    @Test
    public void testadd() {
        Book book = new Book();
        book.setName("凡人修仙之仙界篇");
        book.setContent("人修仙之仙界篇TXT下载,凡人修仙之仙界篇是作者忘语精心创作的一本非常好看的小说,奇书网(www.qishu.cc)提供免费下载,电子书内容由网友上传,奇书网整理而成,凡人修仙之仙界篇版权属作者或出版社所有,下载后请在24小时之内删除");
        bookDao.save(book);

        Book book1 = new Book();
        book1.setName("世界最迷人反派角色");
        book1.setContent("世界最迷人反派角色TXT下载,世界最迷人反派角色是作者禾四精心创作的一本非常好看的小说,奇书网(www.qishu.cc)提供免费下载,电子书内容由网友上传,奇书网整理而成,世界最迷人反派角色版权属作者或出版社所有,下载后请在24小时之内删除.");
        bookDao.save(book1);
    }

    @Test
    public void testQuery() {
        Set<Param> params = Param.getParams();
        params.add(new Param("name,content", Operate.AGAINST_IN_NATURAL_LANGUAGE_MODE, "TXT"));
        List<Book> list = bookDao.getList(params);
        System.out.println(list);
    }

}
