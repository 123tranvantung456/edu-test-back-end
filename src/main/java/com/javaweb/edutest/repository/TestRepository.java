package com.javaweb.edutest.repository;

import com.javaweb.edutest.model.Question;
import com.javaweb.edutest.model.Test;
import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}
