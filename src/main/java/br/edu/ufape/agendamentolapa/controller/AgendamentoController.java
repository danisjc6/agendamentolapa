package br.edu.ufape.agendamentolapa.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import br.edu.ufape.agendamentolapa.model.Agendamento;
import br.edu.ufape.agendamentolapa.service.AgendamentoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    private final AgendamentoService service;

    public AgendamentoController(AgendamentoService service) {
        this.service = service;
    }

    // Listar todos
    @GetMapping
    public List<Agendamento> listar() {
        return service.listar();
    }

    // Buscar por id
    @GetMapping("/{id}")
    public Agendamento buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // Criar
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Agendamento salvar(@Valid @RequestBody Agendamento agendamento) {
        return service.salvar(agendamento);
    }

    // Atualizar
    @PutMapping("/{id}")
    public Agendamento atualizar(@PathVariable Long id,
                                 @Valid @RequestBody Agendamento agendamento) {

        agendamento.setId(id);
        return service.salvar(agendamento);
    }

    // Excluir
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}