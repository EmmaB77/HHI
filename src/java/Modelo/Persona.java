package Modelo;

import Beans.PersonaBean;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Persona {

    public static PersonaBean obtenerPersona(int id) {
        PersonaBean persona = new PersonaBean();
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "select id_persona, nombre, apellidoP, apellidoM from persona where id_persona=?";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                persona.setIdPersona(res.getInt("id_persona"));
                persona.setNombrePersona(res.getString("nombre"));
                persona.setApellidoPpersona(res.getString("apellidoP"));
                persona.setApellidoMpersona(res.getString("apellidoM"));
            }
            con.close();
            System.out.println(persona.getNombrePersona() + " " + persona.getApellidoPpersona());
        } catch (SQLException e) {
            System.out.println(e);
        }
        return persona;
    }

    public static int agregarPersona(PersonaBean persona) {
        int status = 0;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "INSERT INTO PERSONA(NOMBRE, APELLIDOP, APELLIDOM, CALLE, NUM, COL, CIUDAD, ESTADO, TELEFONO, NUM_SEGURO, CURP, RFC, FECHA_INGRESO) values(?,?,?,?,?,?,?,?,?,?,?,?,?);";
        try {
            ps = con.prepareStatement(query);
            ps.setObject(1, persona.getNombrePersona());
            ps.setObject(2, persona.getApellidoPpersona());
            ps.setObject(3, persona.getApellidoMpersona());
            ps.setObject(4, persona.getCallePersona());
            ps.setObject(5, persona.getNumeroPersona());
            ps.setObject(6, persona.getColoniaPersona());
            ps.setObject(7, persona.getCiudadPersona());
            ps.setObject(8, persona.getEstadoPersona());
            ps.setObject(9, persona.getTelefonoPersona());
            ps.setObject(10, persona.getNumSeguroPersona());
            ps.setObject(11, persona.getCurpPersona());
            ps.setObject(12, persona.getRfcPersona());
            ps.setObject(13, persona.getEstatusPersona());
            status = ps.executeUpdate();
            System.out.println("Exito en el registro");
            System.out.println("Agregado: "+persona.getNombrePersona()+" "+persona.getApellidoPpersona()+" "+persona.getApellidoMpersona());
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }
}
