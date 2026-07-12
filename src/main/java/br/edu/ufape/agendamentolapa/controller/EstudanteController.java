package br.edu.ufape.agendamentolapa.controller;


import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import br.edu.ufape.agendamentolapa.model.Estudante;
import br.edu.ufape.agendamentolapa.service.EstudanteService;

	@RestController
	@RequestMapping("/estudantes")
	public class EstudanteController {

	    private final EstudanteService service;

	    public EstudanteController(EstudanteService service) {
	        this.service = service;
	    }

	    // Listar todas
	    @GetMapping
	    public List<Estudante> listar() {
	        return service.listar();
	    }

	    // Buscar por id
	    @GetMapping("/{id}")
	    public Optional<Estudante> buscar(@PathVariable Long id) {
	        return service.buscarPorId(id);
	    }

	    // Salvar
	    @PostMapping
	    @ResponseStatus(HttpStatus.CREATED)
	    public Estudante salvar(@RequestBody Estudante sala) {
	        return service.salvar(sala);
	    }

	    // Atualizar
	    @PutMapping("/{id}")
	    public Estudante atualizar(@PathVariable Long id,
	                          @RequestBody Estudante sala) {

	        sala.setId(id);
	        return service.salvar(sala);
	    }

	    // Excluir
	    @DeleteMapping("/{id}")
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    public void excluir(@PathVariable Long id) {
	        service.excluir(id);
	    }
	}

