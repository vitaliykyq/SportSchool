package edu.coursework.sportschool.service.group.impls;

/*
    @author:    Anton
    @project:    SportSchool
    @class:    GroupServiceImpl
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.sportschool.model.Group;
import edu.coursework.sportschool.repository.GroupRepository;
import edu.coursework.sportschool.service.group.interfaces.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GroupServiceImpl implements IGroupService {

    @Autowired
    GroupRepository repository;

    @Override
    public Group getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Group create(Group group) {
        group.setCreatedAt(new Date());
        return repository.save(group);
    }

    @Override
    public Group update(Group group) {
        group.setModifiedAt(new Date());
        group.setCreatedAt(repository.findById(group.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(group);
        return group;
    }

    @Override
    public Group delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Group> getAll() {

        return repository.findAll();
    }
}
