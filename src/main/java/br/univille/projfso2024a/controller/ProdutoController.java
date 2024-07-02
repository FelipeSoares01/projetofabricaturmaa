package br.univille.projfso2024a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projfso2024a.entity.Produto;
import br.univille.projfso2024a.service.ProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;
    

    @GetMapping({"", "/"})
    public ModelAndView index() {
        var listaProduto = service.getAll();
        return new ModelAndView("produtos/index", "listaproduto", listaProduto);
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        var produto = new Produto();
        return new ModelAndView("produtos/form", "produto", produto);
    }

    @PostMapping
    public ModelAndView save(Produto produto) {
        service.save(produto);
        return new ModelAndView("redirect:/produtos");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id) {
        var produto = service.getById(id);
        return new ModelAndView("produtos/form", "produto", produto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduto(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao excluir o produto.");
        }
    }
}
