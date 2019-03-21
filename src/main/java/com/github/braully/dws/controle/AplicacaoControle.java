package com.github.braully.dws.controle;

import java.util.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("application")
public class AplicacaoControle {

    String nomeAplicacao = "ADS Senac 2019";
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
