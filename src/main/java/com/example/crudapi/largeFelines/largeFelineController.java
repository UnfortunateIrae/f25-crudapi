package com.example.crudapi.largeFelines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class largeFelineController {

    @Autowired
    private largeFelineService service;

    @GetMapping({"/felines", "/felines/"})
    public Object getAllFelines(Model model) {
        System.out.println("Getting all felines");
        model.addAttribute("felines", service.getAllFelines());
        model.addAttribute("title", "Large Felines");
        return "felines-list";
    }

    @GetMapping("/felines/{id}")
    public String getFelineById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("feline", service.getFelineById(id));
        model.addAttribute("title", "Feline Details");
        return "felines-details";
    }

    

    @GetMapping("/felines/name")
    public Object getFelinesByName(@RequestParam String name, Model model) {
        if (name != null) {
            model.addAttribute("felines", service.getFelinesByName(name));
            model.addAttribute("title", "Felines Named " + name);
            return "felines-list";
        }
        else {
            return "redirect:/felines";
        }
        }

    @GetMapping("/felines/habitat/{habitat}")
    public Object getFelinesByHabitat(@RequestParam String habitat, Model model) {
        model.addAttribute("felines", service.getFelinesByHabitat(habitat));
        model.addAttribute("title", "Felines in Habitat: " + habitat);
        return "felines-list";
    }

    @GetMapping("/felines/population/{population}")
    public Object getFelinesByPopulationGreaterThan(@RequestParam String population, Model model) {
        model.addAttribute("felines", service.getFelinesByPopulationGreaterThan(Integer.parseInt(population)));
        model.addAttribute("title", "Felines with Population Greater Than: " + population);
        return "felines-list";
    }

    @GetMapping("/felines/weight/{weight}")
    public Object getFelinesByWeightGreaterThan(@RequestParam String weight, Model model) {
       model.addAttribute("felines", service.getFelinesByWeightGreaterThan(Double.parseDouble(weight)));
       model.addAttribute("title", "Felines with Weight Greater Than: " + weight);
         return "felines-list";
    }

    @GetMapping("/felines/updateForm/{id}")
    public Object showUpdateForm(@PathVariable Long id, Model model) {
        largeFeline feline = service.getFelineById(id);
        model.addAttribute("feline", feline);
        model.addAttribute("title", "Update Feline");
        return "felines-update";
    }

    @GetMapping("/felines/createForm")
    public Object showCreateForm(Model model) {
        largeFeline feline = new largeFeline();
        model.addAttribute("feline", feline);
        model.addAttribute("title", "Create New Feline");
        return "felines-create";
    }

    @PostMapping("/felines")
    public Object createFeline(@RequestBody largeFeline feline) {
        largeFeline createdFeline = (largeFeline) service.createFeline(feline);
        return "redirect:/felines/" + createdFeline.getId();
    }

    @PostMapping("/felines/update/{id}")
    public Object updateFeline(@PathVariable("id") Long id, @RequestBody largeFeline feline) {
        service.updateFeline(id, feline);
        return "redirect:/felines/" + id;
    }

    @GetMapping("/felines/delete/{id}")
    public Object deleteFeline(@PathVariable("id") Long id) {
        service.deleteFeline(id);
        return "redirect:/felines";
    }

}