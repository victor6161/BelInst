package com.kozlov.controller;


import com.kozlov.dto.UserDTO;
import com.kozlov.service.UserService;
import com.kozlov.validator.RegistrationValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * контроллер для проверки аутентификации и регистрации.
 */
@Controller
public class AuthenticationController {

    private static final Logger LOGGER = Logger.getLogger(
            AuthenticationController.class);


    @Autowired
    private RegistrationValidator registrationValidator;
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @RequestMapping(value = {"/", "/login"}, produces = "text/html; charset=utf-8")
    public ModelAndView login(@RequestParam(value = "error", required = false) String error) {
        ModelAndView model = new ModelAndView();
        model.addObject("user", new UserDTO());
        if (error != null) {
            model.addObject("error", "bad_credentials");
        }
        model.setViewName("login");
        return model;
    }


    @RequestMapping(value = "/registrationPage")
    public String registrationPage(Model ui) {
        LOGGER.info("registrationPage method");
        ui.addAttribute("user", new UserDTO());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    public String registration(Model ui) {
        LOGGER.info("registration GET method");
        ui.addAttribute("user", new UserDTO());

        return "registration";
    }


    @RequestMapping(value = "/registration", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
    public String registration(@ModelAttribute("user") UserDTO user, BindingResult result, HttpSession httpSession) {
        LOGGER.info("registration method " );
        registrationValidator.validate(user, result);
        httpSession.setAttribute("login", user.getLogin());

        if (result.hasErrors()) {
            return "registration";
        }
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        userService.addUser(user);
        return "forward:/login";
    }
}






