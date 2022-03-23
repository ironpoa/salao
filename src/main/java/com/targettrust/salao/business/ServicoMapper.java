package com.targettrust.salao.business;

import com.targettrust.salao.entity.Servico;
import com.targettrust.salao.model.ServicoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ServicoMapper {

    ServicoMapper instance = Mappers.getMapper(ServicoMapper.class);

    Servico ServicoDtoToServico (ServicoDTO ServicoDTO);
    ServicoDTO ServicoToServicoDTO (Servico Servico);
    List<ServicoDTO> listServicoToServicoDTO(List<Servico> servicos);
    List<Servico> listServicoDtoToServicoDTO(List<ServicoDTO> ServicoDTO);
}
