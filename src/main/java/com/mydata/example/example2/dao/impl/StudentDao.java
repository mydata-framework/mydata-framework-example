package com.mydata.example.example2.dao.impl;

import com.mydata.dao.base.impl.MyData;
import com.mydata.example.example2.dao.IStudentDao;
import com.mydata.example.example2.domain.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao extends MyData<Student> implements IStudentDao {
}
