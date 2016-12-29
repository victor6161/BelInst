package com.kozlov.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
public class FriendEntity implements Serializable {
    private String username;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FriendEntity that = (FriendEntity) o;

        if (!username.equals(that.username)) return false;
        return friend.equals(that.friend);
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + friend.hashCode();
        return result;
    }

    private String friend;

    public FriendEntity() {
    }

    public FriendEntity(String username, String friend) {
        this.username = username;
        this.friend = friend;
    }

    @Id
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


}
