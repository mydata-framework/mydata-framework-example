package run.mydata.example.version10.domain;

import run.mydata.annotation.MyIndex;
import run.mydata.annotation.MyIndexFullText;
import run.mydata.annotation.Other;
import run.mydata.annotation.TableComment;

import javax.persistence.*;

@Table(name = "t_book")
@TableComment("书本表")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "c_name")
    private String name;

    @MyIndexFullText(otherPropName = {@Other(name = "name")})
    @Column(name = "c_content")
    private String content;

    @MyIndex(otherPropName = {@Other(name = "author")})
    private String code;

    private String author;


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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", code='" + code + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
