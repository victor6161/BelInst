package com.kozlov.dto;


import java.io.Serializable;

public class FriendDTO implements Serializable {


    private String username;
    private String friend;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFriend() {
        return friend;
    }

    public void setFriend(String friend) {
        this.friend = friend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FriendDTO friendDTO = (FriendDTO) o;

        if (!username.equals(friendDTO.username)) {
            return false;
        }
        return friend.equals(friendDTO.friend);
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + friend.hashCode();
        return result;
    }
}
