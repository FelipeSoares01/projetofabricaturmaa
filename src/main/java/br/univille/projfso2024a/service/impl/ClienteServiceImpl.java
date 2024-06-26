package br.univille.projfso2024a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfso2024a.entity.Cliente;
import br.univille.projfso2024a.repository.ClienteRepository;
import br.univille.projfso2024a.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
    
    @Autowired
    private ClienteRepository repository;
    
    @Override
    public void save(Cliente cliente) {
        repository.save(cliente);
    }

    @Override
    public Cliente getById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Cliente> getAll() {
        return repository.findAll();
    }

    @Override
    public Cliente delete(long id) {
        var cliente = getById(id);
        if (cliente != null) {
            repository.deleteById(id);
        }
        return cliente;
    }

    @Override
    public List<Cliente> findAll() {
        return repository.findAll();
    }
}
