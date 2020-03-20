package run.mydata.example.example2.dao.impl;

import run.mydata.dao.base.impl.MyData;
import run.mydata.example.example2.dao.IStudentDao;
import run.mydata.example.example2.domain.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao extends MyData<Student> implements IStudentDao {
}
