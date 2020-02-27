package com.daovantam.service;

import com.daovantam.dto.CategoryDTO;
import com.daovantam.dto.NewDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface INewService {

    List<NewDTO> findAll(Pageable pageable);
    int getTotalItem();
    NewDTO findById(Long id);

    NewDTO save(NewDTO dto);

    void delete(Long[] ids);


}
