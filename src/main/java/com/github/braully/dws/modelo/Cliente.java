package com.github.braully.dws.modelo;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Rafael para aula de Web Braully
 */
public class Cliente {

    @Id @GeneratedValue
    Integer id;
    @Basic
    String nome;
    @Basic
    String cpf;
    @Basic
    Date dataNascimento;
    @Basic
    String endereco;
    @Basic
    String cidade;
    @Basic
    Estado estado;
    @Basic
    Boolean ativo;

    public Cliente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", endereco=" + endereco + ", cidade=" + cidade + ", estado=" + estado + ", ativo=" + ativo + '}';
    }

}
