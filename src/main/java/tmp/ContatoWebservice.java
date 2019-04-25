/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author strike
 */
@RestController
public class ContatoWebservice {

    @RequestMapping("/contato")
    public void receberPedidoContato(@RequestParam Map<String, String> todosDados) {
        System.out.println("Paramentos recebidos: " + todosDados);
    }

    @RequestMapping("/contato/todos-ws")
    public List todosPedidosContatos() {
        List ret = null;
        /* Recupera contatos do banco */
        ret = new ArrayList();
        ret.add(Map.of("id", "1", "email", "braully@gmal.com", "mensagem", "Sistema muito lento"));
        return ret;
    }

    @RequestMapping("/contato/todos-html")
    public String todosPedidosContatoHtml() {
        String html = "<html>"
                + "    <body>"
                + "        <table>"
                + "            <tr>"
                + "                <th>id</th>"
                + "                <th>nome</th>"
                + "                <th>email</th>"
                + "                <th>mensagem</th>"
                + "            </tr>";

//        for (Cada solicitacaoContato          ) {
//            html += "<tr>"
//                    + "<td>" + id + "</td>"
//                    + "<td>" + nome + "</td>"
//                    + "<td>" + email + "</td>"
//                    + "<td>" + mensagem + "</td>"
//                    + "</tr>";
//        }

        html += "        </table>"
                + "    </body>"
                + "</html>";
        return html;
    }

}
