package com.javaweb.edutest.repository;

import com.javaweb.edutest.model.QuestionTest;
import com.javaweb.edutest.model.compositekey.QuestionTestPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionTestRepository extends JpaRepository<QuestionTest, QuestionTestPK> {

}
