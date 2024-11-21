package com.javaweb.edutest.repository;

import com.javaweb.edutest.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
