package com.kozlov.converter;

import com.kozlov.dto.CommentDTO;
import com.kozlov.entity.CommentEntity;
import org.springframework.core.convert.converter.Converter;

/**
 * конвертер  entity к dto   для комментария.
 */
public class CommentEntityToDTO implements Converter<CommentEntity, CommentDTO> {

    public CommentDTO convert(CommentEntity commentEntity) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(commentEntity.getIdComment());
        commentDTO.setText(commentEntity.getText());
        commentDTO.setAuthor(commentEntity.getUsername());
        String s = commentEntity.getDate().substring(0, commentEntity.getDate().length() - 2);
        commentDTO.setDate(s);
        return commentDTO;
    }
}
