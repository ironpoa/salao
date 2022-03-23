package com.targettrust.salao.business;

import com.targettrust.salao.entity.Profissional;
import com.targettrust.salao.model.ProfissionalDTO;
import com.targettrust.salao.repository.ProfissionalDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProfisionalService {

    @Autowired
    private ProfissionalDao profissionalDao;

    public ProfissionalDTO cadastrar(ProfissionalDTO profissionalDTO)  {
        log.info("Entrando no metodo ProfissionalService.cadastrar");

        return ProfissionaMapper.instance.profissionalToProfissionalDTO(profissionalDao.save(ProfissionaMapper.instance.profissionalDtoToProfissional(profissionalDTO)));
    }

    public Optional<Profissional> buscarProfissionalById (long id) {
        return profissionalDao.findById(id);
    }

    public void deletar (ProfissionalDTO profissionalDTO) {
        log.info("Metodo deletar");
        buscarProfissionalPorFuncao(profissionalDTO).forEach(prof -> profissionalDao.delete(prof));
        log.info ( "Registro deletado");
    }

    public List<Profissional> buscarProfissionalPorFuncao (ProfissionalDTO profissionalDTO) {
        log.info("buscando profissional por funcao" +profissionalDTO.getFuncao());
        return profissionalDao.findByFuncao(profissionalDTO.getFuncao());
    }

    public List<Profissional> buscarProfissionalPorFuncaoSalario (ProfissionalDTO dto) {
        return profissionalDao.findByFuncaoAndSalarioGreaterThan(dto.getFuncao(), dto.getSalario());
    }

    public List<ProfissionalDTO> buscarTodos() {
        return ProfissionaMapper.instance.listProfissionalToProfissionalDTO(profissionalDao.findAll());
    }
}
