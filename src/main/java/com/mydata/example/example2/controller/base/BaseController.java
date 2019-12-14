package com.mydata.example.example2.controller.base;

import com.mydata.example.example2.service.impl.StudentService;

import javax.annotation.Resource;

public class BaseController {

    @Resource
    protected StudentService studentService;


}
