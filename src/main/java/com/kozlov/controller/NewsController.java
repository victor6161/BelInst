package com.kozlov.controller;


import com.kozlov.dto.CommentDTO;
import com.kozlov.dto.UserDTO;
import com.kozlov.service.FriendService;
import com.kozlov.service.PictureService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * контроллер для создания новостей.
 */
@Controller
public class NewsController {
    private static final Logger LOGGER = Logger.getLogger(NewsController.class);

    @Autowired
    private PictureService pictureService;

    @Autowired
    private FriendService friendService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = {"news{username}", "/user/news{username}"})
    public ModelAndView newsU(Model ui, @RequestParam(value = "username", required = false) String showUser) {
        LOGGER.info("personal news method");
        ModelAndView modelAndView = new ModelAndView("news");
        ui.addAttribute("commentDTO", new CommentDTO());
        modelAndView.addObject("pictureList", pictureService.getPictureList(showUser));
        return modelAndView;
    }

    @RequestMapping(value = "/user/welcome", method = RequestMethod.POST)
    public ModelAndView main(@ModelAttribute("user") UserDTO user, HttpSession session, Locale locale) {
        LOGGER.info("method welcome");
        ModelAndView mv = new ModelAndView("following");
        mv.addObject("welcome", "welcome");
        session.setAttribute("login", user.getLogin());
        mv.addObject("listFriend", friendService.getListFriendByName(user.getLogin()));
        return mv;
    }

    @RequestMapping(value = "/user/welcome", method = RequestMethod.GET)
    public ModelAndView changeLanguage(HttpServletRequest servletRequest, HttpSession session) {
        LOGGER.info("method Test welcome");
        ModelAndView mv = new ModelAndView("following");
        mv.addObject("welcome", "welcome");
        mv.addObject("listFriend", friendService.getListFriendByName(
                (String) session.getAttribute("login")));
        return mv;
    }

    @RequestMapping(value = "/user/my_news")
    public ModelAndView news(HttpSession session, Model ui, Locale locale) {
        LOGGER.info("news method");
        ModelAndView modelAndView = new ModelAndView("news");
        ui.addAttribute("commentDTO", new CommentDTO());
        if (pictureService.getPictureList((String) session.getAttribute("login")).isEmpty()) {
            modelAndView.addObject("nothing", messageSource.getMessage("you_not_added_news", null, locale));
        }

        modelAndView.addObject("pictureList", pictureService.getPictureList((String) session.getAttribute("login")));
        return modelAndView;
    }

    @RequestMapping(value = "/user/friends_news")
    public ModelAndView newsFriend(HttpSession session, Locale locale) {
        LOGGER.info("newsFriend method");
        ModelAndView modelAndView = new ModelAndView("news");
        if (pictureService.getPictureListByFriends((String) session.getAttribute("login")).isEmpty()) {
            modelAndView.addObject("nothing", messageSource.getMessage("friend_not_added_news", null, locale));
        }
        modelAndView.addObject("pictureList", pictureService.getPictureListByFriends((String) session.getAttribute("login")));
        return modelAndView;
    }
}
