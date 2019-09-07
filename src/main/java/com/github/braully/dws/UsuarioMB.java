package com.github.braully.dws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMB {

    @Autowired
    UsuarioDAO usuarioDAO;

    Usuario usuario = new Usuario();

    public Usuario getUsuario() {
        return usuario;
    }

    public void salvarUsuario() {
        usuarioDAO.save(usuario);
        usuario = new Usuario();
    }
}
