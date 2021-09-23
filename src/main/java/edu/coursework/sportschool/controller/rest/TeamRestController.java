package edu.coursework.sportschool.controller.rest;

/*
    @author:    Anton
    @project:    SportSchool
    @class:    TeamRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.sportschool.model.Team;
import edu.coursework.sportschool.service.team.impls.TeamServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/team/get/all*/
@Tag(name = "Team controller API")
@RestController
@RequestMapping("api/team")
public class TeamRestController {

    @Autowired
    TeamServiceImpl service;

    @GetMapping("/get/all")
    public List<Team> getAll(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Team getById(@PathVariable("id") String id){
        Team byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Team deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Team create(@RequestBody Team team){
        return service.create(team);
    }

    @PostMapping ("/update/")
    public Team update(@RequestBody Team team){
        return service.update(team);
    }

}
