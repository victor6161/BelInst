package com.kozlov.service;


import com.kozlov.converter.PictureEntityToDTO;
import com.kozlov.dao.FriendDAOImpl;
import com.kozlov.dao.PictureDAOImpl;
import com.kozlov.dto.PictureDTO;
import com.kozlov.entity.FriendEntity;
import com.kozlov.entity.PictureEntity;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

/**
 * класс с  методами.
 * для получени списка новостей текущего пользователя,
 * пользователей на кого текущий подписан
 * получение id новости по ссылке для создания комментария
 */
public class PictureService {
    private static final Logger LOGGER = Logger.getLogger(PictureService.class);

    private PictureDAOImpl pictureDAO;

    private FriendDAOImpl friendDAO;

    private PictureEntityToDTO pictureEntityToDTO;


    public void setPictureDAO(PictureDAOImpl pictureDAO) {
        this.pictureDAO = pictureDAO;
    }

    public void setFriendDAO(FriendDAOImpl friendDAO) {
        this.friendDAO = friendDAO;
    }

    public void setPictureEntityToDTO(PictureEntityToDTO pictureEntityToDTO) {
        this.pictureEntityToDTO = pictureEntityToDTO;
    }

    public List<PictureDTO> getPictureList(String username) {
        LOGGER.info("getPictureList method");
        List<PictureDTO> pictureDTO;
        List<PictureEntity> pictureEntities = pictureDAO.getListByParameter(PictureEntity.class, "username", username);
        pictureDTO = pictureEntities.stream().map(
                pictureEntity -> pictureEntityToDTO.convert(pictureEntity))
                .collect(Collectors.toList());
        return pictureDTO;
    }

    public Integer getIdPictureByReference(String reference) {
        LOGGER.info("getIdPictureByReference method");
        List<PictureEntity> pictureEntities = pictureDAO.getList();
        return pictureEntities.stream().filter
                (pictureEntity -> pictureEntity.getReference().equals(reference)).findFirst()
                .map(PictureEntity::getId).orElse(null);
    }

    public List<PictureDTO> getPictureListByFriends(String login) {
        LOGGER.info("getPictureListByFriends method");
        List<PictureEntity> pictureListByFriends;
        List<PictureEntity> pictureEntities = pictureDAO.getList();
        List<FriendEntity> friendEntities = friendDAO.getListFriendByName(login);
        pictureListByFriends = pictureEntities.stream().filter(
                pictureEntitie -> friendEntities.stream().anyMatch(
                        friendEntity -> pictureEntitie.getUsername().equals(friendEntity.getFriend())))
                .collect(Collectors.toList());

        List<PictureDTO> pictureDtoByFriend = pictureListByFriends.stream().
                map(pictureListByFriend -> pictureEntityToDTO.convert(pictureListByFriend))
                .collect(Collectors.toList());

        return pictureDtoByFriend;
    }
}
