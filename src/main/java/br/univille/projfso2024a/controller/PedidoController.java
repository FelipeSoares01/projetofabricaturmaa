package br.univille.projfso2024a.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projfso2024a.entity.ItemPedido;
import br.univille.projfso2024a.entity.Pedido;
import br.univille.projfso2024a.service.PedidoService;
import br.univille.projfso2024a.service.ProdutoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ModelAndView index(){
        var listaPedidos = pedidoService.getAll();
        return new ModelAndView("pedido/index","listaPedidos",listaPedidos);
    }
    @GetMapping("/novo")
    public ModelAndView novo(){
        var pedido = new Pedido();
        var novoItem = new ItemPedido();
        var listaProdutos = produtoService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("pedido",pedido);
        dados.put("novoItem",novoItem);
        dados.put("listaProdutos",listaProdutos);
         
        return new ModelAndView("pedido/form", dados);
    }

    @PostMapping(params = "incitem")
    public ModelAndView novo(Pedido pedido,
                            ItemPedido novoItem){
        pedido.getColItens().add(novoItem);
        var listaProdutos = produtoService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("pedido",pedido);
        dados.put("novoItem",novoItem);
        dados.put("listaProdutos",listaProdutos);
         
        return new ModelAndView("pedido/form", dados);
    }

    @PostMapping(params = "save")
    public ModelAndView novo(@Valid Pedido pedido,
                            BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            var listaProdutos = produtoService.getAll();
            var novoItem = new ItemPedido();
            HashMap<String,Object> dados = new HashMap<>();
            dados.put("pedido",pedido);
            dados.put("novoItem",novoItem);
            dados.put("listaProdutos",listaProdutos);
            return new ModelAndView("pedido/form", dados);
        }
        pedidoService.save(pedido);
        return new ModelAndView("redirect:/pedidos");


    }


    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePedido(@PathVariable Long id) {
        try {
            pedidoService.deletePedido(id); // Implemente o serviço para excluir o pedido pelo ID
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}