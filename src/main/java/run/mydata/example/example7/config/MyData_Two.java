package run.mydata.example.example7.config;

import run.mydata.dao.base.impl.MyDataSupport;
import run.mydata.manager.IConnectionManager;

import javax.annotation.Resource;

public class MyData_Two<POJO> extends MyDataSupport<POJO> {

    @Resource
    private IConnectionManager twoConnectionManager;

    @Override
    public IConnectionManager getConnectionManager() {
        return twoConnectionManager;
    }
}