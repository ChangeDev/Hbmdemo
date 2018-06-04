package com.wind.entity;

import lombok.Data;
import org.hibernate.annotations.*;
import org.hibernate.annotations.MapKey;

import javax.persistence.*;
import javax.persistence.CascadeType;
import java.util.*;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2018-05-28 17:44
 **/
@Data
public class Item {

    private String id;

    private String name;

    private String description;

    private Set<String> images = new HashSet<>();

    @CollectionOfElements(targetElement = java.lang.String.class) // targetElement可以省略 因为我们使用了泛型的集合
    @JoinTable(name = "item_image",
            joinColumns = @JoinColumn(name = "item_id"))
    @Column(name = "filename", nullable = false)
    private Set<String> imageSet = new HashSet<>();

    @CollectionOfElements
    @JoinTable(name = "item_image",
            joinColumns = @JoinColumn(name = "item_id"))
    @IndexColumn(name = "position", base = 1)
    @Column(name = "filename")
    private List<String> imageList = new ArrayList<>();

    @CollectionOfElements
    @JoinTable(name = "item_image",
            joinColumns = @JoinColumn(name = "item_id"))
    @MapKey(columns = @Column(name = "image_name"))
    @Column(name = "filename")
    private Map<String, String> imageMap = new HashMap<>();

    // 以下是实体集合映射


    @CollectionOfElements
    @JoinTable(name = "item_image",
            joinColumns = @JoinColumn(name = "item_id"))
    @AttributeOverride(
            name = "element.name",
            column = @Column(name = "image_name")
    )
    private Set<Image> imgSet = new HashSet<>();

    @CollectionOfElements
    @JoinTable(name = "item_image",
            joinColumns = @JoinColumn(name = "item_id"))
    @CollectionId(columns = @Column(name = "id"),
            type = @Type(type = "long"),
            generator = "sequence")
    private Collection<Image> imgCol = new ArrayList<>();

    private Set<Category> categories = new HashSet<>();

    /**
     * mappedBy相当于xml中的reverse属性，但它必须指定目标实体的反向属性
     * 这里不必指定外键列 它通过另一侧映射
     */
    @OneToMany(mappedBy = "item", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private Set<Bid> bids = new HashSet<>();

    public void addCategory(Category category) {
        if (null == category) {
            throw new NullPointerException("Null category!");
        }
        category.getItems().add(this);
        categories.add(category);
    }
}