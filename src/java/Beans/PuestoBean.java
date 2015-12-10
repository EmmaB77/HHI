package Beans;

public class PuestoBean {
    
    private int idPuesto;
    private DepartamentoBean Departamento;
    private String nombrePuesto;

    public int getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(int idPuesto) {
        this.idPuesto = idPuesto;
    }

    public DepartamentoBean getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(DepartamentoBean Departamento) {
        this.Departamento = Departamento;
    }

    public String getNombrePuesto() {
        return nombrePuesto;
    }

    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }
    
    
}
