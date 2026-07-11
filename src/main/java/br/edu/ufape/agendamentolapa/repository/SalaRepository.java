package br.edu.ufape.agendamentolapa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ufape.agendamentolapa.model.Sala;

public interface SalaRepository extends JpaRepository<Sala, Long> {

}