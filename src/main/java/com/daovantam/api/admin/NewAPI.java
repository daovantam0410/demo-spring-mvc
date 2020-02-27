package com.daovantam.api.admin;

import com.daovantam.dto.NewDTO;
import com.daovantam.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "newAPIOfAdmin")
public class NewAPI {

    @Autowired
    private INewService newsService;

    @PostMapping("/api/new")
    public NewDTO createNew(@RequestBody NewDTO newDTO){
        return newsService.save(newDTO);
    }

    @PutMapping(value = "/api/new")
    public NewDTO updateNew(@RequestBody NewDTO newDTO){
        return newsService.save(newDTO);
    }

    @DeleteMapping(value = "/api/new")
    public void deleteNew(@RequestBody Long[] ids){
        newsService.delete(ids);
    }
}
