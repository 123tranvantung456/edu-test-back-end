package com.javaweb.edutest.repository;

import com.javaweb.edutest.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}
