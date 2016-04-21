package Modelo;

import Beans.PersonaBean;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        String query = "INSERT INTO PERSONA(NOMBRE, APELLIDOP, APELLIDOM, CALLE, NUM, COL, CIUDAD, ESTADO, TELEFONO, NUM_SEGURO, CURP, RFC, FECHA_INGRESO, STATUS) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
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
            ps.setObject(13, persona.getFechaIngreso());
            ps.setObject(14, persona.getEstatusPersona());
            status = ps.executeUpdate();
            System.out.println("Exito en el registro");
            System.out.println("Agregado: " + persona.getNombrePersona() + " " + persona.getApellidoPpersona() + " " + persona.getApellidoMpersona());
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }

    public static int modificarPersona(PersonaBean persona) {
        int status = 0;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "UPDATE PERSONA set NOMBRE=?, APELLIDOP=?, APELLIDOM=?, CALLE=?, NUM=?, COL=?, CIUDAD=?, ESTADO=?, TELEFONO=?, NUM_SEGURO=?, CURP=?, RFC=?, FECHA_INGRESO=? where id_Persona=?";
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
            ps.setObject(13, persona.getFechaIngreso());
            ps.setObject(14, persona.getIdPersona());
            status = ps.executeUpdate();
            System.out.println("Exito en el registro");
            System.out.println("Actualizado: " + persona.getNombrePersona() + " " + persona.getApellidoPpersona() + " " + persona.getApellidoMpersona());
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }

    public static List<PersonaBean> listarPersonasSinDefinir() {
        Connection con = Conexion.getConnetion();
        List<PersonaBean> list = new ArrayList();
        PreparedStatement ps;
        String query = "select id_persona, nombre, apellidoP, apellidoM, calle, num, col, ciudad, estado, telefono, rfc, curp, num_seguro, fecha_ingreso from persona where status='SIN DEFINIR'";
        try {
            ps = con.prepareStatement(query);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                PersonaBean persona = new PersonaBean();
                persona.setIdPersona(res.getInt("id_persona"));
                persona.setNombrePersona(res.getString("nombre"));
                persona.setApellidoPpersona(res.getString("apellidop"));
                persona.setApellidoMpersona(res.getString("apellidom"));
                persona.setCallePersona(res.getString("calle"));
                persona.setNumeroPersona(res.getString("num"));
                persona.setColoniaPersona(res.getString("col"));
                persona.setCiudadPersona(res.getString("ciudad"));
                persona.setEstadoPersona(res.getString("estado"));
                persona.setTelefonoPersona(res.getString("telefono"));
                persona.setRfcPersona(res.getString("rfc"));
                persona.setCurpPersona(res.getString("curp"));
                persona.setNumSeguroPersona(res.getString("num_seguro"));
                persona.setFechaIngreso(res.getString("fecha_ingreso"));
                list.add(persona);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public static List<PersonaBean> listarPersonas() {
        Connection con = Conexion.getConnetion();
        List<PersonaBean> list = new ArrayList();
        PreparedStatement ps;
        String query = "select id_persona, nombre, apellidoP, apellidoM, calle, num, col, ciudad, estado, telefono, rfc, curp, num_seguro, fecha_ingreso, status from persona";
        try {
            ps = con.prepareStatement(query);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                PersonaBean persona = new PersonaBean();
                persona.setIdPersona(res.getInt("id_persona"));
                persona.setNombrePersona(res.getString("nombre"));
                persona.setApellidoPpersona(res.getString("apellidop"));
                persona.setApellidoMpersona(res.getString("apellidom"));
                persona.setCallePersona(res.getString("calle"));
                persona.setNumeroPersona(res.getString("num"));
                persona.setColoniaPersona(res.getString("col"));
                persona.setCiudadPersona(res.getString("ciudad"));
                persona.setEstadoPersona(res.getString("estado"));
                persona.setTelefonoPersona(res.getString("telefono"));
                persona.setRfcPersona(res.getString("rfc"));
                persona.setCurpPersona(res.getString("curp"));
                persona.setNumSeguroPersona(res.getString("num_seguro"));
                persona.setFechaIngreso(res.getString("fecha_ingreso"));
                persona.setEstatusPersona(res.getString("status"));
                list.add(persona);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public static int eliminarPersona(int id) {
        int status = 0;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "delete from persona where id_persona=?";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }

    public static int definirUsuario(PersonaBean persona) {
        int status = 0;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        PreparedStatement ps2;
        String query = "insert into usuario(id_persona) values(?)";
        String query2 = "Update persona set status=? where id_persona=?";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, persona.getIdPersona());
            ps.executeUpdate();
            ps2 = con.prepareStatement(query2);
            ps2.setObject(1, persona.getEstatusPersona());
            ps2.setObject(2, persona.getIdPersona());
            status = ps2.executeUpdate();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }

}
