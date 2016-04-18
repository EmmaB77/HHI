package Beans;

public class ProyectoMaOBean {
    
    private int idMaO;
    private ProyectoBean proyecto;
    private int idProyecto;
    private String descMaO;
    private float subtMaO;

    public int getIdMaO() {
        return idMaO;
    }

    public void setIdMaO(int idMaO) {
        this.idMaO = idMaO;
    }

    public ProyectoBean getProyecto() {
        return proyecto;
    }

    public void setProyecto(ProyectoBean proyecto) {
        this.proyecto = proyecto;
    }

    public String getDescMaO() {
        return descMaO;
    }

    public void setDescMaO(String descMaO) {
        this.descMaO = descMaO;
    }

    public float getSubtMaO() {
        return subtMaO;
    }

    public void setSubtMaO(float subtMaO) {
        this.subtMaO = subtMaO;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }
    
}
