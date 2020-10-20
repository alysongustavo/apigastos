package br.com.alyson.apigastos.resource;

import br.com.alyson.apigastos.model.Gasto;
import br.com.alyson.apigastos.model.Pessoa;
import br.com.alyson.apigastos.service.GastoService;
import br.com.alyson.apigastos.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private GastoService gastoService;

    @GetMapping
    public List<Pessoa> listar(){
        return pessoaService.listar();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Pessoa> cadastrar(@RequestBody Pessoa pessoa, HttpServletResponse response){

        Pessoa pessoaSalva = pessoaService.cadastrar(pessoa);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(pessoaSalva.getId()).toUri();
        response.setHeader("Location", uri.toASCIIString());

        return ResponseEntity.created(uri).body(pessoaSalva);

    }

    @GetMapping("/{id}")
    public Pessoa buscarPorId(@PathVariable Integer id){
        return pessoaService.findById(id);
    }

    @GetMapping("/{id}/gastos")
    public List<Gasto> listarGastos(@PathVariable Integer id){
        Pessoa pessoaEncontrada = pessoaService.findById(id);
        return gastoService.listarGastosPessoa(pessoaEncontrada);
    }

    @PostMapping("/{id}/gastos")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Gasto> cadastrarGastos(@RequestBody Gasto gasto, HttpServletResponse response,
                                                 @PathVariable Integer id){

        Pessoa pessoaEncontrada = pessoaService.findById(id);
        gasto.setPessoa(pessoaEncontrada);
        Gasto gastoSalvo = gastoService.cadastrar(gasto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(gastoSalvo.getId()).toUri();
        response.setHeader("Location", uri.toASCIIString());

        return ResponseEntity.created(uri).body(gastoSalvo);
    }


}
