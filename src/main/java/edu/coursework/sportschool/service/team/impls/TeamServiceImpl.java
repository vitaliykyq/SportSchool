package edu.coursework.sportschool.service.team.impls;

/*
    @author:    Anton
    @project:    SportSchool
    @class:    TeamServiceImpl
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.sportschool.model.Team;
import edu.coursework.sportschool.repository.TeamRepository;
import edu.coursework.sportschool.service.team.interfaces.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TeamServiceImpl implements ITeamService {

    @Autowired
    TeamRepository repository;

    @Override
    public Team getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Team create(Team team) {
        team.setCreatedAt(new Date());
        return repository.save(team);
    }

    @Override
    public Team update(Team team) {
        team.setModifiedAt(new Date());
        team.setCreatedAt(repository.findById(team.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(team);
        return team;
    }

    @Override
    public Team delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Team> getAll() {

        return repository.findAll();
    }
}
