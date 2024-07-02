package br.univille.projfso2024a.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projfso2024a.entity.Cliente;
import br.univille.projfso2024a.entity.Servico;
import br.univille.projfso2024a.service.ClienteService;
import br.univille.projfso2024a.service.ServicoService;

@Controller
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoService service;
    

    @GetMapping
    public ModelAndView index(){
        var listaServico = service.getAll();
        return new ModelAndView("servicos/index","listaservico",listaServico);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var servico = new Servico();
        return new ModelAndView("servicos/form","servico",servico);
    }

    @PostMapping
    public ModelAndView save(Servico servico){
        service.save(servico);
        return new ModelAndView("redirect:/servicos");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var servico = service.getById(id);
        return new ModelAndView("servicos/form", "servico",servico);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        service.delete(id);
        return new ModelAndView("redirect:/servicos");
    }
}