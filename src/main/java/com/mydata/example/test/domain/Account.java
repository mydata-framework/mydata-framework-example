package com.mydata.example.test.domain;

import com.mydata.annotation.MyIndex;
import com.mydata.annotation.TableComment;

import javax.persistence.*;
import java.util.Date;

/**
 * 基本的表都是这么创建
 * 开启mydata ddl 可以只关系实体, 表会自动创建
 */
@Table
@TableComment("账户表")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @MyIndex
    @Column(columnDefinition = "账号")
    private String number;

    @Column(columnDefinition = "余额")
    private Double balance;

    @Column(columnDefinition = "账号类型")
    private Integer type;

    @Column(columnDefinition = "删除标记")
    private Boolean del = false;

    @Version
    @Column(columnDefinition = "版本锁")
    private Long version;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "创建时间")
    private Date createTime = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "创建时间")
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Boolean getDel() {
        return del;
    }

    public void setDel(Boolean del) {
        this.del = del;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", balance=" + balance +
                ", type=" + type +
                ", del=" + del +
                ", version=" + version +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
