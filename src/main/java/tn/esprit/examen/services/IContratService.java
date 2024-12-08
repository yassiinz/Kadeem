package tn.esprit.examen.services;

import tn.esprit.examen.entities.Contrat;

import java.util.List;

public interface IContratService {
    List<Contrat> retrieveAllContrats();
    Contrat addContrat (Contrat ce);
    Contrat updateContrat (Contrat ce);
    Contrat retrieveContrat (Integer idContrat);
    void removeContrat(Integer idContrat);
}
