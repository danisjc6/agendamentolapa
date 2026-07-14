package br.edu.ufape.agendamentolapa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.edu.ufape.agendamentolapa.dto.AgendamentoDTO;
import br.edu.ufape.agendamentolapa.mapper.AgendamentoMapper;
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

    // Listar
    @GetMapping
    public List<AgendamentoDTO> listar() {
        return service.listar();
    }

    // Buscar por id
    @GetMapping("/{id}")
    public AgendamentoDTO buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // Criar
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AgendamentoDTO salvar(
            @Valid @RequestBody AgendamentoDTO dto) {

        Agendamento agendamento = service.salvar(dto);

        return AgendamentoMapper.toDTO(agendamento);
    }

    // Atualizar
    @PutMapping("/{id}")
    public AgendamentoDTO atualizar(
            @PathVariable Long id,
            @Valid @RequestBody AgendamentoDTO dto) {

        dto.setId(id);

        Agendamento agendamento = service.salvar(dto);

        return AgendamentoMapper.toDTO(agendamento);
    }

    // Excluir
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}