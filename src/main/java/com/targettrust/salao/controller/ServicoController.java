package com.targettrust.salao.controller;

import com.targettrust.salao.business.ServicoMapper;
import com.targettrust.salao.business.ServicoService;
import com.targettrust.salao.entity.Servico;
import com.targettrust.salao.model.ServicoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@RestController
@Slf4j
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @PostMapping("/servico/cadastrar")
    public ResponseEntity<ServicoDTO> cadastrarservico(@RequestBody ServicoDTO servicoDTO, UriComponentsBuilder builder) {
        log.info("Entrando no servicoController.salvar");

        Servico servico = servicoService.salvar(servicoDTO);

        log.info("servico cadastrada com sucesso.");
        URI uri = builder.path("/servico/cadastrar/{id}").buildAndExpand(servico.getId()).toUri();

        return ResponseEntity.created(uri).body(ServicoMapper.instance.servicoToServicoDTO(servico));
    }

    @GetMapping("/servico/{id}")
    public ResponseEntity<ServicoDTO> buscarservico(@PathVariable("id") long id) {
        log.info("Entrando no servicoController.buscarservico");

        Optional<Servico> servico = servicoService.buscarServico(id);

        log.info("Retornou a servico");
        if (servico.isPresent()) {
            return new ResponseEntity<ServicoDTO>(ServicoMapper.instance.servicoToServicoDTO(servico.get()), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/servicos")
    public List<ServicoDTO> buscarservicos() {
        return ServicoMapper.instance.listServicoToServicoDTO(servicoService.buscarServicos());
    }

    @PutMapping("/servicos/atualizar/{id}")
    public ResponseEntity<ServicoDTO> atualizar(@RequestBody ServicoDTO servicoDTO, @PathVariable Long id, UriComponentsBuilder builder) throws Exception {
        ServicoDTO servicoDTO1 = servicoService.atualizar(servicoDTO, id);

        URI uri = builder.path("/servico/atualizar/{id}").buildAndExpand(servicoDTO1.getId()).toUri();

        return ResponseEntity.created(uri).body(servicoDTO1);
    }

    @GetMapping("/servicos/buscarPorCodigo")
    public ResponseEntity<ServicoDTO> buscarPorCodigo(@RequestBody ServicoDTO servicoDTO) {

        ServicoDTO servico = servicoService.buscarPorCodigo(servicoDTO.getCodigo());
        if (!isNull(servico)) {
            return new ResponseEntity<ServicoDTO>(servico, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/servico/deletar/{id}")
    public ResponseEntity deletar (@PathVariable Long id) {
        servicoService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
