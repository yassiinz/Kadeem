package tn.esprit.examen.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen.entities.Departement;
import tn.esprit.examen.entities.Etudiant;
import tn.esprit.examen.entities.Option;
import tn.esprit.examen.services.IEtudiantService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantController {
    IEtudiantService etudiantService;
    @PostMapping("/add-etudiant/{o}")
    @ResponseBody
    public Etudiant addEtudiant(@RequestBody Etudiant e, @PathVariable("o") Option o) {
        Etudiant etudiant = etudiantService.addEtudiant(e,o);
        return etudiant;
    }
    @PostMapping("/add-etudToDep/{o}/{d}")
    @ResponseBody
    public Etudiant addAndAssignEtudiant(@RequestBody Etudiant e, @PathVariable("o") Option o, @PathVariable("d") Integer d) {
        Departement departement = new Departement();
        departement.setIdDepart(d);
        Etudiant etudiant = etudiantService.addAndAssignEtudiant(e,o,departement);
        return etudiant;
    }
    @GetMapping("/retriveAll")
    @ResponseBody
    public List<Etudiant> retriveAllEtudiant() {
        List<Etudiant> etudiants = etudiantService.retrieveAllEtudiants();
        return etudiants;
    }
    @PutMapping("/updateEtud")
    @ResponseBody
    public Etudiant updateEtudiant(@RequestBody Etudiant etudiant) {
        Etudiant etudiant1 = etudiantService.updateEtudiant(etudiant);
        return etudiant1;

    }
    @GetMapping("/get-etudById/{id}")
    @ResponseBody
    public Etudiant retrieveEtudiant(@PathVariable("id") Integer id){
        Etudiant etudiant = etudiantService.retrieveEtudiant(id);
        return etudiant;
    }
    @DeleteMapping("/removeEtud/{id}")
    public void removeEtudiant(@PathVariable("id") Integer id) {
        etudiantService.removeEtudiant(id);
    }

    @PutMapping("/assignEtudiantToEquipe/{idetud}/{idequipe}")
    public void assignEtudiantToEquipe(@PathVariable("idetud") Integer idetud , @PathVariable("idequipe") Integer idequipe){
        etudiantService.assignEtudiantToEquipe(idetud,idequipe);
    }

    @PutMapping("/assignEtudiantDepartement/{etudiantId}/{departementId}")
    public void assignEtudiantDepartement(@PathVariable("etudiantId") Integer etudiantId,@PathVariable("departementId") Integer departementId){
        etudiantService.assignEtudiantDepartement(etudiantId,departementId);
    }
    @PutMapping("/assignEtudiantToContrat/{etudId}/{idcontrat}")
    public void assignEtudiantToContrat(@PathVariable("etudId") Integer etudiantId,@PathVariable("idcontrat") Integer idcontrat){
        etudiantService.assignEtudiantToContrat(etudiantId,idcontrat);
    }

    @GetMapping("/getEtudiantsByDepartement/{idDep}")
    public List<Etudiant> getEtudiantsByDepartement(@PathVariable("idDep") Integer idDep){
        return etudiantService.getEtudiantsByDepartement(idDep);
    }

}
