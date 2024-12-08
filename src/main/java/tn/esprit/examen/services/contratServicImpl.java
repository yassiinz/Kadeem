package tn.esprit.examen.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.examen.entities.Contrat;
import tn.esprit.examen.repositories.ContratRepository;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class contratServicImpl implements IContratService{
    ContratRepository contratRepository;
    public List<Contrat> retrieveAllContrats(){
        return contratRepository.findAll();
    }
    public Contrat addContrat (Contrat ce){
        return contratRepository.save(ce);
    }
    public Contrat updateContrat (Contrat ce){
        return contratRepository.save(ce);
    }
    public Contrat retrieveContrat (Integer idContrat){
        return contratRepository.findById(idContrat).get();
    }
    public void removeContrat(Integer idContrat){
        contratRepository.deleteById(idContrat);
    }
}
