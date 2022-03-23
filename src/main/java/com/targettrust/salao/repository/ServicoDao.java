package com.targettrust.salao.repository;

import com.targettrust.salao.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicoDao extends JpaRepository<Servico, Long> {

    List<Servico> findByDescricao(String descricao);
    @Query("SELECT s from Servico s where s.codigo = ?1")
    Servico findByCodigo(String codigo);
}
