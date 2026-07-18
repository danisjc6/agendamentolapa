package br.edu.ufape.agendamentolapa.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.ufape.agendamentolapa.model.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
	
	@Query("""
			SELECT a FROM Agendamento a
			WHERE a.sala.id = :salaId
			AND a.dataInicio = :data
			AND (
			    :inicio < a.horarioFinal
			    AND :fim > a.horarioInicial
			)
			""")
			List<Agendamento> verificarConflitos(
			        @Param("salaId") Long salaId,
			        @Param("data") LocalDate data,
			        @Param("inicio") LocalTime inicio,
			        @Param("fim") LocalTime fim);
}