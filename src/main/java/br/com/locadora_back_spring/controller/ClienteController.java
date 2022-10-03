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

import br.com.locadora_back_spring.model.Cliente;
import br.com.locadora_back_spring.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("")
    public List<Cliente> listar() {
        return clienteService.buscarTodos();
    }

    @GetMapping("/{id}")
    public Cliente buscar(@PathVariable("id") Long id) {
        return clienteService.buscarPorId(id);
    }

    @PostMapping("")
    public Cliente inserir(@RequestBody Cliente cliente) {
        return clienteService.salvar(cliente);
    }

    @PutMapping("")
    public Cliente editar(@RequestBody Cliente cliente) {
        return clienteService.salvar(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        clienteService.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
