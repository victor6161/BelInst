package com.kozlov.service;


import com.kozlov.converter.FriendEntityToDTO;
import com.kozlov.dao.FriendDAOImpl;
import com.kozlov.dto.FriendDTO;
import com.kozlov.entity.FriendEntity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * FriendService , есть методы для добавления в подписки на пользовавателя , удаление подписки.
 * , получение списка подписок по имени пользователя.
 */
public class FriendService {


    private FriendDAOImpl friendDAO;
    private FriendEntityToDTO friendEntityToDTO;

    public void setFriendDAO(FriendDAOImpl friendDAO) {
        this.friendDAO = friendDAO;
    }

    public void setFriendEntityToDTO(FriendEntityToDTO friendEntityToDTO) {
        this.friendEntityToDTO = friendEntityToDTO;
    }

    public List<FriendDTO> getListFriendByName(String login) {

        List<FriendEntity> friendEntities = friendDAO.getListFriendByName(login);
        List<FriendDTO> friendDTO = friendEntities.stream().map(
                friendEntity -> friendEntityToDTO.convert(friendEntity))
                .collect(Collectors.toList());
        return friendDTO;
    }

    public void addFriend(String username, String friend) {

        friendDAO.save(new FriendEntity(username.trim(), friend.trim()));
    }

    public void removeFriend(String username, String friend) {
        friendDAO.removeFriend(username.trim(), friend.trim());
    }
}
