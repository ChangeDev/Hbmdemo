package com.wind.entity;

import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2018-05-28 17:34
 **/
@Data
public class Category {

    private Long id;

    private String name;

    private Category parentCategory;

    private Set<Category> childCategories = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "category_item",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private Set<Item> items = new HashSet<>();

    public void addChildCategory(Category childCategory) {
        if (null == childCategory) {
            throw new NullPointerException("Null child category!");
        }
        if (null != childCategory.getParentCategory()) {
            childCategory.getParentCategory().getChildCategories().remove(childCategory);
        }
        childCategory.setParentCategory(this);
        childCategories.add(childCategory);
    }

}