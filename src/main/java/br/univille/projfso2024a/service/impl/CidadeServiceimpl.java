package br.univille.projfso2024a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfso2024a.entity.Cidade;
import br.univille.projfso2024a.repository.CidadeRepository;
import br.univille.projfso2024a.service.CidadeService;

@Service
public class CidadeServiceimpl implements CidadeService{

    @Autowired
    private CidadeRepository repository;

    @Override
    public List<Cidade> getAll() {
        return repository.findAll();
    }

    public CidadeRepository getRepository() {
        return repository;
    }

    public void setRepository(CidadeRepository repository) {
        this.repository = repository;
    }
    
}