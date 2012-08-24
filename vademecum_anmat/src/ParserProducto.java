import org.apache.commons.lang.StringUtils;

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

        int cantFormaFarmaceutica = StringUtils.countMatches(producto, "Forma Farmacéutica:");
        while(cantFormaFarmaceutica>0){
            String medicamentoActual = producto.substring(producto.indexOf("Certificado:"));

            producto = producto.substring()
            cantFormaFarmaceutica--;
        }

    }

    private static String saveProspecto(String producto) {
        //save()
        String ret=producto.substring(StringUtils.indexOf(producto, "Prospectos"));
        return ret;
    }

    private static Integer parseIdAnmat(String producto) {
        return new Integer(producto.substring(producto.indexOf("(")+1, producto.indexOf(")")));
    }

    private static String parseLabo(String producto) {
        return producto.substring(producto.indexOf("Laboratorio")+13,producto.indexOf("Certificado")-2);
    }

    private static String parseNombre(String producto) {
        return producto.substring(0,producto.indexOf("  ("));
    }
}
