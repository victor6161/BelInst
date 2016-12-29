package com.kozlov.service;


import com.kozlov.converter.CommentDtoToEntity;
import com.kozlov.converter.CommentEntityToDTO;
import com.kozlov.dao.CommentDAO;
import com.kozlov.dao.PictureDAOImpl;
import com.kozlov.dto.CommentDTO;
import com.kozlov.entity.CommentEntity;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

/**
 * для добавления комментов.
 */
public class CommentService {
    private static final Logger LOGGER = Logger.getLogger(CommentService.class);

    public void setCommentDAO(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }

    private CommentDAO commentDAO;

    private CommentDtoToEntity commentDtoToEntity;

    public void setCommentDtoToEntity(CommentDtoToEntity commentDtoToEntity) {
        this.commentDtoToEntity = commentDtoToEntity;
    }

    private CommentEntityToDTO commentEntityToDTO;

    public void setCommentEntityToDTO(CommentEntityToDTO commentEntityToDTO) {
        this.commentEntityToDTO = commentEntityToDTO;
    }

    public void setPictureService(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    private PictureService pictureService;


    private PictureDAOImpl pictureDAO;

    public void setPictureDAO(PictureDAOImpl pictureDAO) {
        this.pictureDAO = pictureDAO;
    }


    public void addComment(CommentDTO commentDTO) {
        LOGGER.info("addComment");
        Integer id = pictureService.getIdPictureByReference(commentDTO.getReference());
        CommentEntity commentEntity = commentDtoToEntity.convert(commentDTO);

        commentEntity.setPicture(pictureDAO.getPictureById(id));
        commentDAO.save(commentEntity);

    }

    public void deleteComment(int id) {
        LOGGER.info("deleteComent with");
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setIdComment(id);
        commentDAO.delete(commentEntity);
    }

    public List<CommentDTO> getList() {
        LOGGER.info("getList Comment");
        List<CommentEntity> comment = commentDAO.getList(CommentEntity.class);
        List<CommentDTO> commentDTO = comment.stream().map(
                commentEntity -> commentEntityToDTO.convert(commentEntity))
                .collect(Collectors.toList());
        return commentDTO;
    }
}

