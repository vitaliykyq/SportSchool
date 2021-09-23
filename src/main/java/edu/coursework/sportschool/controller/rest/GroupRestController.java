package edu.coursework.sportschool.controller.rest;

/*
    @author:    Anton
    @project:    SportSchool
    @class:    GroupRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.sportschool.model.Group;
import edu.coursework.sportschool.service.group.impls.GroupServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/group/get/all*/
@Tag(name = "Group controller API")
@RestController
@RequestMapping("api/group")
public class GroupRestController {

    @Autowired
    GroupServiceImpl service;

    @GetMapping("/get/all")
    public List<Group> getAll(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Group getById(@PathVariable("id") String id){
        Group byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Group deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Group create(@RequestBody Group group){
        return service.create(group);
    }

    @PostMapping ("/update/")
    public Group update(@RequestBody Group group){
        return service.update(group);
    }

}
