package edu.coursework.sportschool.controller.rest;

/*
    @author:    Anton
    @project:    SportSchool
    @class:    PlacesRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.sportschool.model.Places;
import edu.coursework.sportschool.service.places.impls.PlacesServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/places/get/all*/
@Tag(name = "Places controller API")
@RestController
@RequestMapping("api/places")
public class PlacesRestController {

    @Autowired
    PlacesServiceImpl service;

    @GetMapping("/get/all")
    public List<Places> getAll(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Places getById(@PathVariable("id") String id){
        Places byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Places deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Places create(@RequestBody Places places){
        return service.create(places);
    }

    @PostMapping ("/update/")
    public Places update(@RequestBody Places places){
        return service.update(places);
    }

}
