/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.braully.dws.modelo;

/**
 *
 * @author Aluno
 */
public enum Estado {

    GO("Goiás"), DF("Distrito Federal"), AC("Acre"), AL("Alagoas"), AM("Amazonas"),
    AP("Amapá"), BA("Bahia"), CE("Ceará"), ES("Espírito Santo"), MA(" Maranhão"),
    MG("Minas Gerais"), MS("Mato Grosso do Sul"), MT("Mato Grosso"), PA("Pará"),
    PB("Paraíba"), PE("Pernambuco"), PI("Piauí"), PR("Paraná"), RJ("Rio de Janeiro"),
    RN("Rio Grande do Norte"), RO("Rondônia"), RR(" Roraima "), RS("Rio Grande do Sul"),
    SC("Santa Catarina"), SE("Sergipe"), SP("São Paulo"), TO("Tocantins");
   
    
    
    private String nome;

    private Estado(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return this.name();
    }

    public String getNome() {
        return nome;
    }
}
