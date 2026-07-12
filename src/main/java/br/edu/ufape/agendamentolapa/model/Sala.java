package br.edu.ufape.agendamentolapa.model;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "salas")

public class Sala {
	private Long id;
	
	@NotBlank
	private String nomeSala;
	
	@Min(1)
	private int capacidade;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Tipo tipo;

	@JsonIgnore
	@OneToMany(mappedBy = "sala")
	private List<Agendamento> agendamentos;
	
	public String getNomeSala() {
		return nomeSala;
	}
	public void setNomeSala(String nomeSala) {
		this.nomeSala = nomeSala;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public enum Tipo {
		REUNIAO,
		LABORATORIO,
		AUDITORIO,
		MUSEU;
	}
	
	public Sala() {
	}
	
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (!(o instanceof Sala)) return false;
	    Sala sala = (Sala) o;
	    return Objects.equals(id, sala.id);
	}

	@Override
	public int hashCode() {
	    return Objects.hash(id);
	}
	
	@Override
	public String toString() {
		return "Sala{" +
	            "id=" + id +
	            ", nomeSala='" + nomeSala + '\'' +
	            ", capacidade=" + capacidade +
	            ", tipo=" + tipo +
	            '}';
	}
	
}