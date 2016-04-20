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
        String query = "insert into proyecto_mat_directo (id_proyecto, fecha_fact, proveedor, num_fact, descripcion, subtotal, iva, total)"
                + " values(?,?,?,?,?,?,?,?)";

        String query2 = "update proyecto set INCURRIDO=?, DISPONIBLE=?, UTILIDAD=? where id_proyecto="+idProy ;

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
        String query = "insert into proyecto_mat_indirect (id_proyecto, fecha_fact, proveedor, num_fact, descripcion, subtotal, iva, total)"
                + " values(?,?,?,?,?,?,?,?)";

        String query2 = "update proyecto set INCURRIDO=?, DISPONIBLE=?, UTILIDAD=? where id_proyecto="+idProy;

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
        String query = "insert into proyecto_mat_consumo (id_proyecto, fecha_fact, proveedor, num_fact, descripcion, subtotal, iva, total)"
                + " values(?,?,?,?,?,?,?,?)";

        String query2 = "update proyecto set INCURRIDO=?, DISPONIBLE=?, UTILIDAD=? where id_proyecto="+idProy;

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
                + " values(?,?,?)";

        String query2 = "update proyecto set INCURRIDO=?, DISPONIBLE=?, UTILIDAD=? where id_proyecto="+idProy;

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
            while (rs.next()) {
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
        String query = "select ID_PROYECTO, sum(SUBTOTAL) as SUBTOTAL, sum(IVA) as TOTAL_IVA, sum(TOTAL) as TOTAL_FINAL from PROYECTO_MAT_INDIRECT where ID_PROYECTO=" + id + " GROUP BY ID_PROYECTO";
        try {
            ps = con.prepareStatement(query);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
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
            while (rs.next()) {
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
    
    public static List<ProyectoMaOBean> totalesMaO(int id) {
        List<ProyectoMaOBean> lista = new ArrayList<>();
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "select ID_PROYECTO, sum(SUBTOTAL) as SUBTOTAL from PROYECTO_MANO_OBRA where ID_PROYECTO=" + id + " GROUP BY ID_PROYECTO";
        try {
            ps = con.prepareStatement(query);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                ProyectoMaOBean proymd = new ProyectoMaOBean();
                proymd.setIdProyecto(rs.getInt("ID_PROYECTO"));
                proymd.setSubTotalMao(rs.getFloat("SUBTOTAL"));
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

    public static List<ProyectoBean> obtenerProyecto(int id) {
        List<ProyectoBean> lista = new ArrayList<>();
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "Select ID_PROYECTO, NOMBRE_PROYECTO, NUM_ORD_COMP, REQUISICION, FECHA_INICIO, PRESUPUESTO, "
                + "INCURRIDO, DISPONIBLE, UTILIDAD, IVA, TOTAL from Proyecto where id_proyecto=" + id;
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
                proyecto.setIncurridoProyecto(rs.getFloat("INCURRIDO"));
                proyecto.setDispProyecto(rs.getFloat("DISPONIBLE"));
                proyecto.setUtilidadProyecto(rs.getFloat("UTILIDAD"));
                proyecto.setIvaProyecto(rs.getFloat("IVA"));
                proyecto.setTotalproyecto(rs.getFloat("TOTAL"));
                lista.add(proyecto);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lista;
    }

    public static List<ProyectoMDBean> obtenerDirectos(int id) {
        List<ProyectoMDBean> lista = new ArrayList<>();
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "Select id_proyecto, id_mat_directo, fecha_fact, proveedor, num_fact, descripcion, subtotal, iva, total from proyecto_mat_directo where id_proyecto=" + id;

        try {
            ps = con.prepareStatement(query);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                ProyectoMDBean directo = new ProyectoMDBean();
                directo.setIdProyecto(rs.getInt("id_proyecto"));
                directo.setIdMatDirect(rs.getInt("id_mat_directo"));
                directo.setFechaFactMatDirect(rs.getString("FECHA_FACT"));
                directo.setPreveedorMatDirect(rs.getString("PROVEEDOR"));
                directo.setNumFactMatDirect(rs.getString("NUM_FACT"));
                directo.setDescripMatDirect(rs.getString("DESCRIPCION"));
                directo.setSubtMatDirect(rs.getFloat("SUBTOTAL"));
                directo.setIvaMatDirect(rs.getFloat("IVA"));
                directo.setTotalMatDirect(rs.getFloat("TOTAL"));
                lista.add(directo);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lista;
    }
    
    public static List<ProyectoMIBean> obtenerIndirectos(int id) {
        List<ProyectoMIBean> lista = new ArrayList<>();
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "Select id_proyecto, id_mat_indirect, fecha_fact, proveedor, num_fact, descripcion, subtotal, iva, total from proyecto_mat_indirect where id_proyecto=" + id;

        try {
            ps = con.prepareStatement(query);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                ProyectoMIBean directo = new ProyectoMIBean();
                directo.setIdProyecto(rs.getInt("id_proyecto"));
                directo.setIdMatIn(rs.getInt("id_mat_indirect"));
                directo.setFechaFactMatIn(rs.getString("FECHA_FACT"));
                directo.setPreveedorMatIn(rs.getString("PROVEEDOR"));
                directo.setNumFactMatIn(rs.getString("NUM_FACT"));
                directo.setDescripMatIn(rs.getString("DESCRIPCION"));
                directo.setSubtMatIn(rs.getFloat("SUBTOTAL"));
                directo.setIvaMatIn(rs.getFloat("IVA"));
                directo.setTotalMatIn(rs.getFloat("TOTAL"));
                lista.add(directo);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lista;
    }
    
    public static List<ProyectoMCBean> obtenerConsumo(int id) {
        List<ProyectoMCBean> lista = new ArrayList<>();
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "Select id_proyecto, id_mat_consumo, fecha_fact, proveedor, num_fact, descripcion, subtotal, iva, total from proyecto_mat_consumo where id_proyecto=" + id;

        try {
            ps = con.prepareStatement(query);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                ProyectoMCBean directo = new ProyectoMCBean();
                directo.setIdProyecto(rs.getInt("id_proyecto"));
                directo.setIdMatCon(rs.getInt("id_mat_consumo"));
                directo.setFechaFactMatCon(rs.getString("FECHA_FACT"));
                directo.setPreveedorMatCon(rs.getString("PROVEEDOR"));
                directo.setNumFactMatCon(rs.getString("NUM_FACT"));
                directo.setDescripMatCon(rs.getString("DESCRIPCION"));
                directo.setSubtMatCon(rs.getFloat("SUBTOTAL"));
                directo.setIvaMatCon(rs.getFloat("IVA"));
                directo.setTotalMatCon(rs.getFloat("TOTAL"));
                lista.add(directo);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lista;
    }
    
    public static List<ProyectoMaOBean> obtenerManoObra(int id) {
        List<ProyectoMaOBean> lista = new ArrayList<>();
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "Select id_proyecto, id_mano_obra, descripcion, subtotal from proyecto_mano_obra where id_proyecto=" + id;

        try {
            ps = con.prepareStatement(query);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                ProyectoMaOBean directo = new ProyectoMaOBean();
                directo.setIdProyecto(rs.getInt("id_proyecto"));
                directo.setIdMaO(rs.getInt("id_mano_obra"));
                directo.setDescMaO(rs.getString("DESCRIPCION"));
                directo.setSubtMaO(rs.getFloat("SUBTOTAL"));
                lista.add(directo);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lista;
    }
    
    public static int eliminarProyecto(int id){
        int status = 0;
        Connection cn = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "delete from proyecto where id_proyecto=?";
        try {
            ps = cn.prepareStatement(query);
            ps.setObject(1, id);
            status = ps.executeUpdate();
            System.out.println("Eliminado Proyecto con ID: "+id);
            cn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status; 
    }
    
    public static int eliminarDirecto(int id, int idProy, ProyectoBean proy){
        int status = 0;
        Connection cn = Conexion.getConnetion();
        PreparedStatement ps;
        PreparedStatement ps2;
        String query = "delete from proyecto_mat_directo where id_mat_directo=?";
        String query2 = "update proyecto set INCURRIDO=?, DISPONIBLE=?, UTILIDAD=? where id_proyecto="+idProy;
        try {
            ps = cn.prepareStatement(query);
            ps.setObject(1, id);
            status = ps.executeUpdate();
            System.out.println("Eliminado Proyecto con ID: "+id);
            
            ps2 = cn.prepareStatement(query2);
            ps2.setObject(1, proy.getIncurridoProyecto());
            ps2.setObject(2, proy.getDispProyecto());
            ps2.setObject(3, proy.getUtilidadProyecto());
            status = ps2.executeUpdate();
            System.out.println("Proyecto Actualizado");

            cn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }
    
    public static int eliminarIndirecto(int id, int idProy, ProyectoBean proy){
        int status = 0;
        Connection cn = Conexion.getConnetion();
        PreparedStatement ps;
        PreparedStatement ps2;
        String query = "delete from proyecto_mat_indirect where id_mat_indirect=?";
        String query2 = "update proyecto set INCURRIDO=?, DISPONIBLE=?, UTILIDAD=? where id_proyecto="+idProy;
        try {
            ps = cn.prepareStatement(query);
            ps.setObject(1, id);
            status = ps.executeUpdate();
            System.out.println("Eliminado Proyecto con ID: "+id);
            
            ps2 = cn.prepareStatement(query2);
            ps2.setObject(1, proy.getIncurridoProyecto());
            ps2.setObject(2, proy.getDispProyecto());
            ps2.setObject(3, proy.getUtilidadProyecto());
            status = ps2.executeUpdate();
            System.out.println("Proyecto Actualizado");

            cn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }
    
    public static int eliminarConsumo(int id, int idProy, ProyectoBean proy){
        int status = 0;
        Connection cn = Conexion.getConnetion();
        PreparedStatement ps;
        PreparedStatement ps2;
        String query = "delete from proyecto_mat_consumo where id_mat_consumo=?";
        String query2 = "update proyecto set INCURRIDO=?, DISPONIBLE=?, UTILIDAD=? where id_proyecto="+idProy;
        try {
            ps = cn.prepareStatement(query);
            ps.setObject(1, id);
            status = ps.executeUpdate();
            System.out.println("Eliminado Proyecto con ID: "+id);
            
            ps2 = cn.prepareStatement(query2);
            ps2.setObject(1, proy.getIncurridoProyecto());
            ps2.setObject(2, proy.getDispProyecto());
            ps2.setObject(3, proy.getUtilidadProyecto());
            status = ps2.executeUpdate();
            System.out.println("Proyecto Actualizado");

            cn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }
    
    public static int eliminarManoObra(int id, int idProy, ProyectoBean proy){
        int status = 0;
        Connection cn = Conexion.getConnetion();
        PreparedStatement ps;
        PreparedStatement ps2;
        String query = "delete from proyecto_mano_obra where id_mano_obra=?";
        String query2 = "update proyecto set INCURRIDO=?, DISPONIBLE=?, UTILIDAD=? where id_proyecto="+idProy;
        try {
            ps = cn.prepareStatement(query);
            ps.setObject(1, id);
            status = ps.executeUpdate();
            System.out.println("Eliminado Proyecto con ID: "+id);
            
            ps2 = cn.prepareStatement(query2);
            ps2.setObject(1, proy.getIncurridoProyecto());
            ps2.setObject(2, proy.getDispProyecto());
            ps2.setObject(3, proy.getUtilidadProyecto());
            status = ps2.executeUpdate();
            System.out.println("Proyecto Actualizado");

            cn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }
}
