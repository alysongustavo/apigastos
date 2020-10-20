package br.com.alyson.apigastos.service;

import br.com.alyson.apigastos.model.Pessoa;
import br.com.alyson.apigastos.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> listar(){
        return pessoaRepository.findAll();
    }

    public Pessoa cadastrar(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    public Pessoa findById(Integer id){
        return pessoaRepository.findById(id).get();
    }
}
