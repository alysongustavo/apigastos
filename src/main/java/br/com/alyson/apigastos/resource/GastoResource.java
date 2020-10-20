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
@RequestMapping("/gastos")
public class GastoResource {

    @Autowired
    private GastoService gastoService;

    @GetMapping
    public List<Gasto> listar(){
        return gastoService.listar();
    }

    @GetMapping("/{id}")
    public Gasto buscarPorId(@PathVariable Integer id){
        return gastoService.findById(id);
    }
}
