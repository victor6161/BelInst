package com.kozlov.controller;

import com.kozlov.dto.CommentDTO;
import com.kozlov.service.CommentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;
    private static final Logger LOGGER = Logger.getLogger(CommentController.class);

    @RequestMapping(value = "/admin/page", method = RequestMethod.GET)
    public ModelAndView page() {
        LOGGER.info("go to admin page");
        ModelAndView mv = new ModelAndView("admin");
        mv.addObject("listComment", commentService.getList());
        return mv;
    }

    @RequestMapping(value = "/user/comment", method = RequestMethod.GET, produces = {"text/html;charset=UTF-8"})
    public
    @ResponseBody
    String comment(String comment, String reference, HttpSession session) {
        LOGGER.info("comment method");
        String username = (String) session.getAttribute("login");
        if (comment == null && reference == null) {
            return "";
        }
        if(!comment.trim().isEmpty() && !reference.isEmpty()) {
            commentService.addComment(new CommentDTO(username, comment, reference));
        }
        return "ok";
    }

    @RequestMapping(value = "/admin/deleteComment", method = RequestMethod.GET)
    public
    @ResponseBody
    void delete(int id) {
        commentService.deleteComment(id);
    }
}
