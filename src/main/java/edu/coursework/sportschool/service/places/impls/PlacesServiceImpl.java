package edu.coursework.sportschool.service.places.impls;

/*
    @author:    Anton
    @project:    SportSchool
    @class:    PlacesServiceImpl
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.sportschool.model.Places;
import edu.coursework.sportschool.repository.PlacesRepository;
import edu.coursework.sportschool.service.places.interfaces.IPlacesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PlacesServiceImpl implements IPlacesService {

    @Autowired
    PlacesRepository repository;

    @Override
    public Places getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Places create(Places places) {
        places.setCreatedAt(new Date());
        return repository.save(places);
    }

    @Override
    public Places update(Places places) {
        places.setModifiedAt(new Date());
        places.setCreatedAt(repository.findById(places.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(places);
        return places;
    }

    @Override
    public Places delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Places> getAll() {

        return repository.findAll();
    }
}
