/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Beans.HerramientaBean;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Inventario {

    public static int agregarHerramienta(HerramientaBean tool) {
        int status = 0;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "insert into herramienta (descripcion, cantidad, tipo_unidad, observaciones, estatus)"
                + " values(?,?,?,?,?)";
        try {
            ps = con.prepareStatement(query);
            ps.setObject(1, tool.getDescHerramienta());
            ps.setObject(2, tool.getCantidadHerramienta());
            ps.setObject(3, tool.getTipoUniHerramienta());
            ps.setObject(4, tool.getObservacionesHerramienta());
            ps.setObject(5, tool.getEstatusHerramienta());
            status = ps.executeUpdate();
            System.out.println("Exito en el registro");
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }

    public static int eliminarTool(int idTool) {
        int status = 0;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "delete from herramienta where id_herramienta=?";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, idTool);
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }

    public static List<HerramientaBean> listaTools() {
        List<HerramientaBean> lista = new ArrayList<>();
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "select id_herramienta, descripcion, cantidad, tipo_unidad, observaciones, estatus from herramienta;";
        try {
            ps = con.prepareStatement(query);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                HerramientaBean tool = new HerramientaBean();
                tool.setIdHerramienta(rs.getInt("id_herramienta"));
                tool.setDescHerramienta(rs.getString("descripcion"));
                tool.setCantidadHerramienta(rs.getInt("cantidad"));
                tool.setTipoUniHerramienta(rs.getString("tipo_unidad"));
                tool.setObservacionesHerramienta(rs.getString("observaciones"));
                tool.setEstatusHerramienta(rs.getString("estatus"));
                lista.add(tool);
                System.out.println(tool.getIdHerramienta()+" "+tool.getCantidadHerramienta()+" "+tool.getTipoUniHerramienta());
            }con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lista;
    }
    
    public static int modificarTool(HerramientaBean tool){
        int status=0;
        Connection con= Conexion.getConnetion();
        PreparedStatement ps;
        String query="update herramienta set descripcion=?, cantidad=?, tipo_unidad=?, observaciones=?, estatus=?"
                + " where id_herramienta=?";
        try{
            ps=con.prepareStatement(query);
            ps.setObject(1, tool.getDescHerramienta());
            ps.setObject(2, tool.getCantidadHerramienta());
            ps.setObject(3, tool.getTipoUniHerramienta());
            ps.setObject(4, tool.getObservacionesHerramienta());
            ps.setObject(5, tool.getEstatusHerramienta());
            ps.setObject(6, tool.getIdHerramienta());
            status=ps.executeUpdate();
            con.close();
        } catch(SQLException e){
            System.out.println(e);
        }
        return status;
    }
}
