package com.kozlov.dto;


import java.io.Serializable;
import java.util.ArrayList;

public class PictureDTO implements Serializable {

    private String author;
    private String date;
    private String ref;
    private String description;
    private ArrayList<CommentDTO> comments;

    public PictureDTO() {

    }

    public PictureDTO(String author, String ref, String description, String date) {
        this.author = author;
        this.date = date;
        this.ref = ref;
        this.description = description;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(ArrayList<CommentDTO> comments) {
        this.comments = comments;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PictureDTO that = (PictureDTO) o;

        if (!author.equals(that.author)) {
            return false;
        }
        if (date != null ? !date.equals(that.date) : that.date != null) {
            return false;
        }
        if (!ref.equals(that.ref)) {
            return false;
        }
        if (description != null ? !description.equals(that.description) : that.description != null) {
            return false;
        }
        return comments != null ? comments.equals(that.comments) : that.comments == null;

    }

    @Override
    public int hashCode() {
        int result = author.hashCode();
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + ref.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        return result;
    }
}
