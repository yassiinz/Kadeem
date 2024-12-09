package tn.esprit.examen.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.examen.entities.Departement;
import tn.esprit.examen.entities.Universite;
import tn.esprit.examen.repositories.DepartementRepository;
import tn.esprit.examen.repositories.UniversiteRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class universiteServicImpl implements IUniversiteService {
    UniversiteRepository universiteRepository;
    DepartementRepository departementRepository;
    public List<Universite> retrieveAllUniversites(){
        return universiteRepository.findAll();
    }
    public Universite addUniversite (Universite u){
        return universiteRepository.save(u);
    }
    public Universite updateUniversite (Universite u){
        return universiteRepository.save(u);
    }
    public Universite retrieveUniversite (Integer idUniversite){
        return universiteRepository.findById(idUniversite).get();
    }
    public void removeUniversite (Integer idUniversite){
        universiteRepository.deleteById(idUniversite);
    }

    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement){
        Universite universite = universiteRepository.findById(idUniversite).get();
        Departement departement = departementRepository.findById(idDepartement).get();
        List<Departement> departements = new ArrayList<>();
        if(universite.getDepartement() != null){
            departements = universite.getDepartement();
        }
        departements.add(departement);
        universite.setDepartement(departements);
        universiteRepository.save(universite);
    }
}
