package org.enspy.GestionParcInfo.controller;

import org.enspy.GestionParcInfo.dto.MaterielDTO;
import org.enspy.GestionParcInfo.service.BureauService;
import org.enspy.GestionParcInfo.service.MaterielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @Autowired
    MaterielService materielService;

    @Autowired
    BureauService bureauService;

    @GetMapping({"/admin","Admin.html"})
    public String adminHome(){
        return "Admin";
    }

    @GetMapping({"/", "/home"})
    public String Home(){
        return "index";
    }

    //Materiel
    @GetMapping("/admin/materiels")
    public String getMat(Model model){
        model.addAttribute("materiel", materielService.getAllMateriel());
        return "materiels";
    }

    @GetMapping("/admin/materiels/add")
    public String getMatAdd(Model model){
        model.addAttribute("materielDTO", new MaterielDTO());
        return "ajouterM";
    }



}
