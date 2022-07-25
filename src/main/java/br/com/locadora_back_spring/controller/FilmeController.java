package br.com.locadora_back_spring.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.locadora_back_spring.model.Filme;
import br.com.locadora_back_spring.service.FilmeService;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping("/{id}")
    public ResponseEntity<Filme> filme(@PathVariable("id") Long id) {

        HttpStatus httpStatus = HttpStatus.OK;
        Filme filme = filmeService.buscarPorId(id);

        if (filme == null) {
            httpStatus = HttpStatus.NOT_FOUND;
        } else {
            httpStatus = HttpStatus.FOUND;
        }

        httpStatus = Objects.isNull(filme) ? HttpStatus.NOT_FOUND : HttpStatus.FOUND;

        return ResponseEntity.status(httpStatus).body(filme);
    }

    @PostMapping("/")
    public Filme filme(@RequestBody Filme filme) {
        return filmeService.salvar(filme);
    }

    @GetMapping("/list")
    public List<Filme> list() {
        return filmeService.buscarTodos();
    }

}
