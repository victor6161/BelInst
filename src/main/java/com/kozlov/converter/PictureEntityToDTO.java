package com.kozlov.converter;


import com.kozlov.dto.CommentDTO;
import com.kozlov.dto.PictureDTO;
import com.kozlov.entity.CommentEntity;
import com.kozlov.entity.PictureEntity;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;

/**
 * конвертер  entity к dto   picture.
 */
public class PictureEntityToDTO implements Converter<PictureEntity, PictureDTO> {


    private CommentEntityToDTO commentEntityToDTO;

    public void setCommentEntityToDTO(CommentEntityToDTO commentEntityToDTO) {
        this.commentEntityToDTO = commentEntityToDTO;
    }

    public PictureDTO convert(PictureEntity pictureEntity) {
        PictureDTO pictureDTO = new PictureDTO();
        pictureDTO.setDate(pictureEntity.getDate().substring(
                0, pictureEntity.getDate().length() - 2));
        pictureDTO.setAuthor(pictureEntity.getUsername());
        pictureDTO.setRef(pictureEntity.getReference());
        pictureDTO.setDescription(pictureEntity.getDescription());
        ArrayList<CommentDTO> commentDTO = new ArrayList<>();
        for (CommentEntity commentEntity : pictureEntity.getCommentEntities()) {
            commentDTO.add(commentEntityToDTO.convert(commentEntity));
        }
        pictureDTO.setComments(commentDTO);
        return pictureDTO;
    }
}
