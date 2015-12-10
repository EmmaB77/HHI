package Modelo;

import Beans.GastoIndirectoBean;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GastoIndirecto {

    public static int agregarGasto(GastoIndirectoBean gasto) {
        int status = 0;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        /*FECHA DATE|PROVEEDOR|NUM_FACT|DESCRIPCION|SUBTOTAL|IVA|TOTAL*/
        String query = "insert into gastos_indirectos (fecha_ind, mes, proveedor, num_fact, descripcion, subtotal, iva, total)"
                + " values(?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(query);
            ps.setObject(1, gasto.getFechaIndirect());
            ps.setObject(2, gasto.getMesIndirect());
            ps.setObject(3, gasto.getProveeIndirect());
            ps.setObject(4, gasto.getNumFactIndirect());
            ps.setObject(5, gasto.getDescIndirect());
            ps.setObject(6, gasto.getSubToIndirect());
            ps.setObject(7, gasto.getIvaIndirect());
            ps.setObject(8, gasto.getTotalIndirect());
            status = ps.executeUpdate();
            System.out.println("Exito en el registro");
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }

    public static int eliminarGasto(int idGasto) {
        int status = 0;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "delete from gastos_indirectos where id_indirect=?";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, idGasto);
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }

    public static List<GastoIndirectoBean> listaGastos() {
        List<GastoIndirectoBean> lista = new ArrayList<>();
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "select id_indirect, fecha_ind, mes, proveedor, num_fact, descripcion, subtotal, iva, total from gastos_indirectos order by id_indirect desc";
        try {
            ps = con.prepareStatement(query);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                GastoIndirectoBean gasto = new GastoIndirectoBean();
                gasto.setIdIndirect(rs.getInt("id_indirect"));
                gasto.setFechaIndirect(rs.getString("fecha_ind"));
                gasto.setMesIndirect(rs.getString("mes"));
                gasto.setProveeIndirect(rs.getString("proveedor"));
                gasto.setNumFactIndirect(rs.getString("num_fact"));
                gasto.setDescIndirect(rs.getString("descripcion"));
                gasto.setSubToIndirect(rs.getFloat("subtotal"));
                gasto.setIvaIndirect(rs.getFloat("iva"));
                gasto.setTotalIndirect(rs.getFloat("total"));
                lista.add(gasto);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lista;
    }

    public static int modificarGasto(GastoIndirectoBean gasto) {
        int status = 0;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "update gastos_indirectos set fecha_ind=?, mes=?, proveedor=?, num_fact=?, descripcion=?, subtotal=?, iva=?, total=?"
                + " where id_indirect=?";
        try {
            ps = con.prepareStatement(query);
            ps.setObject(1, gasto.getFechaIndirect());
            ps.setObject(2, gasto.getMesIndirect());
            ps.setObject(3, gasto.getProveeIndirect());
            ps.setObject(4, gasto.getNumFactIndirect());
            ps.setObject(5, gasto.getDescIndirect());
            ps.setObject(6, gasto.getSubToIndirect());
            ps.setObject(7, gasto.getIvaIndirect());
            ps.setObject(8, gasto.getTotalIndirect());
            ps.setObject(9, gasto.getIdIndirect());
            status = ps.executeUpdate();
            con.close();
            System.out.println("Exito");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }
}
