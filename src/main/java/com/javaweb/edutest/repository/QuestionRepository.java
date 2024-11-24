package com.javaweb.edutest.repository;

import com.javaweb.edutest.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByQuestionTests_Test_Id(Long id);
}