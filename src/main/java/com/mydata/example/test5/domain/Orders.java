package com.mydata.example.test5.domain;

import com.mydata.annotation.ColumnRule;
import com.mydata.annotation.TableComment;
import com.mydata.domain.Domain;
import com.mydata.em.RuleType;

import javax.persistence.*;
import java.util.Date;

@Table
@TableComment("订单表")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(columnDefinition = "商品id")
    private Long productId;

    @ColumnRule(ruleType = RuleType.MOD, value = 10)
    @Column(columnDefinition = "客户id")
    private Long custId;

    @Column(columnDefinition = "订单金额")
    private Double money;

    @Version
    @Column(columnDefinition = "版本号")
    private Long version;

    @Column(columnDefinition = "创建时间")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime = new Date();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", productId=" + productId +
                ", custId=" + custId +
                ", money=" + money +
                ", createTime=" + createTime +
                '}';
    }
}
