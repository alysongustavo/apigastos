package br.com.alyson.apigastos.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "gasto")
public class Gasto {

    @Id
    @SequenceGenerator(name="seq_gasto_id",
            sequenceName="seq_gasto_id",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="seq_gasto_id")
    private Integer id;

    @ManyToOne
    @JsonBackReference
    private Pessoa pessoa;
    private String description;

    @Column(name = "dthour")
    private LocalDateTime dtHour;
    private BigDecimal value;
    private String tags;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDtHour() {
        return dtHour;
    }

    public void setDtHour(LocalDateTime dtHour) {
        this.dtHour = dtHour;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
