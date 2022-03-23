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
    ServicoDao servicoDao;

    public Optional<Servico> buscarServico (Long id) {
        return servicoDao.findById(id);
    }

    public List<Servico> buscarServicos () {
        return servicoDao.findAll();
    }

    public Servico salvar (ServicoDTO servicoDTO) {
        return servicoDao.save(ServicoMapper.instance.servicoDtoToServico(servicoDTO));
    }

    public void deletar (Long id) {
        servicoDao.deleteById(id);
    }

    public List<Servico> buscarDescricao (ServicoDTO servicoDTO) {
        return servicoDao.findByDescricao(servicoDTO.getDescricao());

    }

    public ServicoDTO atualizar (ServicoDTO servicoDTO, Long id) throws Exception {
        Servico serv = new Servico();

        Optional <Servico> servicoOpt = servicoDao.findById(id);

        if (servicoOpt.isPresent() ) {
            serv = servicoOpt.get();
            serv.setDescricao(servicoDTO.getDescricao());
            servicoDao.save(serv);
        } else {
            log.info("Not found");
            throw new Exception("Not Found");

        }
        return ServicoMapper.instance.servicoToServicoDTO(serv);
    }

    public ServicoDTO buscarPorCodigo (String codigo) {
        return ServicoMapper.instance.servicoToServicoDTO(servicoDao.findByCodigo(codigo));
    }
}
