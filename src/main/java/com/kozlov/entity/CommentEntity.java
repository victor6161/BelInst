package com.kozlov.entity;


public class CommentEntity {
    private int idComment;

    private String username;
    private String text;
    private String date;
    private PictureEntity picture;


    public PictureEntity getPicture() {
        return picture;
    }


    public void setPicture(PictureEntity picture) {
        this.picture = picture;
    }


    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
