package com.targettrust.salao.repository;

import com.targettrust.salao.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProdutoDao extends JpaRepository<Produto, Long> {

    List<Produto> findByDescricao(String descricao);
    List<Produto> findByDescricaoAndValorGreaterThan(String descricao, BigDecimal valor);
    @Query("SELECT p from Produto p where p.codigo = ?1")
    Produto findByCodigo(String codigo);
}
