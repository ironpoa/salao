package com.targettrust.salao.business;

import com.targettrust.salao.entity.Profissional;
import com.targettrust.salao.model.ProfissionalDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProfissionaMapper {

    ProfissionaMapper instance = Mappers.getMapper(ProfissionaMapper.class);

    Profissional profissionalDtoToProfissional (ProfissionalDTO profissionalDTO);
    ProfissionalDTO profissionalToProfissionalDTO (Profissional profissional);
    List<ProfissionalDTO> listProfissionalToProfissionalDTO(List<Profissional> profissionais);
    List<Profissional> listProfissionalDtoToProfissionalDTO(List<ProfissionalDTO> profissionalDTO);
}
