package tn.esprit.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examen.entities.Universite;

public interface UniversiteRepository extends JpaRepository<Universite, Integer> {
}
