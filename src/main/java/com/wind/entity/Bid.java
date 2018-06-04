package com.wind.entity;

import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2018-06-01 11:43
 **/
@Data
public class Bid {

    @ManyToOne(targetEntity = com.wind.entity.Item.class) // targetEntity属性是可选的
    @JoinColumn(name = "item_id", nullable = false)// 此注解是可选的，Hib默认会使用目标实体名称+目标实体的数据库标识符属性名称，即：item+id
    private Item item;

    public Bid() {
    }

}