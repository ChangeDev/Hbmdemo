package com.wind.entity;

import lombok.Data;
import org.hibernate.annotations.Parent;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2018-06-01 11:11
 **/
@Data
@Embeddable
public class Image {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String filename;

    @Parent
    private Item parent;

    public Image() {

    }
}