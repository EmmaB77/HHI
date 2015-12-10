package Modelo;

import Beans.UserSystBean;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSystem {

    public static boolean validarUsuario(String usuario, String password) {
        if (existeUsuario(usuario) && existePassword(password)) {
            return true;
        }
        return false;
    }

    private static boolean existeUsuario(String usuario) {
        boolean existe = false;
        PreparedStatement ps;
        String query = "select count(iduser) as usuarios from usersyst where usuario=?";
        try {
            Connection con = Conexion.getConnetion();
            ps = con.prepareStatement(query);
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getInt("usuarios") > 0) {
                    existe = true;
                }
            }
            System.out.println(existe);
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return existe;
    }

    private static boolean existePassword(String password) {
        boolean existe = false;
        PreparedStatement ps;
        String query = "select count(iduser) as usuarios from usersyst where password=?";
        try {
            Connection con = Conexion.getConnetion();
            ps = con.prepareStatement(query);
            ps.setString(1, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getInt("usuarios") > 0) {
                    existe = true;
                }
            }
            System.out.println(existe);
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return existe;
    }

    public static UserSystBean obtenerUsuario(int idUsuario) {
        UserSystBean usuario = new UserSystBean();
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "select iduser, usuario, password from usersyst where iduser=?";
        try {
            ps = con.prepareStatement(query);
            ps.setObject(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                usuario.setUserSystId(rs.getInt("iduser"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setPassword(rs.getString("password"));
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return usuario;
    }

    public static UserSystBean obtenerUsuario(String user, String password) {
        UserSystBean usuario = new UserSystBean();
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "select iduser, usuario, password from usersyst where usuario=? and password=?";
        try {
            ps = con.prepareStatement(query);
            ps.setObject(1, user);
            ps.setObject(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                usuario.setUserSystId(rs.getInt("iduser"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setPassword(rs.getString("password"));
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return usuario;
    }

    public static int obtenerIdPersona(String usuario, String password) {
        int idPersona = 0;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "select iduser, id_persona, usuario, password from usersyst where usuario=? and password=?";
        try {
            ps = con.prepareStatement(query);
            ps.setObject(1, usuario);
            ps.setObject(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idPersona = rs.getInt("id_persona");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return idPersona;
    }

}
