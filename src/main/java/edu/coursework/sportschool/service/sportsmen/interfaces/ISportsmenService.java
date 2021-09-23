package edu.coursework.sportschool.service.sportsmen.interfaces;

/*
    @author:    Anton
    @project:    SportSchool
    @class:    ISportsmenService
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.sportschool.model.Sportsmen;

import java.util.List;

public interface ISportsmenService {

    Sportsmen getById(String id);
    Sportsmen create(Sportsmen sportsmen);
    Sportsmen update(Sportsmen sportsmen);
    Sportsmen delete(String id);
    List<Sportsmen> getAll();
}
