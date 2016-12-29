package com.kozlov.controller;

import com.kozlov.service.AddPhotoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * контроллер для добавления фото.
 */
@Controller
public class AddPhotoController {

    private static final Logger LOGGER =
            Logger.getLogger(AddPhotoController.class);
    private final int maxSizeFile=5000000;

    @Autowired
    private AddPhotoService addPhotoService;
    @Autowired
    private MessageSource messageSource;



    @RequestMapping(value = "/user/addPhotoPage")
    public String addPhotoPage() {
        LOGGER.info("addPhotoPage Method");
        return "addPhoto";
    }

    @RequestMapping(value = "/user/addPhotoAction", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
    public @ResponseBody String addPhotoAction(@RequestParam("file") MultipartFile file,
                                               HttpServletRequest request, HttpSession session, Locale locale) {
        LOGGER.info("addPhotoAction");
        LOGGER.info(file.getContentType());
        LOGGER.info(file.getSize());
        LOGGER.info(locale.getLanguage());
        if(file.getSize()>maxSizeFile){
            return  messageSource.getMessage("file_big",null,locale);
        }
        if(!file.getContentType().equals("image/jpeg") && !file.getContentType().equals("image/png")){
            return  messageSource.getMessage("illegal_argument_exception",null,locale);
        }

            addPhotoService.addPhoto(file, (String) session.getAttribute("login"),
                    request.getParameter("descriptionPicture"));

        return  messageSource.getMessage("file_download",null,locale);
    }
}
