package br.com.locadora_back_spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.locadora_back_spring.model.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {

    List<Filme> findByOrderByNomeAscIdAsc();
}
