package tn.esprit.examen.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.examen.entities.Departement;
import tn.esprit.examen.repositories.DepartementRepository;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class departementServicImpl implements IDepartementService{
    DepartementRepository departementRepository;
    public List<Departement> retrieveAllDepartements(){
        return departementRepository.findAll();
    }
    public Departement addDepartement (Departement d){
        return departementRepository.save(d);
    }
    public Departement updateDepartement (Departement d){
        return departementRepository.save(d);
    }
    public Departement retrieveDepartement (Integer idDepart){
        return departementRepository.findById(idDepart).get();
    }

}
