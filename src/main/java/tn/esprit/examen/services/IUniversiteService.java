package tn.esprit.examen.services;

import tn.esprit.examen.entities.Universite;

import java.util.List;

public interface IUniversiteService {
    List<Universite> retrieveAllUniversites();
    Universite addUniversite (Universite u);
    Universite updateUniversite (Universite u);
    Universite retrieveUniversite (Integer idUniversite);
    void removeUniversite (Integer idUniversite);
    void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement);
}
