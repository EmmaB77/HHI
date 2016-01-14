package Beans;


public class NominaBean {
    
    private int idNom;
    private int id_empleado;
    private PersonaBean persona;
    private EmpleadoBean empleado;
    private String semanaNom;
    private float hrsLunes;
    private float hrsMartes;
    private float hrsMiercoles;
    private float hrsJueves;
    private float hrsViernes;
    private float hrsExtra;
    private float hrsTotales;
    private float sueldoT;

    public PersonaBean getPersona() {
        return persona;
    }

    public void setPersona(PersonaBean persona) {
        this.persona = persona;
    }

    public EmpleadoBean getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoBean empleadoNom) {
        this.empleado = empleadoNom;
    }

    public float getHrsLunes() {
        return hrsLunes;
    }

    public void setHrsLunes(float hrsLunes) {
        this.hrsLunes = hrsLunes;
    }

    public float getHrsMartes() {
        return hrsMartes;
    }

    public void setHrsMartes(float hrsMartes) {
        this.hrsMartes = hrsMartes;
    }

    public float getHrsMiercoles() {
        return hrsMiercoles;
    }

    public void setHrsMiercoles(float hrsMiercoles) {
        this.hrsMiercoles = hrsMiercoles;
    }

    public float getHrsJueves() {
        return hrsJueves;
    }

    public void setHrsJueves(float hrsJueves) {
        this.hrsJueves = hrsJueves;
    }

    public float getHrsViernes() {
        return hrsViernes;
    }

    public void setHrsViernes(float hrsViernes) {
        this.hrsViernes = hrsViernes;
    }

    public float getHrsExtra() {
        return hrsExtra;
    }

    public void setHrsExtra(float horasExtra) {
        this.hrsExtra = horasExtra;
    }

    public float getHrsTotales() {
        return hrsTotales;
    }

    public void setHrsTotales(float hrsTotales) {
        this.hrsTotales = hrsTotales;
    }

    public float getSueldoT() {
        return sueldoT;
    }

    public void setSueldoT(float sueldoT) {
        this.sueldoT = sueldoT;
    }

    public String getSemanaNom() {
        return semanaNom;
    }

    public void setSemanaNom(String semanaNom) {
        this.semanaNom = semanaNom;
    }

    public int getIdNom() {
        return idNom;
    }

    public void setIdNom(int idNom) {
        this.idNom = idNom;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }
    
}
