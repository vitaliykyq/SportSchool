package edu.coursework.sportschool.service.competition.impls;

/*
    @author:    Anton
    @project:    SportSchool
    @class:    CompetitionServiceImpl
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.sportschool.model.Competition;
import edu.coursework.sportschool.repository.CompetitionRepository;
import edu.coursework.sportschool.service.competition.interfaces.ICompetitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompetitionServiceImpl implements ICompetitionService {

    @Autowired
    CompetitionRepository repository;

    @Override
    public Competition getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Competition create(Competition competition) {
        competition.setCreatedAt(new Date());
        return repository.save(competition);
    }

    @Override
    public Competition update(Competition competition) {
        competition.setModifiedAt(new Date());
        competition.setCreatedAt(repository.findById(competition.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(competition);
        return competition;
    }

    @Override
    public Competition delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Competition> getAll() {

        return repository.findAll();
    }

}
