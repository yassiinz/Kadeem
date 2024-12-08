package tn.esprit.examen.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.examen.entities.Equipe;
import tn.esprit.examen.repositories.EquipeRepository;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class equipeServicImpl implements IEquipeService{
    EquipeRepository equipeRepository;
    public List<Equipe> retrieveAllEquipes(){
        return equipeRepository.findAll();
    }
    public Equipe addEquipe(Equipe  e){
        return equipeRepository.save(e);
    }
    public Equipe updateEquipe (Equipe  e){
        return equipeRepository.save(e);
    }
    public Equipe retrieveEquipe (Integer idEquipe){
        return equipeRepository.findById(idEquipe).get();
    }
    public void removeEquipe (Integer idEquipe){
        equipeRepository.deleteById(idEquipe);
    }
}
