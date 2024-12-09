package tn.esprit.examen.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.examen.entities.*;
import tn.esprit.examen.repositories.ContratRepository;
import tn.esprit.examen.repositories.DepartementRepository;
import tn.esprit.examen.repositories.EquipeRepository;
import tn.esprit.examen.repositories.EtudiantRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class EtudiantServicImpl implements IEtudiantService {
    EtudiantRepository etudiantRepository;
    DepartementRepository departementRepository;
    EquipeRepository equipeRepository;
    ContratRepository contratRepository;
    @Override
    public List<Etudiant> retrieveAllEtudiants(){
        return etudiantRepository.findAll();
    }
    @Override
    public Etudiant addEtudiant (Etudiant e, Option o) {
        e.setEtudiantOption(o);
        etudiantRepository.save(e);
        return e;
    }
    @Override
    public Etudiant addAndAssignEtudiant (Etudiant e, Option o, Departement d){
        e.setEtudiantOption(o);
        Departement departement = departementRepository.save(d);
        e.setDepartements(departement);
        return etudiantRepository.save(e);
    }
    public Etudiant updateEtudiant (Etudiant e){
        return etudiantRepository.save(e);
    }
    public Etudiant retrieveEtudiant(Integer idEtudiant){
        return etudiantRepository.findById(idEtudiant).get();
    }
    public void removeEtudiant(Integer idEtudiant){
         etudiantRepository.deleteById(idEtudiant);
    }

    public void assignEtudiantToEquipe(Integer idEtudiant, Integer idEquipe){
        Etudiant etudiant = etudiantRepository.findById(idEtudiant).get();
        Equipe equipe = equipeRepository.findById(idEquipe).get();
        List<Equipe> equipeMiseAJour = new ArrayList<>();
        if (etudiant.getEquipes() != null){
            equipeMiseAJour = etudiant.getEquipes();
        }
        equipeMiseAJour.add(equipe);
        etudiant.setEquipes(equipeMiseAJour);
        etudiantRepository.save(etudiant);
    }
    public void assignEtudiantDepartement(Integer etudiantId, Integer departementId){
        Etudiant etudiant = etudiantRepository.findById(etudiantId).get();
        Departement departement = departementRepository.findById(departementId).get();
        etudiant.setDepartements(departement);
        etudiantRepository.save(etudiant);
    }
    public void assignEtudiantToContrat(Integer idEtudiant, Integer idContrat){
        Etudiant etudiant = etudiantRepository.findById(idEtudiant).get();
        Contrat contrat = contratRepository.findById(idContrat).get();
        etudiant.setContrat(contrat);
        etudiantRepository.save(etudiant);
    }

    public List<Etudiant> getEtudiantsByDepartement (Integer idDepartement){
        return etudiantRepository.getEtudiantByDepartements_IdDepart(idDepartement);
    }
}
