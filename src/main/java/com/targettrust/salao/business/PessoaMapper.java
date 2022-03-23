package com.targettrust.salao.business;

import com.targettrust.salao.entity.Pessoa;
import com.targettrust.salao.model.PessoaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    PessoaMapper instance = Mappers.getMapper(PessoaMapper.class);

    Pessoa pessoaDtoToPessoa (PessoaDTO pessoaDTO);
    PessoaDTO pessoaToPessoaDto (Pessoa pessoa);
    List<PessoaDTO> listPessoaToPessoaDto(List<Pessoa> pessoas);
    List<Pessoa> listPessoaDtoToPessoa(List<PessoaDTO> pessoasDto);


}
