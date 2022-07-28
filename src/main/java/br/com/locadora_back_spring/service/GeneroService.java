package br.com.locadora_back_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.locadora_back_spring.model.Genero;
import br.com.locadora_back_spring.repository.GeneroRepository;

@Service
public class GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    public Genero buscarPorId(Long id) {
        return generoRepository.findById(id).orElse(null);
    }

    public Genero salvar(Genero genero) {
        return generoRepository.save(genero);
    }

    public List<Genero> buscarTodos() {
        return generoRepository.findAll();
    }

    public void deletar(Long id) {
        generoRepository.deleteById(id);
    }
}
