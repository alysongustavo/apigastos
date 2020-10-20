package br.com.alyson.apigastos.repository;

import br.com.alyson.apigastos.model.Gasto;
import br.com.alyson.apigastos.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GastoRepository extends JpaRepository<Gasto, Integer> {

    List<Gasto> findAllByPessoa(Pessoa pessoa);
}
