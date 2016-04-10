package Beans;

public class CotDetalleBean {
    
    private int idCotDet;
    private int idCot;
    private CotizacionBean cotizacion;
    private int incisoCotDet;
    private String descCotDet;
    private float cantCotDet;
    private String uniCotDet;
    private float precioUni;
    private float importeCotDet;

    public int getIdCotDet() {
        return idCotDet;
    }

    public void setIdCotDet(int idCotDet) {
        this.idCotDet = idCotDet;
    }

    public CotizacionBean getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(CotizacionBean cotizacion) {
        this.cotizacion = cotizacion;
    }

    public int getIncisoCotDet() {
        return incisoCotDet;
    }

    public void setIncisoCotDet(int incisoCotDet) {
        this.incisoCotDet = incisoCotDet;
    }

    public String getDescCotDet() {
        return descCotDet;
    }

    public void setDescCotDet(String descCotDet) {
        this.descCotDet = descCotDet;
    }

    public float getCantCotDet() {
        return cantCotDet;
    }

    public void setCantCotDet(float cantCotDet) {
        this.cantCotDet = cantCotDet;
    }

    public String getUniCotDet() {
        return uniCotDet;
    }

    public void setUniCotDet(String uniCotDet) {
        this.uniCotDet = uniCotDet;
    }

    public float getImporteCotDet() {
        return importeCotDet;
    }

    public void setImporteCotDet(float importeCotDet) {
        this.importeCotDet = importeCotDet;
    }
    
    public int getIdCot() {
        return idCot;
    }

    public void setIdCot(int idCot) {
        this.idCot = idCot;
    }

    public float getPrecioUni() {
        return precioUni;
    }

    public void setPrecioUni(float precioUni) {
        this.precioUni = precioUni;
    }
    
    
}
