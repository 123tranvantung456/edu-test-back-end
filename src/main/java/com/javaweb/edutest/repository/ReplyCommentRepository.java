package com.javaweb.edutest.repository;

import com.javaweb.edutest.model.Comment;
import com.javaweb.edutest.model.ReplyComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyCommentRepository extends JpaRepository<ReplyComment, Long> {
    int countByParentComment_Id(long parentCommentId);
    List<ReplyComment> findByParentComment_Id(long parentId);
}