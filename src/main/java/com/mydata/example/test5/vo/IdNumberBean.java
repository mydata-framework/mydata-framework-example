package com.mydata.example.test5.vo;

public class IdNumberBean {
    private Long id;
    private String num;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "IdNumberBean{" +
                "id=" + id +
                ", num='" + num + '\'' +
                '}';
    }
}