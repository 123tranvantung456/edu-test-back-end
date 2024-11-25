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

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private User owner;

    @ManyToMany(mappedBy = "tests")
    private Set<Group> groups = new HashSet<>();

    @OneToMany(mappedBy = "test")
    private Set<TestHistory> historyOfTests = new HashSet<>();

    @OneToMany(mappedBy = "test")
    private Set<RootComment> rootComments = new HashSet<>();

    @OneToMany(mappedBy = "test", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private Set<QuestionTest> questionTests;
}