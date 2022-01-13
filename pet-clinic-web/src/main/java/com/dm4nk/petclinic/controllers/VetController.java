package com.dm4nk.petclinic.controllers;

import com.dm4nk.petclinic.model.Vet;
import com.dm4nk.petclinic.services.VetService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class VetController {

    VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "/vets/", "/vets/index", "/vets/index.html", "/vets.html"})
    public String listVets(Model model) {

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }

    @GetMapping({"/api/vets", "/api/vets.html"})
    public @ResponseBody
    Set<Vet> getVetsJson() {
        return vetService.findAll();
    }
}
