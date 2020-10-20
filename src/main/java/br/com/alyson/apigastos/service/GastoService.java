package br.com.alyson.apigastos.service;

import br.com.alyson.apigastos.model.Gasto;
import br.com.alyson.apigastos.model.Pessoa;
import br.com.alyson.apigastos.repository.GastoRepository;
import br.com.alyson.apigastos.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GastoService {


    @Autowired
    private GastoRepository gastoRepository;

    public List<Gasto> listar(){
        return gastoRepository.findAll();
    }

    public List<Gasto> listarGastosPessoa(Pessoa pessoa){
        return gastoRepository.findAllByPessoa(pessoa);
    }

    public Gasto cadastrar(Gasto gasto){
        return gastoRepository.save(gasto);
    }

    public Gasto findById(Integer id){
        return gastoRepository.findById(id).get();
    }
}
