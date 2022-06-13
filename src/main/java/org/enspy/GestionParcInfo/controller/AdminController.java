package org.enspy.GestionParcInfo.controller;

import org.enspy.GestionParcInfo.dto.MaterielDTO;
import org.enspy.GestionParcInfo.model.Materiel;
import org.enspy.GestionParcInfo.service.BureauService;
import org.enspy.GestionParcInfo.service.CategorieService;
import org.enspy.GestionParcInfo.service.MaterielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @Autowired
    MaterielService materielService;

    @Autowired
    BureauService bureauService;

    @Autowired
    CategorieService categorieService;

    @GetMapping({"/admin","Admin.html"})
    public String adminHome(){
        return "Admin";
    }

    @GetMapping({"/", "/home"})
    public String Home(){
        return "index";
    }

    //Materiel section
    @GetMapping("/admin/materiels")
    public String getMat(Model model){
        model.addAttribute("materiels", materielService.getAllMateriel());
        return "materiels";
    }

    @GetMapping("/admin/materiels/add")
    public String getMatAdd(Model model){
        model.addAttribute("materielDTO", new MaterielDTO());
        model.addAttribute("categories", categorieService.getAllCategorie());
        model.addAttribute("bureaux", bureauService.getAllBureau());
        return "ajouterM";
    }

    @PostMapping("/admin/materiels/add")
    public String postMatAdd(@ModelAttribute("materielDTO")MaterielDTO materielDTO){

        Materiel materiel = new Materiel();

        materiel.setId(materielDTO.getId());
        materiel.setNom(materielDTO.getNom());
        materiel.setNomFabricant(materielDTO.getNomFabricant());
        materiel.setDescription(materielDTO.getDescription());
        materiel.setDateachat(materielDTO.getDateachat());
        materiel.setDureevieestimee(materielDTO.getDureevieestimee());
        materiel.setCategorie(categorieService.getCategorieById(materielDTO.getCategorieId()).get());
        materiel.setBureau(bureauService.getBureauById(materielDTO.getBureauId()).get());
        materiel.setLogiciels(null);
        materiel.setPannes(null);
        materielService.addMateriel(materiel);

        return "redirect:/admin/materiels";
    }

    @GetMapping("/admin/materiel/delete/{id}")
    public String deleteMateriel(@PathVariable Long id){
        materielService.removeMaterielById(id);
        return "redirect:/admin/products";
    }

    @GetMapping("/admin/materiel/update/{id}")
    public String updateMateriel(@PathVariable Long id, Model model){
        Materiel materiel = materielService.getMaterielById(id).get();
        MaterielDTO materielDTO = new MaterielDTO();
        materielDTO.setId(materiel.getId());
        materielDTO.setNom(materiel.getNom());
        materielDTO.setDateachat(materiel.getDateachat());
        materielDTO.setBureauId((materiel.getBureau().getId()));
        materielDTO.setDescription(materiel.getDescription());
        materielDTO.setDureevieestimee(materiel.getDureevieestimee());
        materielDTO.setNomFabricant(materiel.getNomFabricant());
        materielDTO.setCategorieId(materiel.getCategorie().getId());

        model.addAttribute("materielDTO", materielDTO);

        return "ajouterM";
    }

}
