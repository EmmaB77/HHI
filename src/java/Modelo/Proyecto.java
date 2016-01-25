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
