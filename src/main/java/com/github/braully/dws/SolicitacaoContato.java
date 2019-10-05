/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.braully.dws;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author strike
 */
@Entity
public class SolicitacaoContato {

    @Id
    @GeneratedValue
    Integer id;

    @Basic
    String nome;
    @Basic
    String email;
    @Basic
    String duvida;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDuvida() {
        return duvida;
    }

    public void setDuvida(String duvida) {
        this.duvida = duvida;
    }

    @Override
    public String toString() {
        return "SolicitacaoContato{" + "nome=" + nome + ", email=" + email + ", duvida=" + duvida + '}';
    }

}
