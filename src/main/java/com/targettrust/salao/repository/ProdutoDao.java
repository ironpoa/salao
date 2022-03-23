package com.targettrust.salao.repository;

import com.targettrust.salao.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoDao extends JpaRepository<Produto, Long> {

    List<Produto> findByDescricao(String descricao);
}
