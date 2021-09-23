package edu.coursework.sportschool.controller.ui;

/*
    @author:    Anton
    @project:    SportSchool
    @class:    CompetitionUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.sportschool.model.Competition;
import edu.coursework.sportschool.model.Sport;
import edu.coursework.sportschool.service.competition.impls.CompetitionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/ui/competition")
@Controller
public class CompetitionUIController {

    @Autowired
    CompetitionServiceImpl competitionService;

    @RequestMapping("/get/all")
    public String showAll(Model model){
        List<Competition> competitionList = competitionService.getAll();
        model.addAttribute("competitionList", competitionList);
        return "competition/competitionList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Competition competition = competitionService.getById(id);
        model.addAttribute("competition", competition);

        List<Sport> sportList = Arrays.asList(Sport.values());
        model.addAttribute("sportList", sportList);
        return "competition/updateCompetition";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Competition competition = new Competition();
        model.addAttribute("competition", competition);

        List<Sport> sportList = Arrays.asList(Sport.values());
        model.addAttribute("sportList", sportList);
        return "competition/newCompetition";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("competition") @RequestBody Competition competition) {
        model.addAttribute("competition", competitionService.create(competition));
        return "redirect:/ui/competition/get/all";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("competition") @RequestBody Competition competition) {

        competitionService.update(competition);
        return "redirect:/ui/competition/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        competitionService.delete(id);
        return "redirect:/ui/competition/get/all";
    }
}
