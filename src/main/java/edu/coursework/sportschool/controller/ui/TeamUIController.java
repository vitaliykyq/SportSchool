package edu.coursework.sportschool.controller.ui;

/*
    @author:    Anton
    @project:    SportSchool
    @class:    TeamUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.sportschool.model.Sport;
import edu.coursework.sportschool.model.Team;
import edu.coursework.sportschool.service.team.impls.TeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/ui/team")
@Controller
public class TeamUIController {

    @Autowired
    TeamServiceImpl teamService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Team> teamList = teamService.getAll();
        model.addAttribute("teamList", teamList);

        return "team/teamList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Team team = teamService.getById(id);
        model.addAttribute("team",team);

        List<Sport> sportList = Arrays.asList(Sport.values());
        model.addAttribute("sportList", sportList);
        return "team/updateTeam";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Team team = new Team();
        model.addAttribute("team", team);

        List<Sport> sportList = Arrays.asList(Sport.values());
        model.addAttribute("sportList", sportList);
        return "team/newTeam";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("team") @RequestBody Team team) {
        model.addAttribute("team", teamService.create(team));
        return "redirect:/ui/team/get/all";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("team") @RequestBody Team team) {

        teamService.update(team);
        return "redirect:/ui/team/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        teamService.delete(id);
        return "redirect:/ui/team/get/all";
    }
}
