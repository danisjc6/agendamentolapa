package br.edu.ufape.agendamentolapa.controller;


import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import br.edu.ufape.agendamentolapa.model.Servidor;
import br.edu.ufape.agendamentolapa.service.ServidorService;

	@RestController
	@RequestMapping("/servidores")
	public class ServidorController {
		private final ServidorService service;

	    public ServidorController(ServidorService service) {
	        this.service = service;
	    }

	    // Listar todas
	    @GetMapping
	    public List<Servidor> listar() {
	        return service.listar();
	    }

	    // Buscar por id
	    @GetMapping("/{id}")
	    public Optional<Servidor> buscar(@PathVariable Long id) {
	        return service.buscarPorId(id);
	    }

	    // Salvar
	    @PostMapping
	    @ResponseStatus(HttpStatus.CREATED)
	    public Servidor salvar(@RequestBody Servidor sala) {
	        return service.salvar(sala);
	    }

	    // Atualizar
	    @PutMapping("/{id}")
	    public Servidor atualizar(@PathVariable Long id,
	                          @RequestBody Servidor sala) {

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


