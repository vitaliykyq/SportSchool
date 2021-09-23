package edu.coursework.sportschool.controller.rest;

/*
    @author:    Anton
    @project:    SportSchool
    @class:    FamousSportsmenRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.sportschool.model.FamousSportsmen;
import edu.coursework.sportschool.service.famousSportsmen.impls.FamousSportsmenServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/famousSportsmen/get/all*/
@Tag(name = "FamousSportsmen controller API")
@RestController
@RequestMapping("api/famousSportsmen")
public class FamousSportsmenRestController {

    @Autowired
    FamousSportsmenServiceImpl service;

    @GetMapping("/get/all")
    public List<FamousSportsmen> getCivil(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public FamousSportsmen getById(@PathVariable("id") String id){
        FamousSportsmen byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public FamousSportsmen deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public FamousSportsmen create(@RequestBody FamousSportsmen famousSportsmen){
        return service.create(famousSportsmen);
    }

    @PostMapping ("/update/")
    public FamousSportsmen update(@RequestBody FamousSportsmen famousSportsmen){
        return service.update(famousSportsmen);
    }

}
