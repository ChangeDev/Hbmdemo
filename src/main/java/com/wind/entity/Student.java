package com.wind.entity;

import javax.persistence.*;

/**
 * @description: 用注解定义映射关系
 * @author: ChangFeng
 * @create: 2018-05-25 18:13
 **/
@Entity
// 可以不写@Table注解
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * 没有@Column注解也可以
     */
    private String name;

    private Integer age;

    private Integer gender;


    /**
     * @JoinColumn也可以省略
     */
    @OneToOne(cascade = CascadeType.ALL)
    private Message message;

    public Student() {
    }

    private Student(Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setAge(builder.age);
        setGender(builder.gender);
        setMessage(builder.message);
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", message=" + message +
                '}';
    }


    public static final class Builder {
        private Long id;
        private String name;
        private Integer age;
        private Integer gender;
        private Message message;

        public Builder() {
        }

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder age(Integer val) {
            age = val;
            return this;
        }

        public Builder gender(Integer val) {
            gender = val;
            return this;
        }

        public Builder message(Message val) {
            message = val;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}