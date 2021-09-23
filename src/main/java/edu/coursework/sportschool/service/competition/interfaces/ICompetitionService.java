package edu.coursework.sportschool.service.competition.interfaces;

/*
    @author:    Anton
    @project:    SportSchool
    @class:    ICompetitionService
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.sportschool.model.Competition;

import java.util.List;

public interface ICompetitionService {

    Competition getById(String id);
    Competition create(Competition competition);
    Competition update(Competition competition);
    Competition delete(String id);
    List<Competition> getAll();
}
