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
    private float sobresueldo;
    private float viaticos;
    private float otros_ingresos;
    private float infonavit;
    private float otros_deducciones;
    private float sueldo_N;
    private float sueldoEx;
    private float total_ingresos;
    private float total_deducciones;
    private float sueldoT;
    private String date;

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

    public float getSobresueldo() {
        return sobresueldo;
    }

    public void setSobresueldo(float sobresueldo) {
        this.sobresueldo = sobresueldo;
    }

    public float getViaticos() {
        return viaticos;
    }

    public void setViaticos(float viaticos) {
        this.viaticos = viaticos;
    }

    public float getOtros_ingresos() {
        return otros_ingresos;
    }

    public void setOtros_ingresos(float otros_ingresos) {
        this.otros_ingresos = otros_ingresos;
    }

    public float getInfonavit() {
        return infonavit;
    }

    public void setInfonavit(float infonavit) {
        this.infonavit = infonavit;
    }

    public float getOtros_deducciones() {
        return otros_deducciones;
    }

    public void setOtros_deducciones(float otros_deducciones) {
        this.otros_deducciones = otros_deducciones;
    }

    public float getTotal_ingresos() {
        return total_ingresos;
    }

    public void setTotal_ingresos(float total_ingresos) {
        this.total_ingresos = total_ingresos;
    }

    public float getTotal_deducciones() {
        return total_deducciones;
    }

    public void setTotal_deducciones(float total_deducciones) {
        this.total_deducciones = total_deducciones;
    }

    public float getSueldo_N() {
        return sueldo_N;
    }

    public void setSueldo_N(float sueldo_N) {
        this.sueldo_N = sueldo_N;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getSueldoEx() {
        return sueldoEx;
    }

    public void setSueldoEx(float sueldoEx) {
        this.sueldoEx = sueldoEx;
    }
    
    
}
