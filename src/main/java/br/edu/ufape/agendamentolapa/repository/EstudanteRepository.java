package br.edu.ufape.agendamentolapa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ufape.agendamentolapa.model.Estudante;

public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
	 
	Optional<Estudante> findByMatricula(String matricula);

	Optional<Estudante> findByCpf(String cpf);

	Optional<Estudante> findByEmail(String email);
}
