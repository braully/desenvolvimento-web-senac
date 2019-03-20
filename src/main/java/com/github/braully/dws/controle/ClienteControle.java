package com.github.braully.dws.controle;

import com.github.braully.dws.modelo.Cliente;
import com.github.braully.dws.modelo.Estado;
import com.github.braully.dws.modelo.clienteDAO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteControle {

    Cliente cliente;
    @Autowired
    clienteDAO ClienteDAO;

    public Estado[] getListaEstados() {
        return Estado.values();
    }

    public ClienteControle() {
        novoCliente();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void novoCliente() {
        this.cliente = new Cliente();
    }

    public void salvarCliente() {
        String mensagem = " Cliente Salvo : " + cliente;
        System.out.println(mensagem);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mensagem));
        ClienteDAO.save(cliente);
        System.out.println("mensagem");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mensagem));
        novoCliente();
    }

    public Iterable<Cliente> getClientes() {
        return ClienteDAO.findAll();
    }
    
    public void exlcuirCliente(Cliente cliente){
        String mensagem = "Cliente excluído" + cliente ;
        ClienteDAO.delete(cliente);
        System.out.println(mensagem);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mensagem));
    }
}
