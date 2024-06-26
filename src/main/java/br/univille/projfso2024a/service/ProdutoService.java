package br.univille.projfso2024a.service;

import java.util.List;

import br.univille.projfso2024a.entity.Produto;


public interface ProdutoService {
    void save(Produto produto);
    Produto getById(long id);
    List<Produto> getAll();
    void delete(long id);
    static void deleteProduto(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProduto'");
    }
}