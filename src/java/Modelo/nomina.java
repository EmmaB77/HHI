package Modelo;

import Beans.NominaBean;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class nomina {

    public static int calcularNom(NominaBean nomina) {
        int status = 0;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "insert into nomina (id_empleado, semana, viernes, sabado, domingo, lunes, martes, miercoles, jueves, hrs_total, total)"
                + " values(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(query);
            ps.setObject(1, nomina.getEmpleadoNom().getIdEmpleado());
            ps.setObject(2, nomina.getSemanaNom());
            ps.setObject(3, nomina.getHrsViernes());
            ps.setObject(4, nomina.getHrsSabado());
            ps.setObject(5, nomina.getHrsDomingo());
            ps.setObject(6, nomina.getHrsLunes());
            ps.setObject(7, nomina.getHrsMartes());
            ps.setObject(8, nomina.getHrsJueves());
            ps.setObject(9, nomina.getHrsTotales());
            ps.setObject(10, nomina.getSalarioT());
            status = ps.executeUpdate();
            System.out.println("Exito en el registro");
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }

    public static int descontarNom(int idNom, String dia, float horas, float nvSal) {
        int status = 0;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;

        switch (dia) {
            case "Lunes":
                try {
                    String query = "update nomina set lunes= " + horas + " salario=" + nvSal + " where idEmp=" + idNom;
                    ps = con.prepareStatement(query);
                    ps.executeUpdate();
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
                break;
            case "Martes":
                try {
                    String query = "update nomina set martes= " + horas + " salario=" + nvSal + " where idEmp=" + idNom;
                    ps = con.prepareStatement(query);
                    ps.executeUpdate();
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
                break;
            case "Miercoles":
                try {
                    String query = "update nomina set miercoles= " + horas + " salario=" + nvSal + " where idEmp=" + idNom;
                    ps = con.prepareStatement(query);
                    ps.executeUpdate();
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
                break;
            case "Jueves":
                try {
                    String query = "update nomina set jueves= " + horas + " salario=" + nvSal + " where idEmp=" + idNom;
                    ps = con.prepareStatement(query);
                    ps.executeUpdate();
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
                break;
            case "Viernes":
                try {
                    String query = "update nomina set viernes= " + horas + " salario=" + nvSal + " where idEmp=" + idNom;
                    ps = con.prepareStatement(query);
                    ps.executeUpdate();
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
                break;
            case "Sabado":
                try {
                    String query = "update nomina set sabado= " + horas + " salario=" + nvSal + " where idEmp=" + idNom;
                    ps = con.prepareStatement(query);
                    ps.executeUpdate();
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
                break;
            default:
                try {
                    String query = "update nomina set domingo= " + horas + " salario=" + nvSal + " where idEmp=" + idNom;
                    ps = con.prepareStatement(query);
                    ps.executeUpdate();
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
                break;
        }
        return status;
    }

    public static List<NominaBean> listaNom() {
        List<NominaBean> lista = new ArrayList<>();
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "select nomina.idNom, persona.nombre, nomina.semana, nomina.viernes, nomina.sabado, nomina.domingo, nomina.lunes, nomina.martes, nomina.miercoles, nomina.jueves, \n"
                + "nomina.hrstotales, nomina.salarioT from nomina inner join empleado on nomina.id_empleado = empleado.id_empleado inner join persona on empleado.id_persona=persona.id_persona;";
        try {
            ps = con.prepareStatement(query);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                NominaBean nomina = new NominaBean();
                nomina.setIdNom(rs.getInt("idNom"));
                nomina.setId_empleado(rs.getInt("id_empleado"));
                nomina.setHrsViernes(rs.getFloat("viernes"));
                nomina.setHrsSabado(rs.getFloat("sabado"));
                nomina.setHrsDomingo(rs.getFloat("domingo"));
                nomina.setHrsLunes(rs.getFloat("lunes"));
                nomina.setHrsMartes(rs.getFloat("martes"));
                nomina.setHrsMiercoles(rs.getFloat("miercoles"));
                nomina.setHrsJueves(rs.getFloat("jueves"));
                nomina.setHrsTotales(rs.getFloat("hrstotales"));
                nomina.setSalarioT(rs.getFloat("salarioT"));
                lista.add(nomina);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lista;
    }

    public static float obtenerSalario(int idEmp) {
        float salario=0;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "select salarioxdia from empleado where id_empleado=" + idEmp + ";";
        try {
            ps = con.prepareStatement(query);
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                salario = rs.getFloat("salarioxdia");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return salario;
    }
    
    public static float obtenerSalarioT(int idNom){
         float salario=0;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "select salariot from nomina where idNom=" + idNom + ";";
        try {
            ps = con.prepareStatement(query);
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                salario = rs.getFloat("salariot");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return salario;
    }

}
