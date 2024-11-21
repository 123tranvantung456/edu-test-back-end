package com.javaweb.edutest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ReplyComment extends Comment{
    @ManyToOne
    @JoinColumn(name = "parent_comment_id")
    private Comment parentComment;

}