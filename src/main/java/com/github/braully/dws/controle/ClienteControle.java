package com.github.braully.dws.controle;

/**
 *
 * @author Rafael para aula de Web Braully
 */
import com.github.braully.dws.modelo.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteControle {
    Cliente cliente;

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
    }
}
