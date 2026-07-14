package br.edu.ufape.agendamentolapa.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.edu.ufape.agendamentolapa.dto.SalaDTO;
import br.edu.ufape.agendamentolapa.mapper.SalaMapper;
import br.edu.ufape.agendamentolapa.model.Sala;
import br.edu.ufape.agendamentolapa.service.SalaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/salas")
public class SalaController {

    private final SalaService service;

    public SalaController(SalaService service) {
        this.service = service;
    }

    @GetMapping
    public List<SalaDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public SalaDTO buscar(@PathVariable Long id) {

        return SalaMapper.toDTO(
                service.buscarPorId(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SalaDTO salvar(
            @Valid @RequestBody SalaDTO dto) {

        Sala sala = SalaMapper.toEntity(dto);

        sala = service.salvar(sala);

        return SalaMapper.toDTO(sala);
    }

    @PutMapping("/{id}")
    public SalaDTO atualizar(
            @PathVariable Long id,
            @Valid @RequestBody SalaDTO dto) {

        Sala sala = SalaMapper.toEntity(dto);

        sala.setId(id);

        sala = service.salvar(sala);

        return SalaMapper.toDTO(sala);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}

