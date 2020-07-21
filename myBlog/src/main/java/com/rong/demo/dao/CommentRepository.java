package com.rong.demo.dao;

import com.rong.demo.po.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

//    List<Comment> findByBlog(Long id, Sort sort);
    List<Comment> findByBlogIdAndParentCommentNull(Long id, Sort sort);
}
