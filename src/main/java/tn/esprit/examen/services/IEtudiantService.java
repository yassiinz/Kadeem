package tn.esprit.examen.services;

import tn.esprit.examen.entities.Departement;
import tn.esprit.examen.entities.Etudiant;
import tn.esprit.examen.entities.Option;

import java.util.List;

public interface IEtudiantService {
    List<Etudiant> retrieveAllEtudiants();
    Etudiant addEtudiant (Etudiant e, Option o);
    Etudiant addAndAssignEtudiant (Etudiant e, Option o, Departement d);
     Etudiant updateEtudiant (Etudiant e);
    Etudiant retrieveEtudiant(Integer idEtudiant);
    void removeEtudiant(Integer idEtudiant);
}
