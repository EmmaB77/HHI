package Beans;

import java.util.List;

public class CotizacionBean {
    
    private int idCot;;
    private String referencia;
    private String fechaSolCot;
    private String solCot;
    private String tituloCot;
    private String descCot;
    private String numCot;
    private String fechaCot;
    private float montoCot;
    private String ordComCot;
    private String fechaReciCot;
    private UsuarioBean usuario;
    private EmpleadoBean empleado;
    private String fechaEnCot;
    private int avanceCot;
    private String estatusCot;
    private String numFactCot;
    private int diasCredCot;
    private float total;
    private String canLetCot;
    private List<Integer> inciso;
    private List<String> Desc_Detail;
    private List<Integer> cantidad;
    private List<String> unidad;
    private List<Float> importe;

    public List<Integer> getInciso() {
        return inciso;
    }

    public void setInciso(List<Integer> inciso) {
        this.inciso = inciso;
    }

    public List<String> getDesc_Detail() {
        return Desc_Detail;
    }

    public void setDesc_Detail(List<String> Desc_Detail) {
        this.Desc_Detail = Desc_Detail;
    }

    public List<Integer> getCantidad() {
        return cantidad;
    }

    public void setCantidad(List<Integer> cantidad) {
        this.cantidad = cantidad;
    }

    public List<String> getUnidad() {
        return unidad;
    }

    public void setUnidad(List<String> unidad) {
        this.unidad = unidad;
    }

    public List<Float> getImporte() {
        return importe;
    }

    public void setImporte(List<Float> importe) {
        this.importe = importe;
    }
    
    
    public int getIdCot() {
        return idCot;
    }

    public void setIdCot(int idCot) {
        this.idCot = idCot;
    }

    public String getFechaSolCot() {
        return fechaSolCot;
    }

    public void setFechaSolCot(String fechaSolCot) {
        this.fechaSolCot = fechaSolCot;
    }

    public String getSolCot() {
        return solCot;
    }

    public void setSolCot(String solCot) {
        this.solCot = solCot;
    }

    public String getTituloCot() {
        return tituloCot;
    }

    public void setTituloCot(String tituloCot) {
        this.tituloCot = tituloCot;
    }

    public String getDescCot() {
        return descCot;
    }

    public void setDescCot(String descCot) {
        this.descCot = descCot;
    }

    public String getNumCot() {
        return numCot;
    }

    public void setNumCot(String numCot) {
        this.numCot = numCot;
    }

    public String getFechaCot() {
        return fechaCot;
    }

    public void setFechaCot(String fechaCot) {
        this.fechaCot = fechaCot;
    }

    public float getMontoCot() {
        return montoCot;
    }

    public void setMontoCot(float montoCot) {
        this.montoCot = montoCot;
    }

    public String getOrdComCot() {
        return ordComCot;
    }

    public void setOrdComCot(String ordComCot) {
        this.ordComCot = ordComCot;
    }

    public String getFechaReciCot() {
        return fechaReciCot;
    }

    public void setFechaReciCot(String fechaReciCot) {
        this.fechaReciCot = fechaReciCot;
    }

    public UsuarioBean getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioBean usuario) {
        this.usuario = usuario;
    }

    public EmpleadoBean getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoBean empleado) {
        this.empleado = empleado;
    }

    public String getFechaEnCot() {
        return fechaEnCot;
    }

    public void setFechaEnCot(String fechaEnCot) {
        this.fechaEnCot = fechaEnCot;
    }

    public int getAvanceCot() {
        return avanceCot;
    }

    public void setAvanceCot(int avanceCot) {
        this.avanceCot = avanceCot;
    }

    public String getEstatusCot() {
        return estatusCot;
    }

    public void setEstatusCot(String estatusCot) {
        this.estatusCot = estatusCot;
    }

    public String getNumFactCot() {
        return numFactCot;
    }

    public void setNumFactCot(String numFactCot) {
        this.numFactCot = numFactCot;
    }

    public int getDiasCredCot() {
        return diasCredCot;
    }

    public void setDiasCredCot(int diasCredCot) {
        this.diasCredCot = diasCredCot;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getCanLetCot() {
        return canLetCot;
    }

    public void setCanLetCot(String canLetCot) {
        this.canLetCot = canLetCot;
    }
    
    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    
}
