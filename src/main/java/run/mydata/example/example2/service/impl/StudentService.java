package run.mydata.example.example2.service.impl;

import run.mydata.example.example2.domain.Student;
import run.mydata.example.example2.service.IStudentService;
import run.mydata.example.example2.service.base.impl.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService extends BaseService implements IStudentService {

    @Transactional
    @Override
    public void saveA$B() {
        Student studentA = new Student();
        studentA.setName("A");
        getStudentDao().save(studentA);

        Student studentB = new Student();
        studentB.setName("B");
        getStudentDao().save(studentB);

        System.out.println("Test Transaction");

        int i = 1/0;
    }


}
