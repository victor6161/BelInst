package com.kozlov.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController {
    private static final Logger LOGGER = Logger.getLogger(
            AuthenticationController.class);

    @RequestMapping(value = "/error-404")
    public ModelAndView error404() {
        ModelAndView mv = new ModelAndView("error");
        LOGGER.error("error404");
        mv.addObject("error", "not_found");
        return mv;
    }

    @RequestMapping(value = "/error-500")
    public ModelAndView error500() {
        ModelAndView mv = new ModelAndView("error");
        LOGGER.error("error500");
        mv.addObject("error", "internal_server_error");
        return mv;
    }

    @RequestMapping(value = "/error-403")
    public ModelAndView error403() {
        ModelAndView mv = new ModelAndView("error");
        LOGGER.error("error403");
        mv.addObject("error", "forbidden");
        return mv;
    }
}
