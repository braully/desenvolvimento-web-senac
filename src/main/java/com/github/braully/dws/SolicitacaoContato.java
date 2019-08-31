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

    @Override
    public String toString() {
        return "SolicitacaoContato{" + "nome=" + nome + ", email=" + email + ", duvida=" + duvida + '}';
    }

}
