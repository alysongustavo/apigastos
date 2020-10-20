package br.com.alyson.apigastos.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @SequenceGenerator(name="seq_pessoa_id",
            sequenceName="seq_pessoa_id",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="seq_pessoa_id")
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "pessoa")
    @JsonManagedReference
    private List<Gasto> gastos = new ArrayList<>();

    private String email;
    private String cpf;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Gasto> getGastos() {
        return gastos;
    }

    public void setGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
