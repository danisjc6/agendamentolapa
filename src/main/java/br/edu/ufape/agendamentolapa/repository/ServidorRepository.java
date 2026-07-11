package br.edu.ufape.agendamentolapa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ufape.agendamentolapa.model.Servidor;


public interface ServidorRepository extends JpaRepository<Servidor, Long> {
}

