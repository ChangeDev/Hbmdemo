package com.wind.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2018-05-30 16:00
 **/
@Entity
/**
 * 覆盖来自超类的映射列
 */
@AttributeOverride(name = "owner", column = @Column(name = "ba_owner", nullable = false))
@Data
public class BankAccount extends BillingDetails {

    @Id
    @GeneratedValue
    private String account;

    private String bankName;

    private String swift;

}