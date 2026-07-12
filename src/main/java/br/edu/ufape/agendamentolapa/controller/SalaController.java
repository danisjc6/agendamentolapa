package br.edu.ufape.agendamentolapa.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import br.edu.ufape.agendamentolapa.model.Sala;
import br.edu.ufape.agendamentolapa.service.SalaService;

@RestController
@RequestMapping("/salas")
public class SalaController {

    private final SalaService service;

    public SalaController(SalaService service) {
        this.service = service;
    }

    // Listar todas
    @GetMapping
    public List<Sala> listar() {
        return service.listar();
    }

    // Buscar por id
    @GetMapping("/{id}")
    public Sala buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // Salvar
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Sala salvar(@RequestBody Sala sala) {
        return service.salvar(sala);
    }

    // Atualizar
    @PutMapping("/{id}")
    public Sala atualizar(@PathVariable Long id,
                          @RequestBody Sala sala) {

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