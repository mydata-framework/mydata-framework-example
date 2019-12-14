package com.mydata.example.example2.service.base.impl;

import com.mydata.example.example2.dao.IStudentDao;
import com.mydata.example.example2.service.base.IBaseService;

import javax.annotation.Resource;

public class BaseService implements IBaseService {

    @Resource
    private IStudentDao studentDao;

    @Override
    public IStudentDao getStudentDao() {
        return studentDao;
    }
}