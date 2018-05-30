package com.wind.entity;

import lombok.Data;
import org.hibernate.annotations.Parent;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2018-05-28 17:33
 **/
@Data
@Embeddable // 和User.@Embedded对应
public class Address {

    @Column(name = "address_street", nullable = false)
    private String street;

    @Column(name = "address_city", nullable = false)
    private String city;

    @Column(name = "address_zipcode", nullable = false)
    private String zipCode;

    @Parent
    private User user;

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}