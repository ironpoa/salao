package com.targettrust.salao.business;

import com.targettrust.salao.entity.Pessoa;
import com.targettrust.salao.model.PessoaDTO;
import com.targettrust.salao.repository.PessoaDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PessoaService {

    @Autowired
    private PessoaDao pessoaDao;

    public Pessoa cadastrar (PessoaDTO pessoaDTO) {
        log.info("Entrando PessoaService.cadastrar");

        return pessoaDao.save(PessoaMapper.instance.pessoaDtoToPessoa(pessoaDTO));
    }

    public List<Pessoa> mapperList(List<PessoaDTO> pessoas) {
        return pessoas.stream().map(Pessoa::new).collect(Collectors.toList());
    }

    public Pessoa buscarPessoa(long id) {
        log.info("Entrando no metodo buscarPessoas");
        return pessoaDao.findById(id).get();
    }

    public List<PessoaDTO> buscarPessoas() {
        return PessoaMapper.instance.listPessoaToPessoaDto(pessoaDao.findAll());
    }

    public List<PessoaDTO> buscarPessoasPorNomeSobrenomeCpf(PessoaDTO pessoaDTO) {
        List<Pessoa> pessoas = pessoaDao.buscarPessoasPorNomeSobrenomeCpf(pessoaDTO.getNome(), pessoaDTO.getSobrenome(), pessoaDTO.getCpf());

        return PessoaMapper.instance.listPessoaToPessoaDto(pessoas);
    }
}