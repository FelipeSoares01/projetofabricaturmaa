package br.univille.projfso2024a.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import br.univille.projfso2024a.entity.Agendamento;

public interface AgendamentoService {
    Agendamento save(Agendamento agendamento);
    List<Agendamento> getAllByDate(Date data);
    void delete(long id);
    Optional<Agendamento> getById(long id);

}