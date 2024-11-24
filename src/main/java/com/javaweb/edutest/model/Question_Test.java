package com.javaweb.edutest.model;

import com.javaweb.edutest.model.compositekey.Question_TestPK;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question_Test {
    @EmbeddedId
    private Question_TestPK id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("questionId")
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("testId")
    @JoinColumn(name = "test_id")
    private Test test;

    private int orderNumber;
}