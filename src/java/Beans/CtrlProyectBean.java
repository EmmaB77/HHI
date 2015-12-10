package Beans;

public class CtrlProyectBean {
    
    private int idCtrlProy;
    private ProyectoBean proyecto;
    private String mesCtrlProy;
    private EmpresaBean empresa;
    private String estatusCtrlProy;
    private String factHHICtrlProy;
    private CotizacionBean cotizacion;

    public int getIdCtrlProy() {
        return idCtrlProy;
    }

    public void setIdCtrlProy(int idCtrlProy) {
        this.idCtrlProy = idCtrlProy;
    }

    public ProyectoBean getProyecto() {
        return proyecto;
    }

    public void setProyecto(ProyectoBean proyecto) {
        this.proyecto = proyecto;
    }

    public String getMesCtrlProy() {
        return mesCtrlProy;
    }

    public void setMesCtrlProy(String mesCtrlProy) {
        this.mesCtrlProy = mesCtrlProy;
    }

    public EmpresaBean getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaBean empresa) {
        this.empresa = empresa;
    }

    public String getEstatusCtrlProy() {
        return estatusCtrlProy;
    }

    public void setEstatusCtrlProy(String estatusCtrlProy) {
        this.estatusCtrlProy = estatusCtrlProy;
    }

    public String getFactHHICtrlProy() {
        return factHHICtrlProy;
    }

    public void setFactHHICtrlProy(String factHHICtrlProy) {
        this.factHHICtrlProy = factHHICtrlProy;
    }

    public CotizacionBean getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(CotizacionBean cotizacion) {
        this.cotizacion = cotizacion;
    }
    
    
    
}
