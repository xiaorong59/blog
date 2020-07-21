package com.rong.demo.service;

import com.rong.demo.po.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> listCommentByBlogId(Long blogId);
    void saveComment(Comment comment);
}
