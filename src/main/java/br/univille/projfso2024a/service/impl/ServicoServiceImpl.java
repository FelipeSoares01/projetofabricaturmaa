package br.univille.projfso2024a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfso2024a.entity.Servico;
import br.univille.projfso2024a.repository.ServicoRepository;
import br.univille.projfso2024a.service.ServicoService;

@Service
public class ServicoServiceImpl implements ServicoService {
    
    @Autowired
    private ServicoRepository repository;
    
    @Override
    public void save(Servico servico) {
        repository.save(servico);
    }

    @Override
    public Servico getById(long id) {
        return repository.getById(id);
    }

    @Override
    public List<Servico> getAll() {
        return repository.findAll();
    }
    
    @Override
    public Servico delete(long id) {
        var servico = getById(id);
        repository.deleteById(id);
        return servico;
    }
}
