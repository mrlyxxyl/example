package com.yuexin.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "anotaion_bean")
public class AnotaionBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private double age;
    private Date birth;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    public Long getId() {
        return id;
    }

    @SuppressWarnings("unused")
    private void setId(Long id) {
        this.id = id;
    }

    @Column(length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    @Temporal(TemporalType.DATE)
    @Column
    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

}