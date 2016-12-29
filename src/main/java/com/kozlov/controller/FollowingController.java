package com.kozlov.controller;


import com.kozlov.service.FriendService;
import com.kozlov.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;


@Controller
public class FollowingController {
    private static final Logger LOGGER = Logger.getLogger(FollowingController.class);


    @Autowired
    private UserService userService;

    @Autowired
    private FriendService friendService;


    @RequestMapping(value = {"/user/addFriend", "addFriend"}, method = RequestMethod.GET, produces = {"text/html;charset=UTF-8"})
    public
    @ResponseBody
    String addFriend(@RequestParam String name, HttpSession session) {
        LOGGER.info("addFriend method " + name);
        friendService.addFriend((String) session.getAttribute("login"), name);
        return "ok";
    }

    @RequestMapping(value = {"/user/removeFriend", "removeFriend"}, method = RequestMethod.GET, produces = {"text/html;charset=UTF-8"})
    public
    @ResponseBody
    String removeFriend(@RequestParam String name, HttpSession session) {
        LOGGER.info("remove method");
        friendService.removeFriend((String) session.getAttribute("login"), name);
        return "ok";
    }

    @RequestMapping(value = {"/user/search", "search"}, method = RequestMethod.GET)
    public ModelAndView search(HttpServletRequest httpServletRequest, HttpSession httpSession) {
        LOGGER.info("search method ");
        ModelAndView mv = new ModelAndView("following");
        String currentUser = (String) httpSession.getAttribute("login");
        String user = httpServletRequest.getParameter("user");
        if (!user.isEmpty()) {
            mv.addObject("listCandidates", userService.search(currentUser, user));
        } else {
            mv.addObject("listCandidates", new ArrayList<>());
        }
        mv.addObject("listFriend", friendService.getListFriendByName(currentUser));
        return mv;
    }

    @RequestMapping(value = {"following", "/user/following"},method = RequestMethod.GET)
    public ModelAndView following(HttpSession httpSession) {
        LOGGER.info("following");
        String currentUser = (String) httpSession.getAttribute("login");
        ModelAndView mv = new ModelAndView("following");
        mv.addObject("user_found", "search_user");
        //  mv.addObject("listCandidates", userService.getUserListWithoutFriends(currentUser));
        mv.addObject("listFriend", friendService.getListFriendByName(currentUser));
        return mv;
    }
}
