package Modelo;

import Beans.InversionEquipoBean;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InversionEquipo {
    
    public static int agregarEquipo(InversionEquipoBean equipo) {
        int status = 0;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        /*FECHA DATE|PROVEEDOR|NUM_FACT|DESCRIPCION|SUBTOTAL|IVA|TOTAL*/
        String query = "insert into inversion_equipo (fecha, proveedor, num_fact, descripcion, subtotal, iva, total)"
                + " values(?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(query);
            ps.setObject(1, equipo.getFechaEquipo());
            ps.setObject(2, equipo.getProveedorEquipo());
            ps.setObject(3, equipo.getFacturaEquipo());
            ps.setObject(4, equipo.getDescripEquipo());
            ps.setObject(5, equipo.getSubtEquipo());
            ps.setObject(6, equipo.getIvaEquipo());
            ps.setObject(7, equipo.getTotalEquipo());
            status = ps.executeUpdate();
            System.out.println("Exito en el registro");
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }

    public static int eliminarEquipo(int idEquipo) {
        int status = 0;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "delete from inversion_equipo where id_equipo=?";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, idEquipo);
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }

    public static List<InversionEquipoBean> listaEquipo() {
        List<InversionEquipoBean> lista = new ArrayList<>();
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "select id_equipo, fecha, proveedor, num_fact, descripcion, subtotal, iva, total from inversion_equipo order by id_equipo desc";
        try {
            ps = con.prepareStatement(query);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                InversionEquipoBean equipo = new InversionEquipoBean();
                equipo.setIdEquipo(rs.getInt("id_equipo"));
                equipo.setFechaEquipo(rs.getString("fecha"));
                equipo.setProveedorEquipo(rs.getString("proveedor"));
                equipo.setFacturaEquipo(rs.getString("num_fact"));
                equipo.setDescripEquipo(rs.getString("descripcion"));
                equipo.setSubtEquipo(rs.getFloat("subtotal"));
                equipo.setIvaEquipo(rs.getFloat("iva"));
                equipo.setTotalEquipo(rs.getFloat("total"));
                lista.add(equipo);
                }con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lista;
    }
    
    public static int modificarEquipo(InversionEquipoBean equipo){
        int status=0;
        Connection con= Conexion.getConnetion();
        PreparedStatement ps;
        String query="update inversion_equipo set fecha=?, proveedor=?, num_fact=?, descripcion=?, subtotal=?, iva=?, total=?"
                + " where id_equipo=?";
        try{
            ps=con.prepareStatement(query);
            ps.setObject(1, equipo.getFechaEquipo());
            ps.setObject(2, equipo.getProveedorEquipo());
            ps.setObject(3, equipo.getFacturaEquipo());
            ps.setObject(4, equipo.getDescripEquipo());
            ps.setObject(5, equipo.getSubtEquipo());
            ps.setObject(6, equipo.getIvaEquipo());
            ps.setObject(7, equipo.getTotalEquipo());
            ps.setObject(8, equipo.getIdEquipo());
            status=ps.executeUpdate();
            con.close();
            System.out.println("Exito");
        } catch(SQLException e){
            System.out.println(e);
        }
        return status;
    }
}
