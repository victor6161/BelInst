package com.kozlov.service;

import com.kozlov.converter.UserDtoToEntity;
import com.kozlov.converter.UserEntityToDTO;
import com.kozlov.dao.FriendDAOImpl;
import com.kozlov.dao.UserDAOImpl;
import com.kozlov.dto.UserDTO;
import com.kozlov.entity.FriendEntity;
import com.kozlov.entity.UserEntity;
import org.apache.log4j.Logger;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * класс с методами
 * для сохранения пользователя.
 * для получения списка пользователей на которых он может подписаться
 */
public class UserService {
    private static final Logger LOGGER = Logger.getLogger(UserService.class);

    private UserDAOImpl userDAO;
    private FriendDAOImpl friendDAO;
    private UserEntityToDTO userEntityToDTO;
    private UserDtoToEntity userDtoToEntity;

    public void setUserDtoToEntity(UserDtoToEntity userDtoToEntity) {
        this.userDtoToEntity = userDtoToEntity;
    }

    public void setUserEntityToDTO(UserEntityToDTO userEntityToDTO) {
        this.userEntityToDTO = userEntityToDTO;
    }


    public void setFriendDAO(FriendDAOImpl friendDAO) {
        this.friendDAO = friendDAO;
    }

    public void setUserDAO(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
    }

    public List<UserDTO> getUserListWithoutFriends(String login) {
        LOGGER.info("getUserListWithoutFriends");
        List<UserEntity> userEntities = userDAO.getList(UserEntity.class);
        List<FriendEntity> friendEntities = friendDAO.getListFriendByName(login);
        Iterator<UserEntity> iter = userEntities.iterator();
        while (iter.hasNext()) {
            UserEntity userEntity = iter.next();
            if (friendEntities.stream().anyMatch(
                    friendEntity -> userEntity.getName().equals(friendEntity.getFriend()))) {
                iter.remove();
            }
        }
        List<UserDTO> userDTO = new ArrayList<>();
        for (UserEntity userEntity : userEntities) {
            userDTO.add(userEntityToDTO.convert(userEntity));
        }

        return userDTO;
    }


    public void addUser(UserDTO userDTO) {
        LOGGER.info("addUser method");
        userDAO.save(userDtoToEntity.convert(userDTO));
    }

    public List<UserDTO> search(String currentUser, String findUser) {
        LOGGER.info("search method");
        List<UserDTO> users = getUserListWithoutFriends(currentUser);
        List<UserDTO> userSend = users.stream().filter(
                user -> user.getLogin().contains(findUser)).collect(Collectors.toList());
        return userSend;
    }
}
