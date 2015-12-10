package Modelo;

import Beans.PersonaBean;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Persona {
  
    public static PersonaBean obtenerPersona(int id){
        PersonaBean persona = new PersonaBean();
        Connection con=Conexion.getConnetion();
        PreparedStatement ps;
        String query="select id_persona, nombre, apellidoP, apellidoM from persona where id_persona=?";
        try{
            ps=con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet res= ps.executeQuery();
            while(res.next()){
               persona.setIdPersona(res.getInt("id_persona"));
               persona.setNombrePersona(res.getString("nombre"));
               persona.setApellidoPpersona(res.getString("apellidoP"));
               persona.setApellidoMpersona(res.getString("apellidoM"));
            }
            con.close();
            System.out.println(persona.getNombrePersona()+" "+persona.getApellidoPpersona());
        }catch(SQLException e){
            System.out.println(e);
        }
        return persona;
    }
}
