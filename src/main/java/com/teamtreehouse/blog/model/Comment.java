package com.teamtreehouse.blog.model;

import java.time.LocalDateTime;

/**
 * Created by Trang on 8/3/2017.
 */
public class Comment {
    private String name;
    private LocalDateTime commentDate;
    private String text;

    public Comment(String name) {
        if (name.equals("")){
            name="Anonymous";
        }
        this.name = name;
    }

    public Comment(String name,String text){
        this(name);
        this.commentDate=LocalDateTime.now();
        this.setText(text);
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCommentDate(LocalDateTime commentDate) {
        this.commentDate = commentDate;
    }

    public LocalDateTime getCommentDate() {
        return commentDate;
    }
}