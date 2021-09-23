package edu.coursework.sportschool.service.coach.impls;

/*
    @author:    Anton
    @project:    SportSchool
    @class:    CoachServiceImpl
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.sportschool.model.Coach;
import edu.coursework.sportschool.repository.CoachRepository;
import edu.coursework.sportschool.service.coach.interfaces.ICoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CoachServiceImpl implements ICoachService {

    @Autowired
    CoachRepository repository;

    @Override
    public Coach getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Coach create(Coach coach) {
        coach.setCreatedAt(new Date());
        return repository.save(coach);
    }

    @Override
    public Coach update(Coach coach) {
        coach.setModifiedAt(new Date());
        coach.setCreatedAt(repository.findById(coach.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(coach);
        return coach;
    }

    @Override
    public Coach delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Coach> getAll() {

        return repository.findAll();
    }
}
