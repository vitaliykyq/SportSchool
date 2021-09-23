package edu.coursework.sportschool.service.sportsmen.impls;

/*
    @author:    Anton
    @project:    SportSchool
    @class:    SportsmenServiceImpl
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.sportschool.model.Sportsmen;
import edu.coursework.sportschool.repository.SportsmenRepository;
import edu.coursework.sportschool.service.sportsmen.interfaces.ISportsmenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SportsmenServiceImpl implements ISportsmenService {

    @Autowired
    SportsmenRepository repository;

    @Override
    public Sportsmen getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Sportsmen create(Sportsmen sportsmen) {
        sportsmen.setCreatedAt(new Date());
        return repository.save(sportsmen);
    }

    @Override
    public Sportsmen update(Sportsmen sportsmen) {
        sportsmen.setModifiedAt(new Date());
        sportsmen.setCreatedAt(repository.findById(sportsmen.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(sportsmen);
        return sportsmen;
    }

    @Override
    public Sportsmen delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Sportsmen> getAll() {

        return repository.findAll();
    }
}
