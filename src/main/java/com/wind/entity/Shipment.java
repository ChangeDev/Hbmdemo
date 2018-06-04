package com.wind.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2018-06-04 11:50
 **/
@Data
@Entity
public class Shipment {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinTable(
            name = "item_shipment",
            joinColumns = @JoinColumn(name = "shipment_id"),// 可以不指定此列 它被自动认为是联结列
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private Item auction;

    public Shipment() {
    }

}