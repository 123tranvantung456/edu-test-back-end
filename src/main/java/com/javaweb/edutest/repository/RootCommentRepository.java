package com.javaweb.edutest.repository;

import com.javaweb.edutest.model.RootComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface RootCommentRepository extends JpaRepository<RootComment, Long> {
    List<RootComment> findByTest_IdOrderByIdAsc(long testId);
}