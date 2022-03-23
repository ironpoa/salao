package com.targettrust.salao.business;

import com.targettrust.salao.entity.Servico;
import com.targettrust.salao.model.ServicoDTO;
import com.targettrust.salao.repository.ServicoDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ServicoService {

    @Autowired
    private ServicoDao servicoDao;

    public Optional<Servico> buscarServico (Long id) {
        return servicoDao.findById(id);
    }

    public List<Servico> buscarServicos (ServicoDTO ServicoDTO) {
        return servicoDao.findAll();
    }

    public Servico salvar (ServicoDTO ServicoDTO) {
        return servicoDao.save(ServicoMapper.instance.ServicoDtoToServico(ServicoDTO));
    }

    public void deletar (ServicoDTO ServicoDTO) {
        buscarDescricao(ServicoDTO).stream().forEach(prod -> servicoDao.delete(prod));
    }

    public List<Servico> buscarDescricao (ServicoDTO ServicoDTO) {
        return servicoDao.findByDescricao(ServicoDTO.getDescricao());
    }

    public Servico atualizar (ServicoDTO ServicoDTO) {
        return null;
    }
}
