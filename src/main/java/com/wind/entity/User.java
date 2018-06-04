package com.wind.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2018-05-28 17:33
 **/
// 与User.hbm.xml冲突
//@Entity
//@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue
    private Long id;

    // 省略@Column
    private String loginName;

    /**
     * @See com.wind.entity.Address @Enablable
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "home_street")),
            @AttributeOverride(name = "city", column = @Column(name = "home_city")),
            @AttributeOverride(name = "zipcode", column = @Column(name = "home_zipcode")),
    })
    private Address homeAddress;

    @Embedded
    private Address billingAddress;

    @OneToOne
    @JoinColumn(name="shipment_address_id") //user表中有一个shipment_address_id外键列
    private Address shippingAddress;


}