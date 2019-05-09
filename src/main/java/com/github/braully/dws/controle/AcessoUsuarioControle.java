package com.github.braully.dws.controle;

import com.github.braully.dws.modelo.Usuario;
import com.github.braully.dws.modelo.UsuarioDAO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Component
@Scope("session")
public class AcessoUsuarioControle {

    String nomeUsuario;
    String senha;
    Boolean logado = false;

    @RequestMapping(method = RequestMethod.GET, value = "/sair")
    public String sair(HttpSession session) {
        session.invalidate();
        return "redirect:/login.xhtml ";
    }

    public String entrar() {
        if ("123456".equals(senha)) {
            logado = true;
            return "home.xhtml";
        } else {
            FacesMessage msgJsf = new FacesMessage("Senha incorreta!");
            msgJsf.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, msgJsf);
        }
        return null;
    }

    public Boolean getLogado() {
        return logado;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public AcessoUsuarioControle() {
        novoUsuario();
    }

    @Autowired
    UsuarioDAO usuarioDAO;

    Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void salvarUsuario() {
        String mensagem = "Usuario Salvo: " + usuario;
        System.out.println(mensagem);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mensagem));
        usuarioDAO.save(usuario);
        novoUsuario();
    }

    public Iterable<Usuario> getUsuarios() {
        return usuarioDAO.findAll();
    }

    public void novoUsuario() {
        this.usuario = new Usuario();
    }
}
