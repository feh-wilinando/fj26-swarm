package br.com.caelum.uberdist.modelo;

import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by nando on 13/02/17.
 */
@Entity
public class NotaFiscal {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CNPJ
    private String cnpj;

    @Temporal(TemporalType.DATE)
    private Calendar data = Calendar.getInstance();

    @Size(min = 1)
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "notaFiscal")
    private List<Item> itens = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}
