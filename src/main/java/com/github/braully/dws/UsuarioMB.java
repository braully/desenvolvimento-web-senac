package com.github.braully.dws;

import java.util.ArrayList;
import java.util.List;
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

    @Autowired
    GrupoDAO grupoDAO;

    Usuario usuario = new Usuario();

    public Usuario getUsuario() {
        return usuario;
    }

    public void salvarUsuario() {
        //gruposSelecionados.forEach((k,v) -> {if(v) usuario.adicionaGrupo(k);});

//        for (Grupo g : gruposSelecionados.keySet()) {
//            Boolean selct = gruposSelecionados.get(g);
//            if (selct) {
//                usuario.adicionaGrupo(g);
//            }
//        }
        for (String id : gruposSelecionados) {
            Grupo g = grupoDAO.findById(Long.parseLong(id)).get();
            usuario.adicionaGrupo(g);
        }

        usuarioDAO.save(usuario);
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage("Usuário salvo com sucesso"));
        usuario = new Usuario();
    }

    List<Grupo> listaGrupos;

    public List<Grupo> getListaGrupos() {
        if (listaGrupos == null) {
            listaGrupos = new ArrayList<>();
            for (Grupo g : grupoDAO.findAll()) {
                listaGrupos.add(g);
            }
        }
        return listaGrupos;
    }

//    Map<Grupo, Boolean> gruposSelecionados = new HashMap<>();
//
//    public Map<Grupo, Boolean> getGruposSelecionados() {
//        return gruposSelecionados;
//    }
    String[] gruposSelecionados;

    public String[] getGruposSelecionados() {
        return gruposSelecionados;
    }

    public void setGruposSelecionados(String[] gruposSelecionados) {
        this.gruposSelecionados = gruposSelecionados;
    }
}
