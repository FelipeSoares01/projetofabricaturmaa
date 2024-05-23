package br.univille.projfso2024a.service;

import java.util.List;

import br.univille.projfso2024a.entity.Servico;

public interface ServicoService {
    void save(Servico servico);
    Servico getById(long id);
    List<Servico> getAll();
    Servico delete(long id);
}