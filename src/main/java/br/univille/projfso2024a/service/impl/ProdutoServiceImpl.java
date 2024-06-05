package br.univille.projfso2024a.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.univille.projfso2024a.entity.Produto;
import br.univille.projfso2024a.repository.ProdutoRepository;
import br.univille.projfso2024a.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    
    @Autowired
    private ProdutoRepository repository;

    @Override
    public void save(Produto produto) {
        repository.save(produto);
    }

    @Override
    public Produto getById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Produto> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
