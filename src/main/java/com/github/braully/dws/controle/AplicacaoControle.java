package com.github.braully.dws.controle;

import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author strike
 */
@Component
@Scope("application")
public class AplicacaoControle {

    String nomeAplicacao = "DW Senac 2019";
    Map configuracoes = new HashMap();

    public AplicacaoControle() {
    }

    public Map getConfiguracoes() {
        return configuracoes;
    }

    public String getNomeAplicacao() {
        return nomeAplicacao;
    }
}
