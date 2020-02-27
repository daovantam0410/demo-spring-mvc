package com.daovantam.service.impl;



import com.daovantam.entity.CategoryEntity;
import com.daovantam.repository.CategoryRepository;
import com.daovantam.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public Map<String, String> findAll() {
//        dùng Map do bên view sử dụng <form/> của spring
        Map<String, String> result = new HashMap<>();
        List<CategoryEntity> entities = categoryRepository.findAll();
        for (CategoryEntity item: entities){
            result.put(item.getCode(),item.getName());
        }
        return result;
    }
}
