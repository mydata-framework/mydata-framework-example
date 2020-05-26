package run.mydata.example.example7.test.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import run.mydata.annotation.TransactionalOption;
import run.mydata.em.Operate;
import run.mydata.example.example7.config.DbConfig;
import run.mydata.example.example7.dao.one.OneDomainDao;
import run.mydata.example.example7.dao.two.TwoDomainDao;
import run.mydata.helper.Param;

import javax.annotation.Resource;

@Service
public class Example7TestServiceImpl implements Example7TestService {
    @Resource
    private OneDomainDao oneDomainDao;

    @Resource
    private TwoDomainDao twoDomainDao;

    @Override
    @Transactional
    @TransactionalOption(connectionManagerNames = {DbConfig.ONE, DbConfig.TWO})
    public void update3() {
        String time = System.nanoTime() + "";
        oneDomainDao.update(Param.getParams(new Param("id", Operate.EQ, 1)), Param.getMap("name", time));
        twoDomainDao.update(Param.getParams(new Param("id", Operate.EQ, 1)), Param.getMap("name", time));
        System.out.println("ok");
    }

}
