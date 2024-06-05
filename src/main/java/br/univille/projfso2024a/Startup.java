package br.univille.projfso2024a;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.univille.projfso2024a.entity.Cliente;
import br.univille.projfso2024a.service.ClienteService;

@Component
public class Startup {

    @Autowired
    private ClienteService service;

    @EventListener
    public void oneApplicationEvent(ContextRefreshedEvent event){
    
        var cliente1 = new Cliente();
        cliente1.setNome("Zezinho");
        cliente1.setEndereco("Rua lalalaa 100");
        cliente1.setDataNascimento(new Date(2024,04,17));
        cliente1.setEmail("eita@hotmail.com");
        //cliente1.setCidade("Joinville");
        cliente1.setSenha("admin");
        service.save(cliente1);
    }
    
}
