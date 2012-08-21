import com.thoughtworks.selenium.*;

import java.util.List;


public class Crawler extends SeleneseTestCase {
    public void setUp() throws Exception {
        setUp("http://www.anmat.gov.ar/", "*chrome");
    }
    public void testCrawler() throws Exception {
        selenium.open("/aplicaciones_net/applications/consultas/lomac/");
        List<String> list = Laboratorios.getList();

        for (String laboratorio :list){
            selenium.type("id=txt_laboratorio", laboratorio);
            selenium.click("id=btn_consultar");
            Integer cantPaginas = buscarCantidadPaginasLabo(laboratorio);
            if(cantPaginas!=0){
                int i=1;
                while(i < cantPaginas+1){
                    System.out.println(i);
                    i++;
                }
            }
        }
    }

    private Integer buscarCantidadPaginasLabo(String laboratorio) {

        Integer ret = 0;
        if(selenium.isTextPresent("Página")){
            String paginaXdeY = selenium.getText("css=div.div_pagina_actual");
            ret = new Integer(paginaXdeY.substring(paginaXdeY.indexOf("de")+3,paginaXdeY.length()));
        }

        return ret;
    }
}
