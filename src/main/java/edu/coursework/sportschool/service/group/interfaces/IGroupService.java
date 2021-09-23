package edu.coursework.sportschool.service.group.interfaces;

/*
    @author:    Anton
    @project:    SportSchool
    @class:    IGroupService
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.sportschool.model.Group;

import java.util.List;

public interface IGroupService {

    Group getById(String id);
    Group create(Group group);
    Group update(Group engineer);
    Group delete(String id);
    List<Group> getAll();
}
