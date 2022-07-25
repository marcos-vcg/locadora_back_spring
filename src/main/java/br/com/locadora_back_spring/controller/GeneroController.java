package br.com.locadora_back_spring.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.locadora_back_spring.model.Genero;
import br.com.locadora_back_spring.service.GeneroService;

@RestController
@RequestMapping("/genero")
@CrossOrigin
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    // @GetMapping("/{id}")
    // public ResponseEntity<Genero> genero(@PathVariable("id") Long id) {

    // System.out.println("Controller Genero - Buca por ID");

    // HttpStatus httpStatus = HttpStatus.OK;
    // Genero genero = generoService.buscarPorId(id);

    // if (genero == null) {
    // httpStatus = HttpStatus.NOT_FOUND;
    // } else {
    // httpStatus = HttpStatus.FOUND;
    // }

    // httpStatus = Objects.isNull(genero) ? HttpStatus.NOT_FOUND :
    // HttpStatus.FOUND;

    // System.out.println("Buscou o Genero no BD");
    // System.out.println(genero.getNome());

    // return new ResponseEntity<Genero>(genero, httpStatus);
    // }

    @GetMapping("/{id}")
    public Genero genero(@PathVariable("id") Long id) {

        System.out.println("Controller Genero - Buca por ID");

        Genero genero = generoService.buscarPorId(id);

        System.out.println("Buscou o Genero no BD");
        System.out.println(genero.getNome());

        return genero;
    }

    @PostMapping("")
    public Genero salvar(@RequestBody Genero genero) {
        return generoService.salvar(genero);
    }

    @PutMapping("")
    public Genero editar(@RequestBody Genero genero) {
        System.out.println("Editou");
        return generoService.salvar(genero);
    }

    @GetMapping("")
    public List<Genero> listar() {
        System.out.println("Controller Genero - Listar");
        return generoService.buscarTodos();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        generoService.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
