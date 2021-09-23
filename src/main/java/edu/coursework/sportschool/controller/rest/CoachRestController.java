package edu.coursework.sportschool.controller.rest;

/*
    @author:    Anton
    @project:    SportSchool
    @class:    CoachRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.sportschool.model.Coach;
import edu.coursework.sportschool.service.coach.impls.CoachServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/coach/get/all*/
@Tag(name = "Coach controller API")
@RestController
@RequestMapping("api/coach")
public class CoachRestController {

    @Autowired
    CoachServiceImpl service;

    @GetMapping("/get/all")
    public List<Coach> getAll(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Coach getById(@PathVariable("id") String id){
        Coach byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Coach deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Coach create(@RequestBody Coach coach){
        return service.create(coach);
    }

    @PostMapping ("/update/")
    public Coach update(@RequestBody Coach coach){
        return service.update(coach);
    }

}
