package Beans;

public class EmpleadoBean {
    
    private int idEmpleado;
    private int idPersona;
    private String puesto;
    private float salarioxdia;
    private float infonavit;
    private String cuentaB;
    private float transa;
    private PersonaBean persona;

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

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public float getSalarioxdia() {
        return salarioxdia;
    }

    public void setSalarioxdia(float salarioxdia) {
        this.salarioxdia = salarioxdia;
    }

    public float getInfonavit() {
        return infonavit;
    }

    public void setInfonavit(float infonavit) {
        this.infonavit = infonavit;
    }

    public String getCuentaB() {
        return cuentaB;
    }

    public void setCuentaB(String cuentaB) {
        this.cuentaB = cuentaB;
    }

    public float getTransa() {
        return transa;
    }

    public void setTransa(float transa) {
        this.transa = transa;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

}
