package tn.esprit.examen.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.examen.repositories.UniversiteRepository;
import tn.esprit.examen.services.IUniversiteService;

@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteController {
    IUniversiteService universiteService;
    @PutMapping("/assignEtudiantToEquipe/{iduni}/{idDep}")
    public void assignUniversiteToDepartement(@PathVariable("iduni") Integer iduni , @PathVariable("idDep") Integer idDep){
        universiteService.assignUniversiteToDepartement(iduni,idDep);
    }
}
