package com.wind.entity;

import lombok.Data;

import javax.persistence.Entity;
import java.util.StringTokenizer;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2018-05-28 17:33
 **/
@Entity
@Data
public class User {

    private String firstname;

    private String lastname;

    private Address address;

    public String getName() {
        return firstname + " " + lastname;
    }

    public void setName(String name) {
        StringTokenizer stringTokenizer = new StringTokenizer(name);
        firstname = stringTokenizer.nextToken();
        lastname = stringTokenizer.nextToken();
    }

}