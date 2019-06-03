package com.github.braully.dws.controle;

import com.github.braully.dws.modelo.Cliente;
import com.github.braully.dws.modelo.ClienteDAO;
import com.github.braully.dws.modelo.Estado;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("view")
public class ClienteControle {

    Cliente cliente;

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

    @Autowired
    ClienteDAO clienteDAO;

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void salvarCliente() {
        String mensagem = "Cliente Salvo: " + cliente;
        System.out.println(mensagem);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mensagem));
        clienteDAO.save(cliente);
        novoCliente();
    }

    public Iterable<Cliente> getClientes() {
        return clienteDAO.findAll();
    }

    public void excluirCliente(Cliente cliente) {
        String mensagem = "Cliente excluido :" + cliente;
        clienteDAO.delete(cliente);
        System.out.println(mensagem);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(mensagem));
    }
}
