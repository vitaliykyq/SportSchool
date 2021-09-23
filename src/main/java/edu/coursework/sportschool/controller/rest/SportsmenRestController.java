package edu.coursework.sportschool.controller.rest;

/*
    @author:    Anton
    @project:    SportSchool
    @class:    SportsmenRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.sportschool.model.Sportsmen;
import edu.coursework.sportschool.service.sportsmen.impls.SportsmenServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/sportsmen/get/all*/
@Tag(name = "Sportsmen controller API")
@RestController
@RequestMapping("api/sportsmen")
public class SportsmenRestController {

    @Autowired
    SportsmenServiceImpl service;

    @GetMapping("/get/all")
    public List<Sportsmen> getAll(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Sportsmen getById(@PathVariable("id") String id){
        Sportsmen byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Sportsmen deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Sportsmen create(@RequestBody Sportsmen sportsmen){
        return service.create(sportsmen);
    }

    @PostMapping ("/update/")
    public Sportsmen update(@RequestBody Sportsmen sportsmen){
        return service.update(sportsmen);
    }

}
