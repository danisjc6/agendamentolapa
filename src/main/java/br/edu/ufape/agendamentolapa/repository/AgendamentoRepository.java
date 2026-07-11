package br.edu.ufape.agendamentolapa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufape.agendamentolapa.model.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

}