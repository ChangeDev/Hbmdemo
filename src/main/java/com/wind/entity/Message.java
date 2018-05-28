package com.wind.entity;

/**
 * @description: 用XML文件定义映射关系
 * @author: ChangFeng
 * @create: 2018-05-25 14:16
 **/
public class Message {

    private Long id;

    private String text;

    private Message nextMessage;

    public Message() {
    }

    public Message(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Message getNextMessage() {
        return nextMessage;
    }

    public void setNextMessage(Message nextMessage) {
        this.nextMessage = nextMessage;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", nextMessage=" + nextMessage +
                '}';
    }
}