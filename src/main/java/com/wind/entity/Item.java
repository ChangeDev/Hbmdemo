package com.wind.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2018-05-28 17:44
 **/
@Data
public class Item {

    private String name;

    private String description;

    private Set<Category> categories = new HashSet<>();

    public void addCategory(Category category) {
        if (null == category) {
            throw new NullPointerException("Null category!");
        }
        category.getItems().add(this);
        categories.add(category);
    }
}