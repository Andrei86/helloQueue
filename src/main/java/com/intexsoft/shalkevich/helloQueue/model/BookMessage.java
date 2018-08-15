package com.intexsoft.shalkevich.helloQueue.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
/**
 * Model for message for book creating
 */
@Setter
@Getter
public class BookMessage implements Serializable {
    private String title;

    public BookMessage(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "BookMessage{" +
                "title='" + title + '\'' +
                '}';
    }
}
