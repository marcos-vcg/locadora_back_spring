package br.com.locadora_back_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.locadora_back_spring.model.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {

}
