package Modelo;
import Beans.UsuarioBean;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Solicitante {
    
    public static UsuarioBean obtenerUsuario(int id){
        UsuarioBean empleado= new UsuarioBean();
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query="select id_usuario, id_persona from usuario where id_usuario=?";
        try{
            ps=con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet res= ps.executeQuery();
            while(res.next()){
                empleado.setIdUsuario(res.getInt("Id_usuario"));
                empleado.setIdPersona(res.getInt("id_persona"));
                empleado.setPersona(Persona.obtenerPersona(empleado.getIdPersona()));
            }
            con.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return empleado;
    }
    
    public static List<UsuarioBean> listarUsuarios(){
        Connection con=Conexion.getConnetion();
        List<UsuarioBean> list=new ArrayList();
        PreparedStatement ps;
        String query="select id_usuario, id_persona from usuario";
        try{
            ps=con.prepareStatement(query);
            ResultSet res= ps.executeQuery();
            while(res.next()){
                UsuarioBean empleado= new UsuarioBean();
                empleado.setIdUsuario(res.getInt("id_usuario"));
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
