package edu.coursework.sportschool.controller.ui;

/*
    @author:    Anton
    @project:    SportSchool
    @class:    GroupUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.sportschool.model.Coach;
import edu.coursework.sportschool.model.Group;
import edu.coursework.sportschool.model.Sport;
import edu.coursework.sportschool.service.coach.impls.CoachServiceImpl;
import edu.coursework.sportschool.service.group.impls.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/ui/group")
@Controller
public class GroupUIController {

    @Autowired
    GroupServiceImpl groupService;

    @Autowired
    CoachServiceImpl coachService;

    @RequestMapping("/get/all")
    public String showAll(Model model){
        List<Group> groupList = groupService.getAll();
        model.addAttribute("groupList", groupList);
        return "group/groupList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Group group = groupService.getById(id);
        model.addAttribute("group",group);

        List<Sport> sportList = Arrays.asList(Sport.values());
        model.addAttribute("sportList", sportList);

        List<Coach> coachList = coachService.getAll();
        model.addAttribute("coachList", coachList);
        return "group/updateGroup";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Group group = new Group();
        model.addAttribute("group", group);

        List<Sport> sportList = Arrays.asList(Sport.values());
        model.addAttribute("sportList", sportList);

        List<Coach> coachList = coachService.getAll();
        model.addAttribute("coachList", coachList);
        return "group/newGroup";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("group") @RequestBody Group group) {
        model.addAttribute("group", groupService.create(group));
        return "redirect:/ui/group/get/all";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("group") @RequestBody Group group) {

        groupService.update(group);
        return "redirect:/ui/group/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        groupService.delete(id);
        return "redirect:/ui/group/get/all";
    }
}
