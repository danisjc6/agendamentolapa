package br.edu.ufape.agendamentolapa.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.agendamentolapa.model.Sala;
import br.edu.ufape.agendamentolapa.service.SalaService;

@RestController
@RequestMapping("/salas")

public class SalaController {
	
	private final SalaService service;

	SalaController(SalaService service) {
		this.service = service;
	}

	@GetMapping
	public List<Sala> listar() {
		return service.listar();
	}

	@PostMapping
	public Sala salvar(@RequestBody Sala sala) {
		return service.salvar(sala);
	}
}
