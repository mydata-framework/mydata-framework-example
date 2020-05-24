package run.mydata.example.example7.test;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import run.mydata.em.Operate;
import run.mydata.example.example7.dao.one.OneDomainDao;
import run.mydata.example.example7.dao.two.TwoDomainDao;
import run.mydata.example.example7.domain.one.OneDomain;
import run.mydata.example.example7.domain.two.TwoDomain;
import run.mydata.helper.Param;

import javax.annotation.Resource;

@Controller
public class Example7Test {

    @Resource
    private OneDomainDao oneDomainDao;

    @Resource
    private TwoDomainDao twoDomainDao;

    @GetMapping("/testAdd1")
    public String testAdd() {
        OneDomain oneDomain = new OneDomain();
        oneDomain.setName("one");
        oneDomainDao.save(oneDomain);

        TwoDomain twoDomain = new TwoDomain();
        twoDomain.setName("two");
        twoDomainDao.save(twoDomain);
        return "ok";
    }

    @GetMapping("/testAdd2")
    @Transactional
    public String testAdd2() {
        OneDomain oneDomain = new OneDomain();
        oneDomain.setName("one");
        oneDomainDao.save(oneDomain);

        TwoDomain twoDomain = new TwoDomain();
        twoDomain.setName("two");
        twoDomainDao.save(twoDomain);
        return "ok";
    }

    @GetMapping("/update")
    @ResponseBody
    @Transactional
    public String update() {
        oneDomainDao.update(Param.getParams(new Param("id", Operate.EQ, 1)), Param.getMap("name", "aaa"));
        twoDomainDao.update(Param.getParams(new Param("id", Operate.EQ, 1)), Param.getMap("name", "bbb"));
        return "ok";
    }


}
