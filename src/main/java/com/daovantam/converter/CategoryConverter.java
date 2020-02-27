package com.daovantam.converter;

import com.daovantam.dto.CategoryDTO;
import com.daovantam.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {

    public CategoryDTO toDTO(CategoryEntity categoryEntity){
        CategoryDTO result = new CategoryDTO();
        result.setId(categoryEntity.getId());
        result.setName(categoryEntity.getName());
        result.setCode(categoryEntity.getCode());
        return result;
    }

    public CategoryEntity toENTITY(CategoryDTO dto){
        CategoryEntity result = new CategoryEntity();
        result.setName(dto.getName());
        result.setCode(dto.getCode());
        return result;
    }

}
