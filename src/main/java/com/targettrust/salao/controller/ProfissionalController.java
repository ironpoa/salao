package com.targettrust.salao.controller;

import com.targettrust.salao.business.ProfisionalService;
import com.targettrust.salao.entity.Profissional;
import com.targettrust.salao.model.ProfissionalDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class ProfissionalController {

    @Autowired
    private ProfisionalService profisionalService;

    @PostMapping( "/profissional/cadastrar")
    public ResponseEntity<ProfissionalDTO> cadastrarProfissional(@RequestBody ProfissionalDTO profissionalDTO, UriComponentsBuilder builder) throws Exception {
        log.info("Controller " +profissionalDTO.getFuncao());

        URI uri = builder.path("/profissional/cadastrar/{id}").buildAndExpand(profisionalService.cadastrar(profissionalDTO).getId()).toUri();

        log.info("Profissional cadastrado com sucesso.");
        return ResponseEntity.created(uri).body(new ProfissionalDTO());
    }

    @GetMapping("/profissionais")
    public List<ProfissionalDTO> buscarProfissionais() {
        return profisionalService.buscarTodos();
    }

    @GetMapping("/profissionais/{id}")
    public ResponseEntity<Profissional> buscarProfissional(@PathVariable long id) {
        return ResponseEntity.ok(profisionalService.buscarProfissionalById(id).get());
    }
    @DeleteMapping("/profissionais/deletar")
    public ResponseEntity<Profissional> deletarProfissional (@RequestBody ProfissionalDTO profissionalDTO) {
        profisionalService.deletar(profissionalDTO);
        return ResponseEntity.ok(new Profissional());
    }

    @GetMapping("/profissional/buscarPorFuncao")
    public List<Profissional> buscarPorFuncao( @RequestBody ProfissionalDTO profissionalDTO) {
        return profisionalService.buscarProfissionalPorFuncao(profissionalDTO);
    }

    @GetMapping("/profissional/buscarPorFuncaoSalario")
    public List<Profissional> buscarPorFuncaoSalario( @RequestBody ProfissionalDTO profissionalDTO) {

        return profisionalService.buscarProfissionalPorFuncaoSalario(profissionalDTO);
    }

}
