package com.daovantam.converter;

import com.daovantam.dto.NewDTO;
import com.daovantam.entity.NewEntity;
import org.springframework.stereotype.Component;

@Component
public class NewConverter {

//    converter ENTITY -> DTO
    public NewDTO toDTO(NewEntity newEntity){
        NewDTO result = new NewDTO();
        result.setId(newEntity.getId());
        result.setTitle(newEntity.getTitle());
        result.setShortDescription(newEntity.getShortDescription());
        result.setContent(newEntity.getContent());
        result.setThumbnail(newEntity.getThumbnail());
        result.setCategoryCode(newEntity.getCategory().getCode());
        return result;
    }

//    converter DTO -> ENTITY
    public NewEntity toEnity(NewDTO dto){
        NewEntity result = new NewEntity();
        result.setTitle(dto.getTitle());
        result.setShortDescription(dto.getShortDescription());
        result.setContent(dto.getContent());
        result.setThumbnail(dto.getThumbnail());
        return result;
    }

    // hàm này
    public NewEntity toEnity(NewEntity result, NewDTO dto){
        result.setTitle(dto.getTitle());
        result.setShortDescription(dto.getShortDescription());
        result.setContent(dto.getContent());
        result.setThumbnail(dto.getThumbnail());
        return result;
    }
}
