package run.mydata.example.test9.domain;

import run.mydata.annotation.ColumnRule;
import run.mydata.em.RuleType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
public class OrderV9 {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @ColumnRule(ruleType = RuleType.RANGE, value = 10)
    private Long custId;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
