package com.javaweb.edutest.repository;

import com.javaweb.edutest.model.ReplyComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyCommentRepository extends JpaRepository<ReplyComment, Long> {
    int countByParentComment_Id(Long parentCommentId);
}
