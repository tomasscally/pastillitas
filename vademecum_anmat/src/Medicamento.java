import java.io.File;

public class Medicamento {

    private String      nombreMedicamento;
    private Integer     idAnmat;
    private String      nombreLaboratorio;
    private Integer     numeroCertificado;
    private String      fechaVigencia;
    private String      formaFarmaceutica;
    private String      presentacion;
    private Boolean     trazable;
    private Integer     gtin;
    private String      composicion;
    private File        prospecto;

    public Medicamento() {
    }

    public void save(){
        //guardar this en la base.
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    public Integer getIdAnmat() {
        return idAnmat;
    }

    public void setIdAnmat(Integer idAnmat) {
        this.idAnmat = idAnmat;
    }

    public String getNombreLaboratorio() {
        return nombreLaboratorio;
    }

    public void setNombreLaboratorio(String nombreLaboratorio) {
        this.nombreLaboratorio = nombreLaboratorio;
    }

    public Integer getNumeroCertificado() {
        return numeroCertificado;
    }

    public void setNumeroCertificado(Integer numeroCertificado) {
        this.numeroCertificado = numeroCertificado;
    }

    public String getFechaVigencia() {
        return fechaVigencia;
    }

    public void setFechaVigencia(String fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    public String getFormaFarmaceutica() {
        return formaFarmaceutica;
    }

    public void setFormaFarmaceutica(String formaFarmaceutica) {
        this.formaFarmaceutica = formaFarmaceutica;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public Boolean getTrazable() {
        return trazable;
    }

    public void setTrazable(Boolean trazable) {
        this.trazable = trazable;
    }

    public Integer getGtin() {
        return gtin;
    }

    public void setGtin(Integer gtin) {
        this.gtin = gtin;
    }

    public String getComposicion() {
        return composicion;
    }

    public void setComposicion(String composicion) {
        this.composicion = composicion;
    }

    public File getProspecto() {
        return prospecto;
    }

    public void setProspecto(File prospecto) {
        this.prospecto = prospecto;
    }
}
