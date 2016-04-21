package Modelo;

import Beans.EmpleadoBean;
import Beans.PersonaBean;
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
        String query="select id_empleado, id_persona, salarioxdia, puesto, infonavit, cta_banco, TRANS_CTA_BANAMEX from empleado";
        try{
            ps=con.prepareStatement(query);
            ResultSet res= ps.executeQuery();
            while(res.next()){
                EmpleadoBean empleado= new EmpleadoBean();
                empleado.setIdEmpleado(res.getInt("id_empleado"));
                empleado.setIdPersona(res.getInt("id_persona"));
                empleado.setSalarioxdia(res.getFloat("salarioxdia"));
                empleado.setPuesto(res.getString("puesto"));
                empleado.setInfonavit(res.getFloat("infonavit"));
                empleado.setCuentaB(res.getString("cta_banco"));
                empleado.setTransa(res.getFloat("trans_cta_banamex"));
                empleado.setPersona(Persona.obtenerPersona(empleado.getIdPersona()));
                list.add(empleado);
            }
            con.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
    
    public static int definirEmpleado(PersonaBean persona, EmpleadoBean empleado){
        int status = 0;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        PreparedStatement ps2;
        String query ="insert into empleado(PUESTO,ID_PERSONA,SALARIOXDIA,INFONAVIT,CTA_BANCO,TRANS_CTA_BANAMEX) values (?,?,?,?,?,?)";
        String query2 = "Update persona set status=? where id_persona=?";
        try {
            ps = con.prepareStatement(query);
            ps.setObject(1, empleado.getPuesto());
            ps.setObject(2, empleado.getIdPersona());
            ps.setObject(3, empleado.getSalarioxdia());
            ps.setObject(4, empleado.getInfonavit());
            ps.setObject(5, empleado.getCuentaB());
            ps.setObject(6, empleado.getTransa());
            status = ps.executeUpdate();
            ps2 = con.prepareStatement(query2);
            ps2.setObject(1, persona.getEstatusPersona());
            ps2.setObject(2, persona.getIdPersona());
            status = ps2.executeUpdate();
            System.out.println("Exito en el registro");
            System.out.println("Agregado: Nuevo Empleado");
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }
    
    public static int modificarEmpleado(EmpleadoBean empleado){
        int status = 0;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query ="update empleado set PUESTO=?, SALARIOXDIA=?, INFONAVIT=?, CTA_BANCO=?, TRANS_CTA_BANAMEX=? where id_empleado=?";
        try {
            ps = con.prepareStatement(query);
            ps.setObject(1, empleado.getPuesto());
            ps.setObject(2, empleado.getSalarioxdia());
            ps.setObject(3, empleado.getInfonavit());
            ps.setObject(4, empleado.getCuentaB());
            ps.setObject(5, empleado.getTransa());
            ps.setObject(6, empleado.getIdEmpleado());
            status = ps.executeUpdate();
            System.out.println("Exito en el registro");
            System.out.println("Modificado Empleado: "+empleado.getIdEmpleado());
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }
}
