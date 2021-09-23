package edu.coursework.sportschool.controller.ui;

/*
    @author:    Anton
    @project:    SportSchool
    @class:    SportsmenUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.sportschool.model.Group;
import edu.coursework.sportschool.model.Sportsmen;
import edu.coursework.sportschool.model.Team;
import edu.coursework.sportschool.service.group.impls.GroupServiceImpl;
import edu.coursework.sportschool.service.sportsmen.impls.SportsmenServiceImpl;
import edu.coursework.sportschool.service.team.impls.TeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/sportsmen")
@Controller
public class SportsmenUIController {

    @Autowired
    SportsmenServiceImpl sportsmenService;

    @Autowired
    GroupServiceImpl groupService;

    @Autowired
    TeamServiceImpl teamService;

    @RequestMapping("/get/all")
    public String showAll(Model model){
        List<Sportsmen> sportsmenList = sportsmenService.getAll();
        model.addAttribute("sportsmenList", sportsmenList);
        return "sportsmen/sportsmenList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Sportsmen sportsmen = sportsmenService.getById(id);
        model.addAttribute("sportsmen", sportsmen);

        List<Group> groupList = groupService.getAll();
        model.addAttribute("groupList", groupList);

        List<Team> teamList = teamService.getAll();
        model.addAttribute("teamList", teamList);
        return "sportsmen/updateSportsmen";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Sportsmen sportsmen = new Sportsmen();
        model.addAttribute("sportsmen", sportsmen);

        List<Group> groupList = groupService.getAll();
        model.addAttribute("groupList", groupList);

        List<Team> teamList = teamService.getAll();
        model.addAttribute("teamList", teamList);
        return "sportsmen/newSportsmen";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("sportsmen") @RequestBody Sportsmen sportsmen) {
        model.addAttribute("sportsmen", sportsmenService.create(sportsmen));
        return "redirect:/ui/sportsmen/get/all";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("sportsmen") @RequestBody Sportsmen sportsmen) {

        sportsmenService.update(sportsmen);
        return "redirect:/ui/sportsmen/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        sportsmenService.delete(id);
        return "redirect:/ui/sportsmen/get/all";
    }
}
