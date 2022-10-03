package br.com.locadora_back_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.locadora_back_spring.model.Locacao;
import br.com.locadora_back_spring.service.LocacaoService;

@RestController
@RequestMapping("/locacao")
public class LocacaoController {

    @Autowired
    private LocacaoService locacaoService;

    @GetMapping("")
    public List<Locacao> listar() {
        return locacaoService.buscarTodos();
    }

    @GetMapping("/{id}")
    public Locacao buscar(@PathVariable("id") Long id) {
        return locacaoService.buscarPorId(id);
    }

    @PostMapping("")
    public Locacao inserir(@RequestBody Locacao locacao) {
        return locacaoService.salvar(locacao);
    }

    @PutMapping("")
    public Locacao editar(@RequestBody Locacao locacao) {
        return locacaoService.salvar(locacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        locacaoService.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
