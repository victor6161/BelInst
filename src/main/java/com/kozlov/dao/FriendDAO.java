package com.kozlov.dao;


import com.kozlov.entity.FriendEntity;

import java.util.List;

public interface FriendDAO {


    /**
     * удаления из подписок
     *
     * @param username
     * @param friend
     */
    void removeFriend(String username, String friend);

    /**
     * получение подписок пользователя
     *
     * @param login
     * @return
     */
    List<FriendEntity> getListFriendByName(String login);
}
