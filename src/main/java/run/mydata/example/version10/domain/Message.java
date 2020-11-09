package run.mydata.example.version10.domain;

import run.mydata.annotation.ColumnRule;
import run.mydata.em.RuleType;

import javax.persistence.*;

@Table(name = "t_message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @ColumnRule(ruleType = RuleType.RANGE, value = 8)
    private Long id;

    @Column
    private Long senderId;

    @Column
    private Long receivedId;

    @Column
    private String msgInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceivedId() {
        return receivedId;
    }

    public void setReceivedId(Long receivedId) {
        this.receivedId = receivedId;
    }

    public String getMsgInfo() {
        return msgInfo;
    }

    public void setMsgInfo(String msgInfo) {
        this.msgInfo = msgInfo;
    }
}
