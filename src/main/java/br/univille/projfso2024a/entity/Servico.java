package br.univille.projfso2024a.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 1000, nullable = false)
    @NotBlank(message = "Campo nome não pode ser em branco")
    private String corte;
    @Column(length = 1000)
    private String barba;
    private String cortebarba;
    private String pintura;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getCorte() {
        return corte;
    }
    public void setCorte(String corte) {
        this.corte = corte;
    }
    public String getBarba() {
        return barba;
    }
    public void setBarba(String barba) {
        this.barba = barba;
    }
    public String getCortebarba() {
        return cortebarba;
    }
    public void setCortebarba(String cortebarba) {
        this.cortebarba = cortebarba;
    }
    public String getPintura() {
        return pintura;
    }
    public void setPintura(String pintura) {
        this.pintura = pintura;
    }
    
    
   
    
}
