package com.example.jpah2demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Telefone implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String ddd;

    @Column
    private String numero;

    @ManyToOne
    private Cliente cliente;

    public Telefone() {
    }

    public Telefone(String ddd, String numero, Cliente cliente) {
        this.setDdd(ddd);
        this.setNumero(numero);
        this.setCliente(cliente);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefone telefone = (Telefone) o;
        return Objects.equals(id, telefone.id) && Objects.equals(ddd, telefone.ddd) && Objects.equals(numero, telefone.numero) && Objects.equals(cliente, telefone.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ddd, numero, cliente);
    }
}
