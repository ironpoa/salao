package com.targettrust.salao.repository;

import com.targettrust.salao.entity.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProfissionalDao extends JpaRepository<Profissional, Long> {

    List<Profissional> findByFuncao(String funcao);
    List<Profissional> findByFuncaoAndSalarioGreaterThan(String funcao, BigDecimal salario);
}
