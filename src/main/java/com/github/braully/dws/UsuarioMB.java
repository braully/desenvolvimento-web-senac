package com.github.braully.dws;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("view")
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
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage("Usuário salvo com sucesso"));
        usuario = new Usuario();
    }
}
