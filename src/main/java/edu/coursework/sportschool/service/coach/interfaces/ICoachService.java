package edu.coursework.sportschool.service.coach.interfaces;

/*
    @author:    Anton
    @project:    SportSchool
    @class:    ICoachService
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.sportschool.model.Coach;

import java.util.List;

public interface ICoachService {

    Coach getById(String id);
    Coach create(Coach coach);
    Coach update(Coach coach);
    Coach delete(String id);
    List<Coach> getAll();
}
