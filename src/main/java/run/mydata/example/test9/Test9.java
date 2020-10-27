package run.mydata.example.test9;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import run.mydata.example.test9.dao.StudentV9Dao;
import run.mydata.example.test9.domain.StudentV9;
import run.mydata.helper.Param;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static run.mydata.em.Operate.EQ;
import static run.mydata.em.Operate.IN;
import static run.mydata.helper.Param.p;
import static run.mydata.helper.Param.ps;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test9 {

    @Resource
    private StudentV9Dao studentV9Dao;

    @Test
    public void initData() {
        StudentV9 s1 = new StudentV9("name1", 1);
        StudentV9 s2 = new StudentV9("name2", 2);
        StudentV9 s3 = new StudentV9("name3", 3);
        StudentV9 s4 = new StudentV9("name4", 4);
        StudentV9 s5 = new StudentV9("name5", 5);
        studentV9Dao.saveList(Arrays.asList(s1, s2, s3, s4, s5));
    }


    @Test
    public void test1GetListByInNull() {
        List<StudentV9> list1 = studentV9Dao.getList(ps(p("id", IN, Arrays.asList())));

        List<StudentV9> list2 = studentV9Dao.getList(ps(p("id", IN, null)));

        List<StudentV9> list3 = studentV9Dao.getList(new Param("id", IN, null).OR(new Param("id", IN, null)).END());

        List<StudentV9> list4 = studentV9Dao.getList(new Param("id", IN, null).OR(new Param("id", IN, null).OR(new Param("id", IN, null))).END());

        try {
            List<StudentV9> list5 = studentV9Dao.getList(new Param("id", IN, null).OR(new Param("id", IN, null).OR(new Param("id", EQ, 1))).END());
        } catch (Exception e) {
            //e.printStackTrace();
        }

        List<StudentV9> list6 = studentV9Dao.getList(new Param("id", IN, Arrays.asList(1)).OR(new Param("id", EQ, 2)).END());

        List<StudentV9> list7 = studentV9Dao.getList(new Param("id", IN, Arrays.asList(1)).OR(new Param("id", EQ, 2).OR(new Param("id", EQ, 3))).END());


        List<StudentV9> list8 = studentV9Dao.getList(Param.getParams(new Param("id", IN, null), new Param("name", EQ, "name1"), new Param("age", EQ, 1)));
        System.out.println();
    }

    @Test
    public void test2GetListByInNull() {
        List<StudentV9> list1 = studentV9Dao.getList(ps(p("id", IN, Arrays.asList())));

        List<StudentV9> list2 = studentV9Dao.getList(ps(p("id", IN, null)));

        List<StudentV9> list3 = studentV9Dao.getList(new Param("id", IN, null).OR(new Param("id", IN, null)).END());

        List<StudentV9> list4 = studentV9Dao.getList(new Param("id", IN, null).OR(new Param("id", IN, null).OR(new Param("id", IN, null))).END());

        try {
            //List<StudentV9> list5 = studentV9Dao.getList(new Param("id", IN, null).OR(new Param("id", IN, null).OR(new Param("id", EQ, 1))).END());
        } catch (Exception e) {
            //e.printStackTrace();
        }

        List<StudentV9> list6 = studentV9Dao.getList(new Param("id", IN, Arrays.asList(1)).OR(new Param("id", EQ, 2)).END());

        List<StudentV9> list7 = studentV9Dao.getList(new Param("id", IN, Arrays.asList(1)).OR(new Param("id", EQ, 2).OR(new Param("id", EQ, 3))).END());


        List<StudentV9> list8 = studentV9Dao.getList(Param.getParams(new Param("id", IN, null), new Param("name", EQ, "name1"), new Param("age", EQ, 1)));
        System.out.println();
    }
}
