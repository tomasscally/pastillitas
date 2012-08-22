import com.thoughtworks.selenium.SeleneseTestCase;


public class Crawler extends SeleneseTestCase {
    public void setUp() throws Exception {
        setUp("http://www.anmat.gov.ar/", "*chrome");
    }
    public void testCrawler() throws Exception {
        selenium.open("/aplicaciones_net/applications/consultas/lomac/");

            selenium.type("id=txt_laboratorio", "Bioprofarma");
            selenium.click("id=btn_consultar");
            waitForElement("Se ha utilizado el siguiente filtro para la búsqueda:");
            Integer cantPaginas = buscarCantidadPaginasLabo();
            if(cantPaginas!=0){
                Thread.sleep(30000);
                int paginaInicio=1;
                while(paginaInicio < cantPaginas+1){
                    procesarPagina();
                    selenium.click("id=pagina_siguiente");
                    System.out.println(paginaInicio);
                    paginaInicio++;
                }
            }
            selenium.click("id=div_volver");
            selenium.waitForPageToLoad("30000");
    }

    private void procesarPagina() {
        String surce = selenium.getHtmlSource();
    }

    private void waitForElement(String textContent) {
        while(!selenium.getHtmlSource().contains(textContent)){
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
}

//com.thoughtworks.selenium.SeleniumException: ERROR: There was an unexpected Alert! [ERROR DE CARGA EN SERVIDOR!     ............................................................  Description: [INFORMIX][INFORMIX ODBC DRIVER]UNSPECIFIED SYSTEM ERROR =  -21005. Help Context: 1000440 Help File:  Number: -2147467259 Source: CONNECTTODBOPENRECORDSET     ............................................................]
//        at com.thoughtworks.selenium.HttpCommandProcessor.throwAssertionFailureExceptionOrError(HttpCommandProcessor.java:112)
//        at com.thoughtworks.selenium.HttpCommandProcessor.doCommand(HttpCommandProcessor.java:106)
//        at com.thoughtworks.selenium.DefaultSelenium.click(DefaultSelenium.java:193)
//        at Crawler.testCrawler(Crawler.java:29)