package edu.coursework.sportschool.controller.ui;

/*
    @author:    Anton
    @project:    SportSchool
    @class:    CoachUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.sportschool.model.Coach;
import edu.coursework.sportschool.model.Sport;
import edu.coursework.sportschool.service.coach.impls.CoachServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/ui/coach")
@Controller
public class CoachUIController {

    @Autowired
    CoachServiceImpl coachService;

    @RequestMapping("/get/all")
    public String showAll(Model model){
        List<Coach> coachList = coachService.getAll();
        model.addAttribute("coachList", coachList);
        return "coach/coachList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Coach coach = coachService.getById(id);
        model.addAttribute("coach", coach);

        List<Sport> sportList = Arrays.asList(Sport.values());
        model.addAttribute("sportList", sportList);
        return "coach/updateCoach";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Coach coach = new Coach();
        model.addAttribute("coach", coach);

        List<Sport> sportList = Arrays.asList(Sport.values());
        model.addAttribute("sportList", sportList);
        return "coach/newCoach";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("coach") @RequestBody Coach coach) {
        model.addAttribute("coach", coachService.create(coach));
        return "redirect:/ui/coach/get/all";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("coach") @RequestBody Coach coach) {

        coachService.update(coach);
        return "redirect:/ui/coach/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        coachService.delete(id);
        return "redirect:/ui/coach/get/all";
    }
}
