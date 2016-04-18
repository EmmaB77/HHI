package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Beans.ProyectoBean;
import Beans.ProyectoMDBean;
import Beans.ProyectoMCBean;
import Beans.ProyectoMIBean;
import Beans.ProyectoMaOBean;
import java.util.AbstractList;

public class Proyecto {

    public static int agregarProyecto(ProyectoBean project) {
        int status = 0;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "INSERT INTO PROYECTO(NOMBRE_PROYECTO,NUM_ORD_COMP, REQUISICION, FECHA_INICIO, PRESUPUESTO, DISPONIBLE, INCURRIDO, IVA, TOTAL, UTILIDAD) values(?,?,?,?,?,?,?,?,?,?);";
        try {
            ps = con.prepareStatement(query);
            ps.setObject(1, project.getNombreProyecto());
            ps.setObject(2, project.getOrdenComProyecto());
            ps.setObject(3, project.getRequiProyecto());
            ps.setObject(4, project.getFehaIProyecto());
            ps.setObject(5, project.getPresupuestoProyecto());
            ps.setObject(6, project.getDispProyecto());
            ps.setObject(7, project.getIncurridoProyecto());
            ps.setObject(8, project.getIvaProyecto());
            ps.setObject(9, project.getTotalproyecto());
            ps.setObject(10, project.getUtilidadProyecto());
            status = ps.executeUpdate();
            System.out.println("Exito en el registro");
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }

    public static int agregarMatDirect(int idProy, ProyectoMDBean matd, ProyectoBean proy) {
        int status = 0;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        PreparedStatement ps2;
        /*FECHA DATE|PROVEEDOR|NUM_FACT|DESCRIPCION|SUBTOTAL|IVA|TOTAL*/
        String query = "insert into proyecto_mat_directo (id_proyecto, fecha, proveedor, num_fact, descripcion, subtotal, iva, total)"
                + " values(?,?,?,?,?,?,?,?)";

        String query2 = "update proyecto set INCURRIDO=?, DISPONIBLE=?, UTILIDAD=?";

        try {
            ps = con.prepareStatement(query);
            ps.setObject(1, matd.getIdProyecto());
            ps.setObject(2, matd.getFechaFactMatDirect());
            ps.setObject(3, matd.getPreveedorMatDirect());
            ps.setObject(4, matd.getNumFactMatDirect());
            ps.setObject(5, matd.getDescripMatDirect());
            ps.setObject(6, matd.getSubtMatDirect());
            ps.setObject(7, matd.getIvaMatDirect());
            ps.setObject(8, matd.getTotalMatDirect());
            status = ps.executeUpdate();
            System.out.println("Agregado " + matd.getDescripMatDirect());

            ps2 = con.prepareStatement(query2);
            ps2.setObject(1, proy.getIncurridoProyecto());
            ps2.setObject(2, proy.getDispProyecto());
            ps2.setObject(3, proy.getUtilidadProyecto());
            status = ps2.executeUpdate();
            System.out.println("Proyecto Actualizado");

            con.close();
        } catch (SQLException e) {

            System.out.println(e);
        }
        return status;
    }

    public static int agregarMatIndirect(int idProy, ProyectoMIBean matd, ProyectoBean proy) {
        int status = 0;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        PreparedStatement ps2;
        /*FECHA DATE|PROVEEDOR|NUM_FACT|DESCRIPCION|SUBTOTAL|IVA|TOTAL*/
        String query = "insert into proyecto_mat_indirecto (id_proyecto, fecha, proveedor, num_fact, descripcion, subtotal, iva, total)"
                + " values(?,?,?,?,?,?,?,?)";

        String query2 = "update proyecto set INCURRIDO=?, DISPONIBLE=?, UTILIDAD=?";

        try {
            ps = con.prepareStatement(query);
            ps.setObject(1, matd.getIdProyecto());
            ps.setObject(2, matd.getFechaFactMatIn());
            ps.setObject(3, matd.getPreveedorMatIn());
            ps.setObject(4, matd.getNumFactMatIn());
            ps.setObject(5, matd.getDescripMatIn());
            ps.setObject(6, matd.getSubtMatIn());
            ps.setObject(7, matd.getIvaMatIn());
            ps.setObject(8, matd.getTotalMatIn());
            status = ps.executeUpdate();
            System.out.println("Agregado " + matd.getDescripMatIn());

            ps2 = con.prepareStatement(query2);
            ps2.setObject(1, proy.getIncurridoProyecto());
            ps2.setObject(2, proy.getDispProyecto());
            ps2.setObject(3, proy.getUtilidadProyecto());
            status = ps2.executeUpdate();
            System.out.println("Proyecto Actualizado");

            con.close();
        } catch (SQLException e) {

            System.out.println(e);
        }
        return status;
    }

    public static int agregarMatConsumo(int idProy, ProyectoMCBean matd, ProyectoBean proy) {
        int status = 0;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        PreparedStatement ps2;
        /*FECHA DATE|PROVEEDOR|NUM_FACT|DESCRIPCION|SUBTOTAL|IVA|TOTAL*/
        String query = "insert into proyecto_mat_consumo (id_proyecto, fecha, proveedor, num_fact, descripcion, subtotal, iva, total)"
                + " values(?,?,?,?,?,?,?,?)";

        String query2 = "update proyecto set INCURRIDO=?, DISPONIBLE=?, UTILIDAD=?";

        try {
            ps = con.prepareStatement(query);
            ps.setObject(1, matd.getIdProyecto());
            ps.setObject(2, matd.getFechaFactMatCon());
            ps.setObject(3, matd.getPreveedorMatCon());
            ps.setObject(4, matd.getNumFactMatCon());
            ps.setObject(5, matd.getDescripMatCon());
            ps.setObject(6, matd.getSubtMatCon());
            ps.setObject(7, matd.getIvaMatCon());
            ps.setObject(8, matd.getTotalMatCon());
            status = ps.executeUpdate();
            System.out.println("Agregado " + matd.getDescripMatCon());

            ps2 = con.prepareStatement(query2);
            ps2.setObject(1, proy.getIncurridoProyecto());
            ps2.setObject(2, proy.getDispProyecto());
            ps2.setObject(3, proy.getUtilidadProyecto());
            status = ps2.executeUpdate();
            System.out.println("Proyecto Actualizado");

            con.close();
        } catch (SQLException e) {

            System.out.println(e);
        }
        return status;
    }

    public static int agregarManoObra(int idProy, ProyectoMaOBean matd, ProyectoBean proy) {
        int status = 0;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        PreparedStatement ps2;
        /*FECHA DATE|PROVEEDOR|NUM_FACT|DESCRIPCION|SUBTOTAL|IVA|TOTAL*/
        String query = "insert into proyecto_mano_obra (id_proyecto, descripcion, subtotal)"
                + " values(?,?,?,?,?,?,?)";

        String query2 = "update proyecto set INCURRIDO=?, DISPONIBLE=?, UTILIDAD=?";

        try {
            ps = con.prepareStatement(query);
            ps.setObject(1, matd.getIdProyecto());
            ps.setObject(2, matd.getDescMaO());
            ps.setObject(3, matd.getSubtMaO());
            status = ps.executeUpdate();
            System.out.println("Agregado " + matd.getDescMaO());

            ps2 = con.prepareStatement(query2);
            ps2.setObject(1, proy.getIncurridoProyecto());
            ps2.setObject(2, proy.getDispProyecto());
            ps2.setObject(3, proy.getUtilidadProyecto());
            status = ps2.executeUpdate();
            System.out.println("Proyecto Actualizado");

            con.close();
        } catch (SQLException e) {

            System.out.println(e);
        }
        return status;
    }

    public static float obtenerIncurrido(int id) {
        float incurrido = 0;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "Select INCURRIDO from PROYECTO where id_proyecto=" + id;
        try {
            ps = con.prepareStatement(query);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                incurrido = rs.getFloat("INCURRIDO");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return incurrido;
    }

    public static float obtenerPresupuesto(int id) {
        float presupuesto = 0;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "Select PRESUPUESTO from PROYECTO where id_proyecto=" + id;
        try {
            ps = con.prepareStatement(query);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                presupuesto = rs.getFloat("PRESUPUESTO");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return presupuesto;
    }

    public static float obtenerDisponible(int id) {
        float disponible = 0;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "Select DISPONIBLE from PROYECTO where id_proyecto=" + id;
        try {
            ps = con.prepareStatement(query);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                disponible = rs.getFloat("DISPONIBLE");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return disponible;
    }

    public static List<ProyectoMDBean> totalesDirecto(int id) {
        List<ProyectoMDBean> lista = new ArrayList<>();
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "select ID_PROYECTO, sum(SUBTOTAL) as SUBTOTAL, sum(IVA) as TOTAL_IVA, sum(TOTAL) as TOTAL_FINAL from PROYECTO_MAT_DIRECTO where ID_PROYECTO=" + id + " GROUP BY ID_PROYECTO";
        try {
            ps = con.prepareStatement(query);
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                ProyectoMDBean proymd = new ProyectoMDBean();
                proymd.setIdProyecto(rs.getInt("ID_PROYECTO"));
                proymd.setTotalParcialMD(rs.getFloat("SUBTOTAL"));
                proymd.setTotalIvaMD(rs.getFloat("TOTAL_IVA"));
                proymd.setTotalMD(rs.getFloat("TOTAL_FINAL"));
                lista.add(proymd);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lista;
    }
    
    public static List<ProyectoMIBean> totalesIndirecto(int id) {
        List<ProyectoMIBean> lista = new ArrayList<>();
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "select ID_PROYECTO, sum(SUBTOTAL) as SUBTOTAL, sum(IVA) as TOTAL_IVA, sum(TOTAL) as TOTAL_FINAL from PROYECTO_MAT_INDIRECTO where ID_PROYECTO=" + id + " GROUP BY ID_PROYECTO";
        try {
            ps = con.prepareStatement(query);
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                ProyectoMIBean proymd = new ProyectoMIBean();
                proymd.setIdProyecto(rs.getInt("ID_PROYECTO"));
                proymd.setTotalParcialMI(rs.getFloat("SUBTOTAL"));
                proymd.setTotalIvaMI(rs.getFloat("TOTAL_IVA"));
                proymd.setTotalMI(rs.getFloat("TOTAL_FINAL"));
                lista.add(proymd);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lista;
    }

    public static List<ProyectoMCBean> totalesConsumo(int id) {
        List<ProyectoMCBean> lista = new ArrayList<>();
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "select ID_PROYECTO, sum(SUBTOTAL) as SUBTOTAL, sum(IVA) as TOTAL_IVA, sum(TOTAL) as TOTAL_FINAL from PROYECTO_MAT_CONSUMO where ID_PROYECTO=" + id + " GROUP BY ID_PROYECTO";
        try {
            ps = con.prepareStatement(query);
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                ProyectoMCBean proymd = new ProyectoMCBean();
                proymd.setIdProyecto(rs.getInt("ID_PROYECTO"));
                proymd.setTotalParcialMC(rs.getFloat("SUBTOTAL"));
                proymd.setTotalIvaMC(rs.getFloat("TOTAL_IVA"));
                proymd.setTotalMC(rs.getFloat("TOTAL_FINAL"));
                lista.add(proymd);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lista;
    }
    
    public static List<ProyectoBean> listaProyectos() {
        List<ProyectoBean> lista = new ArrayList<>();
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "Select ID_PROYECTO, NOMBRE_PROYECTO, NUM_ORD_COMP, REQUISICION, FECHA_INICIO, PRESUPUESTO, DISPONIBLE from Proyecto";
        try {
            ps = con.prepareStatement(query);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                ProyectoBean proyecto = new ProyectoBean();
                proyecto.setIdProyecto(rs.getInt("id_proyecto"));
                proyecto.setNombreProyecto(rs.getString("nombre_proyecto"));
                proyecto.setOrdenComProyecto(rs.getString("NUM_ORD_COMP"));
                proyecto.setRequiProyecto(rs.getString("REQUISICION"));
                proyecto.setFehaIProyecto(rs.getString("FECHA_INICIO"));
                proyecto.setPresupuestoProyecto(rs.getFloat("PRESUPUESTO"));
                proyecto.setDispProyecto(rs.getFloat("DISPONIBLE"));
                lista.add(proyecto);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lista;
    }

}
