package com.kozlov.converter;

import com.kozlov.dto.FriendDTO;
import com.kozlov.entity.FriendEntity;
import org.springframework.core.convert.converter.Converter;

/**
 * конвертер  entity к dto   friend.
 */
public class FriendEntityToDTO implements Converter<FriendEntity, FriendDTO> {
    public FriendDTO convert(FriendEntity friendEntity) {
        FriendDTO friendDTO = new FriendDTO();
        friendDTO.setUsername(friendEntity.getUsername());
        friendDTO.setFriend(friendEntity.getFriend());
        return friendDTO;
    }
}
