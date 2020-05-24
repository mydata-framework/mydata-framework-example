package run.mydata.example.example6.test;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import run.mydata.em.Operate;
import run.mydata.example.example6.dao.MasterSlaveDao;
import run.mydata.example.example6.domain.MasterSlave;
import run.mydata.helper.Param;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class Example6Test {
    @Resource
    private MasterSlaveDao masterSlaveDao;

    @GetMapping("/testAdd")
    public String testAdd() {
        MasterSlave masterSlave = new MasterSlave();
        masterSlave.setName("test1");
        masterSlave.setAge("1");
        masterSlaveDao.save(masterSlave);
        return "ok";
    }

    @GetMapping("/testAdd2")
    @Transactional
    public String testAdd2() {
        MasterSlave masterSlave = new MasterSlave();
        masterSlave.setName("test1");
        masterSlave.setAge("1");
        masterSlaveDao.save(masterSlave);

        MasterSlave masterSlave2 = new MasterSlave();
        masterSlave2.setName("test2");
        masterSlave2.setAge("2");
        masterSlaveDao.save(masterSlave2);
        return "ok";
    }

    @GetMapping("/testRead")
    public String testRead() {
        List<MasterSlave> all = masterSlaveDao.getAll();
        System.out.println(all);
        return "ok";
    }


    @GetMapping("/testUpdate")
    public String testUpdate() {
        MasterSlave masterSlave = masterSlaveDao.getById(1);
        masterSlaveDao.update(Param.getParams(new Param("id", Operate.EQ, 1)), Param.getMap("name", "update"));
        return "ok";
    }

    @GetMapping("/testUpdate2")
    @Transactional
    public String testUpdate2() {
        MasterSlave masterSlave = masterSlaveDao.getById(1);
        masterSlaveDao.update(Param.getParams(new Param("id", Operate.EQ, 1)), Param.getMap("name", "update2"));
        return "ok";
    }


}
