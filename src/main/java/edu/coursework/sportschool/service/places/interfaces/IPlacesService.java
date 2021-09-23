package edu.coursework.sportschool.service.places.interfaces;

/*
    @author:    Anton
    @project:    SportSchool
    @class:    IPlacesService
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.sportschool.model.Places;

import java.util.List;

public interface IPlacesService {

    Places getById(String id);
    Places create(Places places);
    Places update(Places places);
    Places delete(String id);
    List<Places> getAll();
}
