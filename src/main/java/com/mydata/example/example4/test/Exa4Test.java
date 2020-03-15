package com.mydata.example.example4.test;

import com.mydata.em.Operate;
import com.mydata.example.example4.dao.StudentDao;
import com.mydata.example.example4.domain.Student;
import com.mydata.helper.OrderBy;
import com.mydata.helper.Param;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static com.mydata.helper.Param.*;
import static com.mydata.em.Operate.*;
import static com.mydata.helper.OrderBy.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Exa4Test {
    @Resource
    StudentDao studentDao;

    @Test
    public void saveAtBefor() {
        String[] nameArr = {"zhangsan", "lishi", "wangwu", "zhaoliu"};
        Integer[] ageArr = {18, 18, 20, 21};
        for (int i = 0; i < nameArr.length; i++) {
            String name = nameArr[i];
            Integer age = ageArr[i];
            Student student = new Student();
            student.setName(name);
            student.setAge(age);
            studentDao.save(student);
        }
    }

    @Test
    public void testP() {
        List<Student> list1 = studentDao.getList(Param.getParams(new Param("age", Operate.LT, 20), new Param("name", EQ, "zhangsan")));
        List<Student> list2 = studentDao.getList(ps(p("age", LT, 20), p("name", EQ, "zhangsan")));
    }

    @Test
    public void testO() {
        List<Student> list1 = studentDao.getListOrderBy(Param.getParams(new Param("age", EQ, 18)), OrderBy.getOrderBys(new OrderBy("id", true)));
        List<Student> list2 = studentDao.getListOrderBy(ps(p("age", EQ, 18)), os(o("id", true)));
    }

}
