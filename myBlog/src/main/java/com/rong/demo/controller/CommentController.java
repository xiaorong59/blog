package com.rong.demo.controller;

import com.rong.demo.po.Blog;
import com.rong.demo.po.Comment;
import com.rong.demo.po.User;
import com.rong.demo.service.BlogService;
import com.rong.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    BlogService blogService;

    @Value("${comment.avatar}")
    private String avatar;

    @GetMapping("/comments/{blogId}")
    public String comments(@PathVariable Long blogId, Model model){
        for (Comment com : commentService.listCommentByBlogId(blogId)
             ) {
            System.out.println("comreply:" + com.getReplyComments());
        }
        model.addAttribute("comments", commentService.listCommentByBlogId(blogId));
        return "blog :: commentList";
    }

    @PostMapping("/comments")
    public String post(Comment comment, HttpSession session){
        System.out.println("comment:" + comment + "comment.blog:" +comment.getBlog());
        Long blogId = comment.getBlog().getId();
        User user = (User) session.getAttribute("user");
        if (user != null){
            comment.setAvatar(user.getAvatar());
            comment.setAdminComment(true);
        }else {
            comment.setAvatar(avatar);
        }
        comment.setBlog((Blog) blogService.getBlog(blogId));
        commentService.saveComment(comment);
        return "redirect:/comments/" + comment.getBlog().getId();
    }
}
