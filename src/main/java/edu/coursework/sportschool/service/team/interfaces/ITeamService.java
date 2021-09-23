package edu.coursework.sportschool.service.team.interfaces;

/*
    @author:    Anton
    @project:    SportSchool
    @class:    ITeamService
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.sportschool.model.Team;

import java.util.List;

public interface ITeamService {

    Team getById(String id);
    Team create(Team team);
    Team update(Team team);
    Team delete(String id);
    List<Team> getAll();
}
