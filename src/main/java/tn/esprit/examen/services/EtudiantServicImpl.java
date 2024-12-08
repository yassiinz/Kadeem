package tn.esprit.examen.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.examen.entities.Departement;
import tn.esprit.examen.entities.Etudiant;
import tn.esprit.examen.entities.Option;
import tn.esprit.examen.repositories.DepartementRepository;
import tn.esprit.examen.repositories.EtudiantRepository;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class EtudiantServicImpl implements IEtudiantService {
    EtudiantRepository etudiantRepository;
    DepartementRepository departementRepository;
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
        Etudiant etudiant = etudiantRepository.save(e);
        etudiant.setEtudiantOption(o);
        Departement departement = departementRepository.save(d);
        etudiant.setDepartements(departement);
        return e;
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

}
