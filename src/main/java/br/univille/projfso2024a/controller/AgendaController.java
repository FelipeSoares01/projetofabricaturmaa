package br.univille.projfso2024a.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projfso2024a.entity.Agendamento;
import br.univille.projfso2024a.service.AgendamentoService;
import br.univille.projfso2024a.service.ClienteService;
import br.univille.projfso2024a.service.ServicoService;
import br.univille.projfso2024a.viewmodel.Agenda;
import br.univille.projfso2024a.viewmodel.Dia;
import br.univille.projfso2024a.viewmodel.Semana;

@Controller
@RequestMapping("/agenda")
public class AgendaController {

    @Autowired
    private AgendamentoService service;
    
    @Autowired
    private AgendamentoService agendamentoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ServicoService servicoService;

    @GetMapping({"","/","/{mes}/{ano}"})
    public ModelAndView index(@PathVariable(name="mes", required=false) Integer mes,
                              @PathVariable(name="ano", required=false) Integer ano) {
        HashMap<String, Object> dados = new HashMap<>();
        
        var agenda = new Agenda();
        
        if (mes == null || ano == null) {
            var today = LocalDate.now();
            mes = today.getMonthValue();
            ano = today.getYear();
        }
        
        if (mes > 12) {
            mes = 1;
            ano++;
        }
        if (mes < 1) {
            mes = 12;
            ano--;
        }
        
        agenda.setMes(mes);
        agenda.setAno(ano);

        var data = LocalDate.of(agenda.getAno(), agenda.getMes(), 1);
        
        for (int semanacalend = 1; semanacalend <= 6; semanacalend++) {
            var semana = new Semana();
            agenda.getListaSemanas().add(semana);
            for (int diacalend = 1; diacalend <= 7; diacalend++) {
                var dia = new Dia();
                semana.getListaDias().add(dia);
                LocalDate dayValue = null;
                var dayOfWeek = data.getDayOfWeek().getValue();
                if (dayOfWeek == diacalend) {
                    dayValue = data;
                    var agendamentos = service.getAllByDate(java.sql.Date.valueOf(dayValue));
                    if (!agendamentos.isEmpty())
                        dia.getListaAgendamentos().addAll(agendamentos);
                    data = data.plusDays(1);
                    dia.setDia(dayValue.getDayOfMonth());
                    dia.setMes(dayValue.getMonthValue() - 1);
                    dia.setAno(dayValue.getYear());
                }
            }
        }
        
        dados.put("agenda", agenda);
        return new ModelAndView("agenda/index", dados);
    }

    @GetMapping("/novo")
    public ModelAndView novoAgendamento() {
        var agendamento = new Agendamento();
        var clientes = clienteService.getAll();
        var servicos = servicoService.getAll();
        ModelAndView mv = new ModelAndView("agenda/form");
        mv.addObject("agendamento", agendamento);
        mv.addObject("clientes", clientes);
        mv.addObject("servicos", servicos);
        return mv;
    }

    @PostMapping("/salvar")
    public ModelAndView salvarAgendamento(@ModelAttribute("agendamento") Agendamento agendamento, BindingResult result) {
            var clientes = clienteService.getAll();
            var servicos = servicoService.getAll();
            ModelAndView mv = new ModelAndView("agenda/form");
            mv.addObject("clientes", clientes);
            mv.addObject("servicos", servicos);
            agendamentoService.save(agendamento);
        return new ModelAndView("redirect:/agenda");
    }


}
