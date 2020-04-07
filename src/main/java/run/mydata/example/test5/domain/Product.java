package run.mydata.example.test5.domain;

import run.mydata.annotation.TableComment;

import javax.persistence.*;

@Table
@TableComment("商品")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "批次数量")
    private Integer inventory;

    @Column(columnDefinition = "售出数量")
    private Integer sellInventory;

    @Column(columnDefinition = "剩余数量")
    private Integer surplusInventory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getSellInventory() {
        return sellInventory;
    }

    public void setSellInventory(Integer sellInventory) {
        this.sellInventory = sellInventory;
    }

    public Integer getSurplusInventory() {
        return surplusInventory;
    }

    public void setSurplusInventory(Integer surplusInventory) {
        this.surplusInventory = surplusInventory;
    }
}
