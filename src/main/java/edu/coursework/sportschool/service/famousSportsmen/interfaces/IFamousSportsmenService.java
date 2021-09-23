package edu.coursework.sportschool.service.famousSportsmen.interfaces;

/*
    @author:    Anton
    @project:    SportSchool
    @class:    IFamousSportsmenService
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.sportschool.model.FamousSportsmen;

import java.util.List;

public interface IFamousSportsmenService {

    FamousSportsmen getById(String id);
    FamousSportsmen create(FamousSportsmen famousSportsmen);
    FamousSportsmen update(FamousSportsmen famousSportsmen);
    FamousSportsmen delete(String id);
    List<FamousSportsmen> getAll();
}
