package br.edu.ufape.agendamentolapa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import br.edu.ufape.agendamentolapa.dto.EstudanteDTO;
import br.edu.ufape.agendamentolapa.mapper.EstudanteMapper;
import br.edu.ufape.agendamentolapa.model.Estudante;
import br.edu.ufape.agendamentolapa.service.EstudanteService;
import jakarta.validation.Valid;

	@RestController
	@RequestMapping("/estudantes")
	public class EstudanteController {

	    private final EstudanteService service;

	    public EstudanteController(EstudanteService service) {
	        this.service = service;
	    }

	    // Listar todas
	    @GetMapping
	    public List<EstudanteDTO> listar() {
	        return service.listar();
	    }

	    // Buscar por id
	    @GetMapping("/{id}")
	    public EstudanteDTO buscar(@PathVariable Long id) {
	        return EstudanteMapper.toDTO(service.buscarPorId(id));
	    }

	    // Salvar
	    @PostMapping
	    @ResponseStatus(HttpStatus.CREATED)
	    public EstudanteDTO salvar(
	            @Valid @RequestBody EstudanteDTO dto) {

	        Estudante estudante = EstudanteMapper.toEntity(dto);

	        estudante = service.salvar(estudante);

	        return EstudanteMapper.toDTO(estudante);
	    }

	    // Atualizar
	    @PutMapping("/{id}")
	    public EstudanteDTO atualizar(
	            @PathVariable Long id,
	            @Valid @RequestBody EstudanteDTO dto) {

	        Estudante estudante = EstudanteMapper.toEntity(dto);

	        estudante.setId(id);

	        estudante = service.salvar(estudante);

	        return EstudanteMapper.toDTO(estudante);
	    }

	    // Excluir
	    @DeleteMapping("/{id}")
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    public void excluir(@PathVariable Long id) {
	        service.excluir(id);
	    }
	}

