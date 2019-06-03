package com.github.braully.dws.controle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.pentaho.reporting.engine.classic.core.ClassicEngineBoot;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.pentaho.reporting.engine.classic.core.DataFactory;
import org.pentaho.reporting.engine.classic.core.MasterReport;
import org.pentaho.reporting.engine.classic.core.ReportProcessingException;
import org.pentaho.reporting.engine.classic.core.layout.output.AbstractReportProcessor;
import org.pentaho.reporting.engine.classic.core.modules.misc.datafactory.sql.SQLReportDataFactory;
import org.pentaho.reporting.engine.classic.core.modules.output.pageable.base.PageableReportProcessor;
import org.pentaho.reporting.engine.classic.core.modules.output.pageable.pdf.PdfOutputProcessor;
import org.pentaho.reporting.libraries.resourceloader.Resource;
import org.pentaho.reporting.libraries.resourceloader.ResourceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Braully Rocha da Silva
 */
@Controller
@Component
public class RelatorioControle {

    public RelatorioControle() {
        ClassicEngineBoot.getInstance().start();
    }

    @Autowired
    DataSource dataSource;

    @RequestMapping("/relatorio/exemplo1")
    public ResponseEntity<org.springframework.core.io.Resource> exemplo1() throws Exception {
        //Parametros
        Map parameters = new HashMap<String, Object>();
        parameters.put("Report Title", "Titulo de Exemplo via Parametro");
        parameters.put("Col Headers BG Color", "yellow");

        //Relatório do Pentaho
        ClassLoader classloader = this.getClass().getClassLoader();
        URL reportDefinitionURL = classloader.getResource("relatorio/exemplo.prpt");
        ResourceManager resourceManager = new ResourceManager();
        Resource directly = resourceManager.createDirectly(reportDefinitionURL, MasterReport.class);
        MasterReport relatorioExemplo = (MasterReport) directly.getResource();
        relatorioExemplo.setQuery("ReportQuery");

        //Conexão para o relatório do pentaho
        SQLReportDataFactory dataFactory = new SQLReportDataFactory(dataSource.getConnection());
        dataFactory.setQuery("ReportQuery",
                "select NOME, CIDADE, ESTADO, CPF, ENDERECO from CLIENTE order by UPPER(NOME)");

        //Gerar o relatório
        File arquivoSaidaTemporario = File.createTempFile("relatorioExemplo", ".pdf");
        FileOutputStream outputStream = new FileOutputStream(arquivoSaidaTemporario);
        gerarRelatorioPentaho(relatorioExemplo, dataFactory, parameters, outputStream);

        //Enviar o arquivo para o navegador do usuario
        InputStreamResource resource = new InputStreamResource(new FileInputStream(arquivoSaidaTemporario));
        return ResponseEntity.ok()
                .contentLength(arquivoSaidaTemporario.length())
                .contentType(MediaType.parseMediaType("application/pdf"))
                .body(resource);
    }

    @RequestMapping("/relatorio/exemplo2")
    public void exemplo2() {

    }

    @RequestMapping("/relatorio/exemplo3")
    public void exemplo3() {

    }

    @RequestMapping("/relatorio/exemplo4")
    public void exemplo4() {

    }

    public void gerarRelatorioPentaho(MasterReport report,
            DataFactory dataFactory,
            Map<String, Object> reportParameters,
            OutputStream outputStream) throws ReportProcessingException {
        // Set the data factory for the report
        if (dataFactory != null) {
            report.setDataFactory(dataFactory);
        }

        // Add any parameters to the report
        if (null != reportParameters) {
            for (String key : reportParameters.keySet()) {
                report.getParameterValues().put(key, reportParameters.get(key));
            }
        }

        // Prepare to generate the report
        AbstractReportProcessor reportProcessor = null;
        try {
            // Greate the report processor for the specified output type
            final PdfOutputProcessor outputProcessor
                    = new PdfOutputProcessor(report.getConfiguration(), outputStream, report.getResourceManager());
            reportProcessor = new PageableReportProcessor(report, outputProcessor);
            // Generate the report
            reportProcessor.processReport();
        } finally {
//            if (reportProcessor != null) {
//                reportProcessor.close();
//            }
        }
    }
}
