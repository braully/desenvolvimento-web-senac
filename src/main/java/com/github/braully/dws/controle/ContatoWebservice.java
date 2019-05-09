package com.github.braully.dws.controle;

import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author braully
 */
@RestController
public class ContatoWebservice {

    @RequestMapping("/contato")
    public void receberPedidoContato(@RequestParam Map<String, String> todosDados) {
        System.out.println("Paramentos recebidos: " + todosDados);
    }

    @RequestMapping("/todos-html")
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

        for (int i = 0; i < 3; i++) {
            html += "<tr>"
                    + "<td>" + Math.random() + "</td>"
                    + "<td>" + Math.random() + "</td>"
                    + "<td>" + Math.random() + "</td>"
                    + "<td>" + Math.random() + "</td>"
                    + "</tr>";
        }

        html += "        </table>"
                + "    </body>"
                + "</html>";
        return html;
    }

}
