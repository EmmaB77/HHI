package Modelo;

import Beans.EmpleadoBean;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Empleado {
    public static EmpleadoBean obtenerEmpleado(int id){
        EmpleadoBean empleado= new EmpleadoBean();
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query="select id_empleado, id_persona from empleado where id_empleado=?";
        try{
            ps=con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet res= ps.executeQuery();
            while(res.next()){
                empleado.setIdEmpleado(res.getInt("Id_empleado"));
                empleado.setIdPersona(res.getInt("id_persona"));
                empleado.setPersona(Persona.obtenerPersona(empleado.getIdPersona()));
            }
            con.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return empleado;
    }
    
    public static List<EmpleadoBean> listarEmpleados(){
        Connection con=Conexion.getConnetion();
        List<EmpleadoBean> list=new ArrayList();
        PreparedStatement ps;
        String query="select id_empleado, id_persona from empleado";
        try{
            ps=con.prepareStatement(query);
            ResultSet res= ps.executeQuery();
            while(res.next()){
                EmpleadoBean empleado= new EmpleadoBean();
                empleado.setIdEmpleado(res.getInt("id_empleado"));
                empleado.setIdPersona(res.getInt("id_persona"));
                empleado.setPersona(Persona.obtenerPersona(empleado.getIdPersona()));
                list.add(empleado);
            }
            con.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
}
