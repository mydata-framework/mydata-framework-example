package run.mydata.example.test5.domain;

import run.mydata.annotation.TableComment;

import javax.persistence.*;

@Table
@TableComment("商品")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(columnDefinition = "批次数量")
    private Integer inventory;

    @Column(columnDefinition = "售出数量")
    private Integer sellInventory;

    @Column(columnDefinition = "剩余数量")
    private Integer surplusInventory;

    public Product() {
    }

    public Product(String name, Integer inventory, Integer sellInventory, Integer surplusInventory) {
        this.name = name;
        this.inventory = inventory;
        this.sellInventory = sellInventory;
        this.surplusInventory = surplusInventory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", inventory=" + inventory +
                ", sellInventory=" + sellInventory +
                ", surplusInventory=" + surplusInventory +
                '}';
    }
}
