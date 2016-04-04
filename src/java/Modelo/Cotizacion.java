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
        String query = "insert into COTIZACION(NUM_COT,FECHA_SOL,SOL_COT,REFERENCIA,TITULO,DESCRIPCION,FECHA_COT,MONTO,ORDEN_COMPRA,RECIBIDO,ID_USUARIO,FECHA_ENTREGA,ID_EMPLEADO,AVANCE,STATUS,\n"
                + "NUM_FACT,DIAS_CREDIT,TOTAL,CANTIDAD_LETRA,VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        try {
            ps = con.prepareStatement(query);
            ps.setObject(1, cotizac.getNumCot());
            ps.setObject(2, cotizac.getFechaSolCot());
            ps.setObject(3, cotizac.getSolCot());
            ps.setObject(4, cotizac.getReferencia());
            ps.setObject(5, cotizac.getTituloCot());
            ps.setObject(6, cotizac.getDescCot());
            ps.setObject(7, cotizac.getFechaCot());
            ps.setObject(8, cotizac.getMontoCot());
            ps.setObject(9, cotizac.getOrdComCot());
            ps.setObject(10, cotizac.getFechaReciCot());
            ps.setObject(11, cotizac.getUsuario());
            ps.setObject(12, cotizac.getFechaEnCot());
            ps.setObject(13, cotizac.getEmpleado());
            ps.setObject(14, cotizac.getAvanceCot());
            ps.setObject(15, cotizac.getEstatusCot());
            ps.setObject(16, cotizac.getNumFactCot());
            ps.setObject(17, cotizac.getDiasCredCot());
            ps.setObject(18, cotizac.getTotal());
            ps.setObject(19, cotizac.getCanLetCot());
            status = ps.executeUpdate();
            System.out.println("Exito en el registro");
            con.close();
        } catch (SQLException e) {
            try {
                System.out.println("Error, rollback");
                con.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(Cotizacion.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(e);
        }

        return status;
    }

    public static int eliminar(int idCot) {
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

    public static List<CotizacionBean> listarCotizaciones() {
        Connection con = Conexion.getConnetion();
        List<CotizacionBean> lista = new ArrayList<>();
        PreparedStatement ps;
        String query = "Select NUM_COT, REFERENCIA, SOL_COT, TITULO, FECHA_COT, MONTO, STATUS from cotizacion;";
        try {
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CotizacionBean cotizac = new CotizacionBean();
                cotizac.setNumCot(rs.getString("NUM_COT"));
                cotizac.setReferencia(rs.getString("REFERENCIA"));
                cotizac.setSolCot(rs.getString("SOL_COT"));
                cotizac.setTituloCot(rs.getString("TITULO"));
                cotizac.setFechaCot(rs.getString("FECHA_COT"));
                cotizac.setMontoCot(rs.getFloat("MONTO"));
                cotizac.setEstatusCot(rs.getString("STATUS"));
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
}
