package com.wind.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2018-05-30 15:58
 **/

/**
 * 默认情况下 基类的的属性被忽略并不是持久化的
 * 需要在具体的子类中注解超类来启用属性嵌入
 */
@Data
@MappedSuperclass
public abstract class BillingDetails {

    @Column(name = "owner", nullable = false)
    private String owner;

}