package edu.coursework.sportschool.controller.ui;

/*
    @author:    Anton
    @project:    SportSchool
    @class:    PlacesUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.sportschool.model.Places;
import edu.coursework.sportschool.service.places.impls.PlacesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/places")
@Controller
public class PlacesUIController {

    @Autowired
    PlacesServiceImpl placesService;

    @RequestMapping("/get/all")
    public String showAll(Model model){
        List<Places> placesList = placesService.getAll();
        model.addAttribute("placesList", placesList);
        return "places/placesList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Places places = placesService.getById(id);
        model.addAttribute("places",places);
        return "places/updatePlaces";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Places places = new Places();
        model.addAttribute("places", places);
        return "places/newPlaces";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("places") @RequestBody Places places) {
        model.addAttribute("places", placesService.create(places));
        return "redirect:/ui/places/get/all";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("places") @RequestBody Places places) {

        placesService.update(places);
        return "redirect:/ui/places/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        placesService.delete(id);
        return "redirect:/ui/places/get/all";
    }
}
