package com.daovantam.service.impl;


import java.util.ArrayList;
import java.util.List;

import com.daovantam.converter.NewConverter;
import com.daovantam.dto.NewDTO;
import com.daovantam.entity.CategoryEntity;
import com.daovantam.entity.NewEntity;
import com.daovantam.repository.CategoryRepository;
import com.daovantam.repository.NewRepository;
import com.daovantam.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NewsServiceImpl implements INewService {
	

	@Autowired
	private NewRepository newRepository;

	@Autowired
	private NewConverter newConverter;

	@Autowired
	private CategoryRepository categoryRepository;


	@Override
	public List<NewDTO> findAll(Pageable pageable) {
		List<NewDTO> models = new ArrayList<>();
		List<NewEntity> newEntities = newRepository.findAll(pageable).getContent();
		for(NewEntity item: newEntities){
			NewDTO newDTO = newConverter.toDTO(item);
			models.add(newDTO);
		}
		return models;
	}

	@Override
	public int getTotalItem() {
		return (int) newRepository.count();
	}

    @Override
    public NewDTO findById(Long id) {
		NewEntity entity = newRepository.findOne(id);
        return newConverter.toDTO(entity);
    }

    @Override
    @Transactional
    public NewDTO save(NewDTO dto) {
        CategoryEntity category = categoryRepository.findOneByCode(dto.getCategoryCode());
        NewEntity newEntity = new NewEntity();
        if (dto.getId()!=null){
            NewEntity oldNew = newRepository.findOne(dto.getId()); // dựa vào id để lấy thông tin ra
            oldNew.setCategory(category);
            newEntity=newConverter.toEnity(oldNew,dto);
        }else {
            newEntity = newConverter.toEnity(dto);
            newEntity.setCategory(category);
        }
	    return newConverter.toDTO(newRepository.save(newEntity));
    }

	@Override
	@Transactional
	public void delete(Long[] ids) {
		for (Long id:ids){
			newRepository.delete(id);
		}
	}


}
