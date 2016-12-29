package com.kozlov.service;


import com.kozlov.dao.PictureDAOImpl;
import com.kozlov.entity.PictureEntity;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * для добавления фотографии.
 */
public class AddPhotoService {
    private static final Logger LOGGER = Logger.getLogger(AddPhotoService.class);


    private PictureDAOImpl pictureDAO;

    public void setPictureDAO(PictureDAOImpl pictureDAO) {
        this.pictureDAO = pictureDAO;
    }

    public void addPhoto(MultipartFile file, String login, String descriptionPicture) throws IllegalArgumentException {
        LOGGER.info("1");
        final String pathToFile = System.getProperty("user.home");
        UUID namePicture = UUID.randomUUID();
        LOGGER.info(pathToFile);
        File folder = new File(pathToFile +
                File.separator + "photo");
        if (!folder.exists()) {
            folder.mkdir();
        }
        File dest = new File(pathToFile + "/photo/" + namePicture + ".jpg");
        LOGGER.info("2");
        LOGGER.info("user:" + login + "add photo" + namePicture);
        @SuppressWarnings("Since15")
        String date = LocalDateTime.now().toString();
        LOGGER.info("3");
        BufferedImage imageIO;
        try {
            file.transferTo(dest);
            LOGGER.info("4");
            imageIO = ImageIO.read(dest);
            LOGGER.info("5");
            ImageIO.write(imageIO, "jpg", dest);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        LOGGER.info("6");
        pictureDAO.save(new PictureEntity("photo/" + namePicture + ".jpg", date, login, descriptionPicture));
    }
}
