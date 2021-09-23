package edu.coursework.sportschool.service.famousSportsmen.impls;

/*
    @author:    Anton
    @project:    SportSchool
    @class:    FamousSportsmenServiceImpl
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.sportschool.model.FamousSportsmen;
import edu.coursework.sportschool.repository.FamousSportsmenRepository;
import edu.coursework.sportschool.service.famousSportsmen.interfaces.IFamousSportsmenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FamousSportsmenServiceImpl implements IFamousSportsmenService {

    @Autowired
    FamousSportsmenRepository repository;

    @Override
    public FamousSportsmen getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public FamousSportsmen create(FamousSportsmen famousSportsmen) {
        famousSportsmen.setCreatedAt(new Date());
        return repository.save(famousSportsmen);
    }

    @Override
    public FamousSportsmen update(FamousSportsmen famousSportsmen) {
        famousSportsmen.setModifiedAt(new Date());
        famousSportsmen.setCreatedAt(repository.findById(famousSportsmen.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(famousSportsmen);
        return famousSportsmen;
    }

    @Override
    public FamousSportsmen delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<FamousSportsmen> getAll() {

        return repository.findAll();
    }
}
