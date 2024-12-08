package tn.esprit.examen.services;

import tn.esprit.examen.entities.Equipe;

import java.util.List;

public interface IEquipeService {
    List<Equipe> retrieveAllEquipes();
    Equipe addEquipe(Equipe  e);
    Equipe updateEquipe (Equipe  e);
    Equipe retrieveEquipe (Integer idEquipe);
    void removeEquipe (Integer idEquipe);
}
