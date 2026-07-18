package br.edu.ufape.agendamentolapa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.edu.ufape.agendamentolapa.dto.ServidorDTO;
import br.edu.ufape.agendamentolapa.mapper.ServidorMapper;
import br.edu.ufape.agendamentolapa.model.Servidor;
import br.edu.ufape.agendamentolapa.service.ServidorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/servidores")
public class ServidorController {

    private final ServidorService service;

    public ServidorController(ServidorService service) {
        this.service = service;
    }

    @GetMapping
    public List<ServidorDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ServidorDTO buscar(@PathVariable Long id) {
        return ServidorMapper.toDTO(
                service.buscarPorId(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServidorDTO salvar(
            @Valid @RequestBody ServidorDTO dto) {

        Servidor servidor = ServidorMapper.toEntity(dto);

        servidor = service.salvar(servidor);

        return ServidorMapper.toDTO(servidor);
    }

    @PutMapping("/{id}")
    public ServidorDTO atualizar(
            @PathVariable Long id,
            @Valid @RequestBody ServidorDTO dto) {

        Servidor servidor = ServidorMapper.toEntity(dto);

        servidor.setId(id);

        servidor = service.salvar(servidor);

        return ServidorMapper.toDTO(servidor);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}