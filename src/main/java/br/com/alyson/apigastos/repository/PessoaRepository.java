package br.com.alyson.apigastos.repository;

import br.com.alyson.apigastos.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}
