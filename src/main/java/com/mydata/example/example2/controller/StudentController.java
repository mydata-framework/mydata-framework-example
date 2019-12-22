package com.mydata.example.example2.controller;

import com.mydata.example.example2.controller.base.BaseController;
import com.mydata.example.example2.domain.Student;
import com.mydata.example.example2.vo.GetStudentPage2Vo;
import com.mydata.helper.OrderBy;
import com.mydata.helper.PageData;
import com.mydata.helper.Param;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static com.mydata.em.Operate.*;


@RestController
public class StudentController extends BaseController {

    // POST localhost:8080/saveStudent
    // JSON:
    //    {
    //        "name":"LIU TAO",
    //            "age":18,
    //            "address":"Shanghai",
    //            "birthdayDate":"1993-11-20"
    //    }
    @PostMapping("/saveStudent")
    @ResponseBody
    public Student saveStudent(@RequestBody Student student){
        studentService.getStudentDao().save(student);
        return student;
    }

    // GET localhost:8080/getStudent?id=1
    @GetMapping("/getStudent")
    @ResponseBody
    public Student getStudent(@RequestParam("id")Long id){
        return studentService.getStudentDao().getById(id);
    }

    // PUT localhost:8080/updateStudent
    // JSON:
    //      {
    //          "id": 1,
    //              "name":"LIU TAO",
    //              "age":29,
    //              "address":"Shanghai",
    //              "birthdayDate":"2019-11-20"
    //      }
    @PutMapping("updateStudent")
    @ResponseBody
    public Student updateStudent(@RequestBody Student student){
        student.setUpdateTime(new Date());
        studentService.getStudentDao().update(student);
        return student;
    }


    // PUT localhost:8080/updateStudentNameById?id=1&name=ZHANG SAN
    @PutMapping("updateStudentNameById")
    @ResponseBody
    public String updateStudentNameById(@RequestParam("id")Long id,@RequestParam("name")String name){
        Set<Param> params = Param.getParams(new Param("id", EQ, id));
        LinkedHashMap<String, Object> maps = Param.getMap("name", name);
        studentService.getStudentDao().update(params,maps);
        return "ok";
    }

    // DELETE localhost:8080/deleteStudent?id=1
    @DeleteMapping("/deleteStudent")
    @ResponseBody
    public String deleteStudent(@RequestParam("id")Long id){
        studentService.getStudentDao().deleteById(id);
        return "ok";
    }

    // GET localhost:8080/listStudent?name=ZHANG SAN&startAge=10&endAge=50
    @GetMapping("/listStudent")
    @ResponseBody
    public PageData<Student> getStudentPage(
            @RequestParam(value = "curPage",required = false,defaultValue = "1") int curPage,
            @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize,
            @RequestParam(value = "name",required = true)String name,
            @RequestParam(value = "startAge",required = true)Integer startAge,
            @RequestParam(value = "endAge",required = true)Integer endAge){

        Set<Param> pms = new Param("name",EQ,name).AND("age",GE,startAge).AND("age",LE,endAge).END();
        PageData<Student> pageInfo = studentService.getStudentDao().getPageInfo( curPage, pageSize,pms);
        return pageInfo;
    }

    // POST localhost:8080/listStudent2
    //    {
    //        "curPage":1,
    //            "pageSize":10,
    //            "startAge":1,
    //            "endAge":100,
    //            "orderbys": [{"propertyName":"age","isDesc":true}]
    //    }
    @PostMapping("/listStudent2")
    @ResponseBody
    public PageData<Student> getStudentPage2(@RequestBody GetStudentPage2Vo param){
        Set<Param> params = Param.getParams();
        if (param.getName() != null) {
            params.add(new Param("name", LIKE, param.getName()));
        }
        if (param.getStartAge() != null) {
            params.add(new Param("age", GE, param.getStartAge()));
        }
        if (param.getEndAge() != null) {
            params.add(new Param("age", LE, param.getEndAge()));
        }
        PageData<Student> pageInfo = studentService.getStudentDao().getPageInfo(param.getCurPage(), param.getPageSize(), params,param.getOrderbys());
        return pageInfo;
    }

    // GET localhost:8080/getStudentCount
    @GetMapping("/getStudentCount")
    @ResponseBody
    public Long getStudentCount(){
        Set<Param> params = null;
        return studentService.getStudentDao().getCount(params);
    }

    // GET localhost:8080/getStudentNames
    @GetMapping("/getStudentNames")
    @ResponseBody
    public List<String> getStudentNames(){
        Set<Param> params = null;
        return (List) studentService.getStudentDao().getVList("name", params);
    }

    // GET localhost:8080/getStudentList
    @GetMapping("/getStudentList")
    @ResponseBody
    public List<Student> getStudentList(){
        Set<Param> params = null;
        return studentService.getStudentDao().getList(params);
    }

    // GET localhost:8080/testTransaction
    @GetMapping("/testTransaction")
    public String testTransaction(){
        try {
            studentService.saveA$B();
        } catch (Exception e) {
        }
        return "SEE THE TABLE , Is there A and B";
    }

    // GET localhost:8080/testGroupList
    @GetMapping("/testGroupList")
    @ResponseBody
    public List<Object[]> testGroupList(){
        //SELECT  MIN(stu_age),stu_age,address FROM student  WHERE `name`  IS  NOT  NULL GROUP  BY  stu_age,address ORDER  BY  MIN(stu_age)  DESC    LIMIT  0,10;

        int curPage =1;
        int pageSize = 10;
        LinkedHashSet<OrderBy> orderbys = OrderBy.getOrderBys(new OrderBy("age", "min", true));
        Set<Param> pms = Param.getParams(new Param("name", NOT_EQ, null));
        LinkedHashMap<String, String> funs = Param.getStringMap("min", "age");
        String[] groupbys = Param.getStringArr("age", "address");

        List<Object[]> groupList = studentService.getStudentDao().getGroupPageList(curPage, pageSize, pms, orderbys,funs, groupbys);
        return groupList;
    }


    @GetMapping("/testNativeQuery")
    @ResponseBody
    public Student testNativeQuery(){
        String sql = "SELECT * FROM student WHERE id=?";
        Object[] pms = new Object[]{1};
        Student student = studentService.getStudentDao().nativeQuery(sql, pms, Student.class);
        return student;
    }


    @GetMapping("/testNativeQuery2")
    @ResponseBody
    public String testNativeQuery2(@RequestParam("id") Long id){
        String sql = "SELECT name FROM student WHERE id=?";
        Object[] pms = new Object[]{id};
        String name = studentService.getStudentDao().nativeQuery(sql, pms, String.class);
        return name;
    }


    @GetMapping("/nativeExecute")
    @ResponseBody
    public Integer nativeExecute(){
        String sql = "DELETE FROM student WHERE id=?";
        Object[] pms = new Object[]{1};
        int i = studentService.getStudentDao().nativeExecute(sql, pms);
        return i;
    }

    //more... Example ...




}

