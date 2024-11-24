package com.javaweb.edutest.repository;

import com.javaweb.edutest.model.Question_Test;
import com.javaweb.edutest.model.compositekey.Question_TestPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Question_TestRepository extends JpaRepository<Question_Test, Question_TestPK> {

}
