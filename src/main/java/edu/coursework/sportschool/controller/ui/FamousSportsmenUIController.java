package edu.coursework.sportschool.controller.ui;

/*
    @author:    Anton
    @project:    SportSchool
    @class:    FamousSportsmenUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.sportschool.model.FamousSportsmen;
import edu.coursework.sportschool.model.Sportsmen;
import edu.coursework.sportschool.service.famousSportsmen.impls.FamousSportsmenServiceImpl;
import edu.coursework.sportschool.service.sportsmen.impls.SportsmenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/famousSportsmen")
@Controller
public class FamousSportsmenUIController {

    @Autowired
    FamousSportsmenServiceImpl famousSportsmenService;

    @Autowired
    SportsmenServiceImpl sportsmenService;

    @RequestMapping("/get/all")
    public String showAll(Model model){
        List<FamousSportsmen> famousSportsmenList = famousSportsmenService.getAll();
        model.addAttribute("famousSportsmenList", famousSportsmenList);
        return "famousSportsmen/famousSportsmenList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        FamousSportsmen famousSportsmen = famousSportsmenService.getById(id);
        model.addAttribute("famousSportsmen", famousSportsmen);

        List<Sportsmen> sportsmenList = sportsmenService.getAll();
        model.addAttribute("sportsmenList", sportsmenList);
        return "famousSportsmen/updateFamousSportsmen";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        FamousSportsmen famousSportsmen = new FamousSportsmen();
        model.addAttribute("famousSportsmen", famousSportsmen);

        List<Sportsmen> sportsmenList = sportsmenService.getAll();
        model.addAttribute("sportsmenList", sportsmenList);
        return "famousSportsmen/newFamousSportsmen";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("famousSportsmen") @RequestBody FamousSportsmen famousSportsmen) {
        model.addAttribute("famousSportsmen", famousSportsmenService.create(famousSportsmen));
        return "redirect:/ui/famousSportsmen/get/all";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("famousSportsmen") @RequestBody FamousSportsmen famousSportsmen) {

        famousSportsmenService.update(famousSportsmen);
        return "redirect:/ui/famousSportsmen/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        famousSportsmenService.delete(id);
        return "redirect:/ui/famousSportsmen/get/all";
    }
}
