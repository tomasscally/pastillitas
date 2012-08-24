import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.List;

public class ParserProducto {

    public static void parse(String producto) {
        saveProspecto(producto);
        Medicamento medicamento = new Medicamento();
        String labo =  parseLabo(producto);
        String nombreMedicamento = parseNombre(producto);
        Integer idAnmat = parseIdAnmat(producto);
        medicamento.setNombreLaboratorio(labo);
        medicamento.setNombreMedicamento(nombreMedicamento);
        medicamento.setIdAnmat(idAnmat);

        String[] secciones = producto.split("Certificado:");
        List<String> subsecciones = Arrays.asList(secciones);
        subsecciones.subList(1,subsecciones.size());
        subsecciones.get(subsecciones.size()-1);
        String ultimo = subsecciones.get(subsecciones.size()-1).split("Prospectos")[0];
        subsecciones.set(subsecciones.size()-1,ultimo);
        for (String parte : subsecciones) {

        }


    }

    private static String saveProspecto(String producto) {
        //save()
        String ret=producto.substring(StringUtils.indexOf(producto, "Prospectos"));
        return ret;
    }

    private static Integer parseIdAnmat(String producto) {
        String numero = producto.split("Certificado")[0].split("Laboratorio: ")[0];
        numero = numero.split("\n")[0];
        numero = numero.split("  ")[1];
        numero = numero.substring(1,numero.length()-1);
        return new Integer(numero);
    }

    private static String parseLabo(String producto) {
        String lab = producto.split("Certificado")[0].split("Laboratorio: ")[1];
        return lab.substring(0,lab.length()-2);
    }

    private static String parseNombre(String producto) {
        String nombre = producto.split("Certificado")[0].split("Laboratorio: ")[0];
        return nombre.substring(0,nombre.length()-12);
    }
}
