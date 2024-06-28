package br.univille.projfso2024a.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.MERGE})
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.MERGE})
    private Servico servico;

    public Servico getServico() {
        return servico;
    }
    public void setServico(Servico servico) {
        this.servico = servico;
    }
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm")
    private Date hora;
    
    public Date getHora() {
        return hora;
    }
    public void setHora(Date hora) {
        this.hora = hora;
    }
    private String descricao;

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    
}