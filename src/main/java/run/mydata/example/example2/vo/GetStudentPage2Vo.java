package run.mydata.example.example2.vo;

import run.mydata.helper.OrderBy;

import java.util.LinkedHashSet;

public class GetStudentPage2Vo {
    private int curPage;
    private int pageSize;
    private String name;
    private Integer startAge;
    private Integer endAge;
    private LinkedHashSet<OrderBy> orderbys; //[{"propertyName":"age","isDesc":true}];

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStartAge() {
        return startAge;
    }

    public void setStartAge(Integer startAge) {
        this.startAge = startAge;
    }

    public Integer getEndAge() {
        return endAge;
    }

    public void setEndAge(Integer endAge) {
        this.endAge = endAge;
    }

    public LinkedHashSet<OrderBy> getOrderbys() {
        return orderbys;
    }

    public void setOrderbys(LinkedHashSet<OrderBy> orderbys) {
        this.orderbys = orderbys;
    }
}