package com.targettrust.salao.repository;

import com.targettrust.salao.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicoDao extends JpaRepository<Servico, Long> {

    List<Servico> findByDescricao(String descricao);

}
