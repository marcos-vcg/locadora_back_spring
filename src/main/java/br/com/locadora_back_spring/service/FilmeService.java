package br.com.locadora_back_spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import br.com.locadora_back_spring.model.Filme;
import br.com.locadora_back_spring.repository.FilmeRepository;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    public List<Filme> buscarTodos() {
        return filmeRepository.findAll(Sort.by(Sort.Order.asc("nome")));
    }

    public List<Filme> buscarTodosOrdenadosPorNomeId() {
        return filmeRepository.findByOrderByNomeAscIdAsc();
    }

    public Filme buscarPorId(Long id) {
        return filmeRepository.findById(id).orElse(null);
    }

    public Filme salvar(Filme filme) {
        return filmeRepository.save(filme);
    }

    public void deletar(Long id) {
        filmeRepository.deleteById(id);
    }
}
