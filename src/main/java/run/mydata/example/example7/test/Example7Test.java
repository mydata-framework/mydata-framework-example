package run.mydata.example.example7.test;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import run.mydata.annotation.TransactionalOption;
import run.mydata.em.Operate;
import run.mydata.example.example7.config.DbConfig;
import run.mydata.example.example7.dao.one.OneDomainDao;
import run.mydata.example.example7.dao.two.TwoDomainDao;
import run.mydata.example.example7.domain.one.OneDomain;
import run.mydata.example.example7.domain.two.TwoDomain;
import run.mydata.example.example7.test.service.Example7TestService;
import run.mydata.helper.Param;

import javax.annotation.Resource;

@Controller
public class Example7Test {
    @Resource
    private OneDomainDao oneDomainDao;
    @Resource
    private TwoDomainDao twoDomainDao;
    @Resource
    private Example7TestService example7TestService;


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
        String time = System.nanoTime() + "";
        oneDomainDao.update(Param.getParams(new Param("id", Operate.EQ, 1)), Param.getMap("name", time));
        twoDomainDao.update(Param.getParams(new Param("id", Operate.EQ, 1)), Param.getMap("name", time));
        return "ok";
    }

    @GetMapping("/update2")
    @ResponseBody
    @Transactional
    @TransactionalOption(connectionManagerNames = {DbConfig.ONE, DbConfig.TWO})
    public String update2() {
        String time = System.nanoTime() + "";
        oneDomainDao.update(Param.getParams(new Param("id", Operate.EQ, 1)), Param.getMap("name", time));
        twoDomainDao.update(Param.getParams(new Param("id", Operate.EQ, 1)), Param.getMap("name", time));
        return "ok";
    }

    @GetMapping("/update3")
    @ResponseBody
    public String update3() {
        example7TestService.update3();
        return "ok";
    }
}
