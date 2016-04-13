package Modelo;

import Beans.CotDetalleBean;
import Beans.CotizacionBean;
import Beans.EmpresaBean;
import Beans.EmpleadoBean;
import Beans.UsuarioBean;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cotizacion {

    public static int agregarCot(CotizacionBean cotizac) {
        int status = 0;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "insert into COTIZACION(NUM_COT,FECHA_SOL,SOL_COT,REFERENCIA,TITULO,DESCRIPCION,FECHA_COT,ID_USUARIO,ID_EMPLEADO,STATUS,\n"
                + "TOTAL,CANTIDAD_LETRA,ORDEN_COMPRA,AVANCE,NUM_FACT,TIEMPO_ENTREGA) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        try {
            ps = con.prepareStatement(query);
            ps.setObject(1, cotizac.getNumCot());
            ps.setObject(2, cotizac.getFechaSolCot());
            ps.setObject(3, cotizac.getSolCot());
            ps.setObject(4, cotizac.getReferencia());
            ps.setObject(5, cotizac.getTituloCot());
            ps.setObject(6, cotizac.getDescCot());
            ps.setObject(7, cotizac.getFechaCot());
            ps.setObject(8, cotizac.getIduser());
            ps.setObject(9, cotizac.getIdemplo());
            ps.setObject(10, cotizac.getEstatusCot());
            ps.setObject(11, cotizac.getTotal());
            ps.setObject(12, cotizac.getCanLetCot());
            ps.setObject(13, cotizac.getOrdComCot());
            ps.setObject(14, cotizac.getAvanceCot());
            ps.setObject(15, cotizac.getNumFactCot());
            ps.setObject(16, cotizac.getTiempoEntrega());
            status = ps.executeUpdate();
            System.out.println("Exito en el registro");
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }

    public static int agregarDetalle(CotDetalleBean coti) {
        int status = 0;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "insert into DETALLE_COT(ID_COTI,INCISO,DESC_DETAIL,CANTIDAD,UNIDAD,PRECIO_U,IMPORTE) VALUES (?,?,?,?,?,?,?);";
        try {
            ps = con.prepareStatement(query);
            ps.setObject(1, coti.getIdCot());
            ps.setObject(2, coti.getIncisoCotDet());
            ps.setObject(3, coti.getDescCotDet());
            ps.setObject(4, coti.getCantCotDet());
            ps.setObject(5, coti.getUniCotDet());
            ps.setObject(6, coti.getPrecioUni());
            ps.setObject(7, coti.getImporteCotDet());
            status = ps.executeUpdate();
            System.out.println("Exito: Concepto Agregado");
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }
    
    public static int modificarCot(int idcoti, CotizacionBean cotizac) {
        int status = 0;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "update COTIZACION set NUM_COT=?, FECHA_SOL=?, SOL_COT=?, REFERENCIA=?, TITULO=?, DESCRIPCION=?, FECHA_COT=?, ID_USUARIO=?, ID_EMPLEADO=?, STATUS=?,\n"
                + "TOTAL=?, CANTIDAD_LETRA=?, TIEMPO_ENTREGA=?;";
        try {
            ps = con.prepareStatement(query);
            ps.setObject(1, cotizac.getNumCot());
            ps.setObject(2, cotizac.getFechaSolCot());
            ps.setObject(3, cotizac.getSolCot());
            ps.setObject(4, cotizac.getReferencia());
            ps.setObject(5, cotizac.getTituloCot());
            ps.setObject(6, cotizac.getDescCot());
            ps.setObject(7, cotizac.getFechaCot());
            ps.setObject(8, cotizac.getIduser());
            ps.setObject(9, cotizac.getIdemplo());
            ps.setObject(10, cotizac.getEstatusCot());
            ps.setObject(11, cotizac.getTotal());
            ps.setObject(12, cotizac.getCanLetCot());
            ps.setObject(13, cotizac.getTiempoEntrega());
            status = ps.executeUpdate();
            System.out.println("Exito Cotizacion Modificada");
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }
    
    public static int modDetalle(int idCotDet, CotDetalleBean coti) {
        int status = 0;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "update detalle_cot set inciso=?, desc_detail=?, cantidad=?, unidad=?, precio_u=?, importe=? where id_detal_c="+idCotDet+";";
        try {
            ps = con.prepareStatement(query);
            ps.setObject(1, coti.getIncisoCotDet());
            ps.setObject(2, coti.getDescCotDet());
            ps.setObject(3, coti.getCantCotDet());
            ps.setObject(4, coti.getUniCotDet());
            ps.setObject(5, coti.getPrecioUni());
            ps.setObject(6, coti.getImporteCotDet());
            status = ps.executeUpdate();
            System.out.println("Exito: Concepto Modificado");
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }

    public static int eliminarCot(int idCot) {
        int status = 0;
        Connection cn = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "delete from cotizacion where idCoti=?";
        try {
            ps = cn.prepareStatement(query);
            ps.setObject(1, idCot);
            status = ps.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }
    
    public static int eliminarDetalle(int idCotDet) {
        int status = 0;
        Connection cn = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "delete from detalle_cot where id_detal_c=?";
        try {
            ps = cn.prepareStatement(query);
            ps.setObject(1, idCotDet);
            status = ps.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }

    public static List<CotizacionBean> listarCotizaciones() {
        Connection con = Conexion.getConnetion();
        List<CotizacionBean> lista = new ArrayList<>();
        PreparedStatement ps;
        String query = "Select ID_COTI, NUM_COT, REFERENCIA, SOL_COT, TITULO, FECHA_COT, TOTAL, STATUS, ORDEN_COMPRA, AVANCE, NUM_FACT, ID_USUARIO, TIEMPO_ENTREGA from cotizacion;";
        try {
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CotizacionBean cotizac = new CotizacionBean();
                cotizac.setIdCot(rs.getInt("ID_COTI"));
                cotizac.setNumCot(rs.getString("NUM_COT"));
                cotizac.setReferencia(rs.getString("REFERENCIA"));
                cotizac.setSolCot(rs.getString("SOL_COT"));
                cotizac.setTituloCot(rs.getString("TITULO"));
                cotizac.setFechaCot(rs.getString("FECHA_COT"));
                cotizac.setTotal(rs.getFloat("TOTAL"));
                cotizac.setEstatusCot(rs.getString("STATUS"));
                cotizac.setOrdComCot(rs.getString("ORDEN_COMPRA"));
                cotizac.setAvanceCot(rs.getString("AVANCE"));
                cotizac.setNumFactCot(rs.getString("NUM_FACT"));
                cotizac.setIduser(rs.getInt("ID_USUARIO"));
                cotizac.setTiempoEntrega(rs.getString("TIEMPO_ENTREGA"));
                cotizac.setUsuario(Solicitante.obtenerUsuario(cotizac.getIduser()));
                lista.add(cotizac);
            }
            con.close();
            System.out.println("Se realizo la siguiente consulta: " + query);
            System.out.println("Estoy haciendo magia espera...");
            System.out.println("Se imprimio algo... tal vez no lo veas pero este mensaje lo confirma");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lista;
    }

    public static int asignarOrdenCompra(String numcot, String orden) {
        int status=0;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "Update Cotizacion set orden_compra='"+orden+"' where num_cot='"+numcot+"';";
        try {
            ps = con.prepareStatement(query);
            status = ps.executeUpdate();
            System.out.println("Exito: Orden Asignada");
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }
    
    public static int agregarFactura(String numcot, String nueva, String avance) {
        int status=0;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "Update Cotizacion set num_fact='"+nueva+"', avance='"+avance+"' where num_cot='"+numcot+"';";
        try {
            ps = con.prepareStatement(query);
            status = ps.executeUpdate();
            System.out.println("Exito: Nueva Factura Agregada");
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }
    
    public static List<CotizacionBean> obtenerCotizacion(int idCot) {
        Connection con = Conexion.getConnetion();
        List<CotizacionBean> lista = new ArrayList<>();
        PreparedStatement ps;
        String query = "Select ID_COTI, NUM_COT, REFERENCIA, SOL_COT, TITULO, FECHA_SOL, FECHA_COT, TOTAL, ID_USUARIO, TIEMPO_ENTREGA, DESCRIPCION, CANTIDAD_LETRA from cotizacion where id_coti="+idCot+";";
        try {
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CotizacionBean cotizac = new CotizacionBean();
                cotizac.setIdCot(rs.getInt("ID_COTI"));
                cotizac.setNumCot(rs.getString("NUM_COT"));
                cotizac.setReferencia(rs.getString("REFERENCIA"));
                cotizac.setSolCot(rs.getString("SOL_COT"));
                cotizac.setTituloCot(rs.getString("TITULO"));
                cotizac.setFechaSolCot(rs.getString("FECHA_SOL"));
                cotizac.setFechaCot(rs.getString("FECHA_COT"));
                cotizac.setTotal(rs.getFloat("TOTAL"));
                cotizac.setIduser(rs.getInt("ID_USUARIO"));
                cotizac.setTiempoEntrega(rs.getString("TIEMPO_ENTREGA"));
                cotizac.setDescCot(rs.getString("DESCRIPCION"));
                cotizac.setCanLetCot(rs.getString("CANTIDAD_LETRA"));
                cotizac.setUsuario(Solicitante.obtenerUsuario(cotizac.getIduser()));
                lista.add(cotizac);
            }
            con.close();
            System.out.println("Se realizo la siguiente consulta: " + query);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lista;
    }
    
    public static List<CotDetalleBean> obtenerDetallesCot(int idCot) {
        Connection con = Conexion.getConnetion();
        List<CotDetalleBean> lista = new ArrayList<>();
        PreparedStatement ps;
        String query = "Select ID_DETAL_C, INCISO, DESC_DETAIL, CANTIDAD, UNIDAD, PRECIO_U, IMPORTE from detalle_cot where id_coti="+idCot+";";
        try {
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CotDetalleBean cotizac = new CotDetalleBean();
                cotizac.setIdCotDet(rs.getInt("ID_DETAL_C"));
                cotizac.setIncisoCotDet(rs.getInt("INCISO"));
                cotizac.setDescCotDet(rs.getString("DESC_DETAIL"));
                cotizac.setCantCotDet(rs.getFloat("CANTIDAD"));
                cotizac.setUniCotDet(rs.getString("UNIDAD"));
                cotizac.setPrecioUni(rs.getFloat("PRECIO_U"));
                cotizac.setImporteCotDet(rs.getFloat("IMPORTE"));
                lista.add(cotizac);
            }
            con.close();
            System.out.println("Se realizo la siguiente consulta: " + query);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lista;
    }
}
