package com.github.braully.dws;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ContatoServico {

    List<SolicitacaoContato> solicitacoes = new ArrayList<>();

    @RequestMapping("/processar-form-contato")
    public String recebeDadosParaContato(@RequestParam Map<String, String> todosParametros) {
        System.out.println("entrei no metodo: /processar-form-contato");
        //System.out.println(todosParametros);

        SolicitacaoContato novaSolicitacao = new SolicitacaoContato();
        novaSolicitacao.nome = todosParametros.get("nome");
        novaSolicitacao.email = todosParametros.get("email");
        novaSolicitacao.duvida = todosParametros.get("duvida");

        System.out.println("Solicitações anteriores: " + solicitacoes);
        System.out.println("Nova solicitação recebida: " + novaSolicitacao);

        solicitacoes.add(novaSolicitacao);

        return "redirect:/principal.html";
    }

    @RequestMapping("/todas-solicitacoes")
    @ResponseBody
    public String gerarTelaTodasSolContatos() {
        String html = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "    <head>\n"
                + "        <title>TODO supply a title</title>\n"
                + "        <meta charset=\"UTF-8\">\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "    </head>\n"
                + "    <body>\n"
                + "        <table>\n"
                + "            <tr>\n"
                + "                <td><b>Nome</b></td>\n"
                + "                <td>Email</td>\n"
                + "                <td>Duvida</td>\n"
                + "            </tr>";

        for (SolicitacaoContato sol : solicitacoes) {
            String linhaTabela = "<tr>";

            //nome
            linhaTabela += "<td>";
            linhaTabela += sol.nome;
            linhaTabela += "</td>";
            //email
            //duvida
            linhaTabela += "</tr>";
                        
            html += linhaTabela;
        }

        html += "        </table>\n"
                + "    </body>\n"
                + "</html>";
        return html;
    }
}
