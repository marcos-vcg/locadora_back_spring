package br.com.locadora_back_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.locadora_back_spring.model.Locacao;
import br.com.locadora_back_spring.repository.LocacaoRepository;

@Service
public class LocacaoService {

    @Autowired
    private LocacaoRepository locacaoRepository;

    public List<Locacao> buscarTodos() {
        return locacaoRepository.findAll();
    }

    public Locacao buscarPorId(Long id) {
        return locacaoRepository.findById(id).orElse(null);
    }

    public Locacao salvar(Locacao locacao) {
        return locacaoRepository.save(locacao);
    }

    public void deletar(Long id) {
        locacaoRepository.deleteById(id);
    }
}
