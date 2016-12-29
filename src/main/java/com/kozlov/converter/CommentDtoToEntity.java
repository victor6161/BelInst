package com.kozlov.converter;


import com.kozlov.dto.CommentDTO;
import com.kozlov.entity.CommentEntity;
import com.kozlov.service.PictureService;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;

/**
 * конвертер dto  к entity для комментария, c поиском id_picture
 */
public class CommentDtoToEntity implements Converter<CommentDTO, CommentEntity> {


    public CommentEntity convert(CommentDTO commentDTO) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setText(commentDTO.getText());
        commentEntity.setUsername(commentDTO.getAuthor());
        commentEntity.setDate(LocalDateTime.now().toString());
        return commentEntity;
    }
}
