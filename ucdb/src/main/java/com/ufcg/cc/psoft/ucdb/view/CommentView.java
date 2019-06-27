package com.ufcg.cc.psoft.ucdb.view;


import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class CommentView {

    private String userName;
    private String userSecondName;
    private String comment;
    private Collection<CommentView> subcomments; /*CommentView vai gerar uma lista de comentarios que são comments view*/

    public CommentView(String userName, String userSecondName, String comment, Collection<CommentView> subcomments) {
        this.userName = userName;
        this.userSecondName = userSecondName;
        this.comment = comment;
        this.subcomments = subcomments;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSecondName() {
        return userSecondName;
    }

    public void setUserSecondName(String userSecondName) {
        this.userSecondName = userSecondName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Collection<CommentView> getSubcomments() {
        return subcomments;
    }

    public void setSubcomments(List<CommentView> subcomments) {
        this.subcomments = subcomments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentView that = (CommentView) o;
        return Objects.equals(userName, that.userName) &&
                Objects.equals(userSecondName, that.userSecondName) &&
                Objects.equals(comment, that.comment) &&
                Objects.equals(subcomments, that.subcomments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, userSecondName, comment, subcomments);
    }

    @Override
    public String toString() {
        return "CommentView{" +
                "userName='" + userName + '\'' +
                ", userSecondName='" + userSecondName + '\'' +
                ", comment='" + comment +
                '}';
    }
}