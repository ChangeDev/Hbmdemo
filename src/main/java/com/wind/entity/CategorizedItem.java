package com.wind.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2018-06-04 14:30
 **/
@Data
public class CategorizedItem {

    @Embeddable
    public static class Id implements Serializable {

        @Column
        private Long categoryId;

        @Column
        private Long itemId;

        public Id() {
        }
    }

    @Embedded
    private Id id = new Id();

    @Column(name = "added_by_user")
    private String username;

    @Column(name = "added_on")
    private ZonedDateTime dateAdded = ZonedDateTime.now();

    @OneToMany
    @JoinColumn(name = "item_id", insertable = false, updatable = false)
    private Item item;

    @OneToMany
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private Category category;

    public CategorizedItem() {
    }

}