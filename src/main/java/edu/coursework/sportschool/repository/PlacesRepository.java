package edu.coursework.sportschool.repository;

/*
    @author:    Anton
    @project:    SportSchool
    @class:    PlacesRepository
    @version:    1.0.0 
    @since:    21.05.2021     
*/

import edu.coursework.sportschool.model.Places;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacesRepository extends MongoRepository<Places, String> {
}
