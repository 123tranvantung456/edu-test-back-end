package com.javaweb.edutest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class RootComment extends Comment{
    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;
}
