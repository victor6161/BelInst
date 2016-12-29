package com.kozlov.dto;

import java.io.Serializable;

public class CommentDTO implements Serializable {

    private int id;
    private String date;
    private String reference;
    private String author;
    private String text;

    public CommentDTO() {
    }


    public CommentDTO(String author, String comment, String reference) {
        this.text = comment;
        this.reference = reference;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
