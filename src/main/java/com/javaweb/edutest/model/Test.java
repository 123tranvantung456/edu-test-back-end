package com.javaweb.edutest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.HashSet;

@Entity
@Getter
@Setter
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "test")
    private Set<TestHistory> historyOfTests = new HashSet<>();

    @OneToMany(mappedBy = "test")
    private Set<Test> tests = new HashSet<>();
}