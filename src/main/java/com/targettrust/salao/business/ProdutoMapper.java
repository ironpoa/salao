package com.targettrust.salao.business;

import com.targettrust.salao.entity.Produto;
import com.targettrust.salao.model.ProdutoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    ProdutoMapper instance = Mappers.getMapper(ProdutoMapper.class);

    Produto produtoDtoToProduto (ProdutoDTO produtoDTO);
    ProdutoDTO produtoToProdutoDTO (Produto produto);
    List<ProdutoDTO> listProdutoToProdutoDTO(List<Produto> produtos);
    List<Produto> listProdutoDtoToProdutoDTO(List<ProdutoDTO> produtosDTO);
}
