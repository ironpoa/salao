package com.targettrust.salao.controller;

import com.targettrust.salao.business.PessoaMapper;
import com.targettrust.salao.business.PessoaService;
import com.targettrust.salao.entity.Pessoa;
import com.targettrust.salao.model.PessoaDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/pessoa/cadastrar")
    public ResponseEntity<PessoaDTO> cadastrarPessoa(@RequestBody PessoaDTO pessoaDTO, UriComponentsBuilder builder) {
        log.info("Entrando no PessoaController.cadastrarPessoa");

         Pessoa pessoa = pessoaService.cadastrar(pessoaDTO);

        log.info("Pessoa cadastrada com sucesso.");
        URI uri = builder.path("/pessoa/cadastrar/{id}").buildAndExpand(pessoa.getId()).toUri();

        return ResponseEntity.created(uri).body(new PessoaDTO());
    }

    @GetMapping("/pessoa/{id}")
    public ResponseEntity<PessoaDTO> buscarPessoa(@PathVariable("id") long id) {
        log.info("Entrando no PessoaController.buscarPessoa");

        Optional<PessoaDTO> pessoaDTO = Optional.ofNullable(PessoaMapper.instance.pessoaToPessoaDto(pessoaService.buscarPessoa(id)));
        log.info("Retornou a pessoa");
        if (pessoaDTO.isPresent()) {
            return new ResponseEntity<PessoaDTO>(pessoaDTO.get(), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/pessoas")
    public List<PessoaDTO> buscarPessoas(){
        return pessoaService.buscarPessoas();
    }

    @GetMapping("/pessoas/buscarPessoaNomeSobrenomeCpf")
    public ResponseEntity<List<PessoaDTO>> buscarPessoaNomeSobrenomeCpf (@RequestBody PessoaDTO pessoaDTO) {
        List <PessoaDTO> pessoas = pessoaService.buscarPessoasPorNomeSobrenomeCpf(pessoaDTO);
        if (!pessoas.isEmpty()) {
            return new ResponseEntity <List<PessoaDTO>>(pessoas, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

