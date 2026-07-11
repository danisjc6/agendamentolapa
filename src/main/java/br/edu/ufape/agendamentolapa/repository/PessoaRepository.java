package br.edu.ufape.agendamentolapa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ufape.agendamentolapa.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}


