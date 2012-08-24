import com.thoughtworks.selenium.SeleneseTestCase;

import java.util.List;


public class Crawler extends SeleneseTestCase {
    private List<String> linksFiles;

    public void setUp() throws Exception {
        setUp("http://www.anmat.gov.ar/", "*chrome");
    }
    public void testCrawler() throws Exception {
        selenium.open("/aplicaciones_net/applications/consultas/lomac/");

            selenium.type("id=txt_laboratorio", "Bioprofarma");
            selenium.click("id=btn_consultar");
            waitForElementPresent("Se ha utilizado el siguiente filtro para la búsqueda:");
            Integer cantPaginas = buscarCantidadPaginasLabo();
            if(cantPaginas!=0){
                Thread.sleep(5000);
                int paginaActual=1;
                while(paginaActual < cantPaginas+1){
                    procesarPagina();
                    selenium.click("id=pagina_siguiente");
                    Thread.sleep(6000);
                    System.out.println("La pagina actual es: "+paginaActual);
                    paginaActual++;
                }
            }
            selenium.click("id=div_volver");
            selenium.waitForPageToLoad("30000");
    }

    private void procesarPagina() {

        for (int productoActual =1; productoActual<6; productoActual++){
            String element = "//*[@id=\"td_registros\"]/div[" +productoActual + "]";
            String producto = selenium.getText(element);
            List<String> pdfURLs = getLinksFiles();
            //procesarProducto(producto, pdfURLs);
            ParserProducto.parse(producto);
        }
    }

    private void procesarProducto(String producto, List<String> pdfURLs) {

        for (String pdfURL : pdfURLs) {
            //saveFile();
        }

        ParserProducto.parse(producto);
    }

    private void waitForElementPresent(String textContent) {
        while(!selenium.getHtmlSource().contains(textContent)){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void waitForElementAbsent(String textContent) {
        while(selenium.getHtmlSource().contains(textContent)){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Integer buscarCantidadPaginasLabo() {

        Integer ret = 0;
        if(selenium.isTextPresent("Página")){
            String paginaXdeY = selenium.getText("css=div.div_pagina_actual");
            ret = new Integer(paginaXdeY.substring(paginaXdeY.indexOf("de") + 3, paginaXdeY.length()));
        }

        return ret;
    }

    public List<String> getLinksFiles() {
        return linksFiles;
    }
}

//com.thoughtworks.selenium.SeleniumException: ERROR: There was an unexpected Alert! [ERROR DE CARGA EN SERVIDOR!     ............................................................  Description: [INFORMIX][INFORMIX ODBC DRIVER]UNSPECIFIED SYSTEM ERROR =  -21005. Help Context: 1000440 Help File:  Number: -2147467259 Source: CONNECTTODBOPENRECORDSET     ............................................................]
//        at com.thoughtworks.selenium.HttpCommandProcessor.throwAssertionFailureExceptionOrError(HttpCommandProcessor.java:112)
//        at com.thoughtworks.selenium.HttpCommandProcessor.doCommand(HttpCommandProcessor.java:106)
//        at com.thoughtworks.selenium.DefaultSelenium.click(DefaultSelenium.java:193)
//        at Crawler.testCrawler(Crawler.java:29)