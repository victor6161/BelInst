package com.kozlov.entity;


import org.hibernate.annotations.OrderBy;

import java.io.Serializable;
import java.util.Set;

public class PictureEntity implements Serializable {

    private int id;
    private String reference;
    private String date;//timestamp hibernate
    private String username;

    public PictureEntity(int id, String reference, String date, String username, String description, Set<CommentEntity> commentEntities) {
        this.id = id;
        this.reference = reference;
        this.date = date;
        this.username = username;
        this.description = description;
        this.commentEntities = commentEntities;
    }

    private String description;


    private Set<CommentEntity> commentEntities;

    public PictureEntity() {

    }

    public PictureEntity(String reference, String date, String username, String description) {
        this.date = date;
        this.reference = reference;
        this.username = username;
        this.description = description;
    }

    public PictureEntity(int id, Set<CommentEntity> commentEntities) {
        this.id = id;
        this.commentEntities = commentEntities;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PictureEntity that = (PictureEntity) o;

        if (!reference.equals(that.reference)) return false;
        if (!date.equals(that.date)) return false;
        if (!username.equals(that.username)) return false;
        return description != null ? description.equals(that.description) : that.description == null;

    }

    @Override
    public int hashCode() {
        int result = reference.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + username.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public Set<CommentEntity> getCommentEntities() {
        return commentEntities;
    }

    public void setCommentEntities(Set<CommentEntity> commentEntities) {
        this.commentEntities = commentEntities;
    }


}
