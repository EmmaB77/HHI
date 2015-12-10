package Beans;

public class EmpleadoBean {
    
    private int idEmpleado;
    private PersonaBean persona;
    private PuestoBean puesto;
    private DepartamentoBean depto;
    private EmpresaBean empresa;

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public PersonaBean getPersona() {
        return persona;
    }

    public void setPersona(PersonaBean persona) {
        this.persona = persona;
    }

    public PuestoBean getPuesto() {
        return puesto;
    }

    public void setPuesto(PuestoBean puesto) {
        this.puesto = puesto;
    }

    public DepartamentoBean getDepto() {
        return depto;
    }

    public void setDepto(DepartamentoBean depto) {
        this.depto = depto;
    }

    public EmpresaBean getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaBean empresa) {
        this.empresa = empresa;
    }
    
    
    
}
