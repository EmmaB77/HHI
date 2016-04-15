package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Beans.ProyectoBean;

public class Proyecto {
    
    public static int agregarProyecto(ProyectoBean project){
        int status=0;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query="INSERT INTO PROYECTO(NOMBRE_PROYECTO, ID_EMPRESA, NUM_ORD_COMP, REQUISICION, FECHA_INICIO, PRESUPUESTO, DISPONIBLE, INCURRIDO, IVA, TOTAL) values(?,?,?,?,?,?,?,?,?,?);";
        try {
            ps = con.prepareStatement(query);
            ps.setObject(1, project.getNombreProyecto());
            ps.setObject(2, project.getIdEmpresa());
            ps.setObject(3, project.getOrdenComProyecto());
            ps.setObject(4, project.getRequiProyecto());
            ps.setObject(5, project.getFehaIProyecto());
            ps.setObject(6, project.getPresupuestoProyecto());
            ps.setObject(7, project.getDispProyecto());
            ps.setObject(8, project.getIncurridoProyecto());
            ps.setObject(9, project.getIvaProyecto());
            ps.setObject(10, project.getTotalproyecto());
            status = ps.executeUpdate();
            System.out.println("Exito en el registro");
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }
    
    public static List<ProyectoBean> listaProyectos() {
        List<ProyectoBean> lista = new ArrayList<>();
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "Select ID_PROYECTO, NOMBRE_PROYECTO from Proyecto";
        try {
            ps = con.prepareStatement(query);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                ProyectoBean proyecto = new ProyectoBean();
                proyecto.setIdProyecto(rs.getInt("id_proyecto"));
                proyecto.setNombreProyecto(rs.getString("nombre_proyecto"));
                lista.add(proyecto);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lista;
    }
    
}
