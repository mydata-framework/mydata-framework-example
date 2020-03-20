package run.mydata.example.example2.service.base.impl;

import run.mydata.example.example2.dao.IStudentDao;
import run.mydata.example.example2.service.base.IBaseService;

import javax.annotation.Resource;

public class BaseService implements IBaseService {

    @Resource
    private IStudentDao studentDao;

    @Override
    public IStudentDao getStudentDao() {
        return studentDao;
    }
}