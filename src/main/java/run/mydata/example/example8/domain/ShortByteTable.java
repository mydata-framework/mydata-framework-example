package run.mydata.example.example8.domain;

import javax.persistence.*;

/**
 * @author tao.liu
 * @date 2020/7/11
 */
@Table
public class ShortByteTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Short age;

    @Column(length = 1)
    private Byte isDisable;

    private Boolean idDelte;

    @Column(length = 1024)
    private String des;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public Byte getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(Byte isDisable) {
        this.isDisable = isDisable;
    }

    public Boolean getIdDelte() {
        return idDelte;
    }

    public void setIdDelte(Boolean idDelte) {
        this.idDelte = idDelte;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
