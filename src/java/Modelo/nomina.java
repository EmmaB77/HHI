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

    public static void calcularNom(NominaBean nomina) {
        int status = 0;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "insert into nomina (id_empleado, semana, viernes, lunes, martes, miercoles, jueves, horas_extra, hrs_total, total)"
                + " values(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(query);
            ps.setObject(1, nomina.getEmpleadoNom().getIdEmpleado());
            ps.setObject(2, nomina.getSemanaNom());
            ps.setObject(3, nomina.getHrsViernes());
            ps.setObject(4, nomina.getHrsLunes());
            ps.setObject(5, nomina.getHrsMartes());
            ps.setObject(6, nomina.getHrsJueves());
            ps.setObject(7, nomina.getHrsExtra());
            ps.setObject(8, nomina.getHrsTotales());
            ps.setObject(9, nomina.getSalarioT());
            status = ps.executeUpdate();
            System.out.println("Exito en el registro");
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static int descontarNom(int idNom, String dia, float horas) {
        int status = 0;
        float nvSal = 0;
        float viernes = 0;
        float lunes = 0;
        float martes = 0;
        float miercoles = 0;
        float jueves = 0;
        float horasEx = 0;
        float totales;
        float salarioT;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query1 = "select lunes, martes, miercoles, jueves, horas_extra, hrstotales, salarioT from nomina where idNom= " + idNom + ";";
        
        try {
            ps = con.prepareStatement(query1);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                viernes = rs.getFloat("viernes");
                lunes = rs.getFloat("lunes");
                martes = rs.getFloat("martes");
                miercoles = rs.getFloat("miercoles");
                jueves = rs.getFloat("jueves");
                horasEx = rs.getFloat("horas_extra");
                totales = rs.getFloat("hrstotales");
                salarioT = rs.getFloat("salarioT");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        switch (dia) {
            case "Lunes":
                try {
                    lunes = lunes - horas;
                    totales = lunes+martes+miercoles+jueves+viernes+horasEx;
                    
                    String query = "update nomina set lunes= " + lunes + ", salario=" + nvSal + ", hrstotales= "+totales+"where idNom=" + idNom;
                    ps = con.prepareStatement(query);
                    ps.executeUpdate();
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
                break;
            case "Martes":
                try {
                    String query = "update nomina set martes= " + horas + " salario=" + nvSal + " where idNom=" + idNom;
                    ps = con.prepareStatement(query);
                    ps.executeUpdate();
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
                break;
            case "Miercoles":
                try {
                    String query = "update nomina set miercoles= " + horas + " salario=" + nvSal + " where idNom=" + idNom;
                    ps = con.prepareStatement(query);
                    ps.executeUpdate();
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
                break;
            case "Jueves":
                try {
                    String query = "update nomina set jueves= " + horas + " salario=" + nvSal + " where idNom=" + idNom;
                    ps = con.prepareStatement(query);
                    ps.executeUpdate();
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
                break;
            case "Viernes":
                try {
                    String query = "update nomina set viernes= " + horas + " salario=" + nvSal + " where idNom=" + idNom;
                    ps = con.prepareStatement(query);
                    ps.executeUpdate();
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
                break;
            default:
                try {
                    String query = "update nomina set horas_extra= " + horas + " salario=" + nvSal + " where idNom=" + idNom;
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
        String query = "select nomina.idNom, persona.nombre, nomina.semana, nomina.viernes, nomina.lunes, nomina.martes, nomina.miercoles, nomina.jueves, nomina.horas_extra \n"
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
                nomina.setHrsLunes(rs.getFloat("lunes"));
                nomina.setHrsMartes(rs.getFloat("martes"));
                nomina.setHrsMiercoles(rs.getFloat("miercoles"));
                nomina.setHrsJueves(rs.getFloat("jueves"));
                nomina.setHrsExtra(rs.getFloat("horas_extra"));
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
        float salario = 0;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "select salarioxdia from empleado where id_empleado=" + idEmp + ";";
        try {
            ps = con.prepareStatement(query);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                salario = rs.getFloat("salarioxdia");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return salario;
    }

    public static float obtenerSalarioT(int idNom) {
        float salario = 0;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "select salariot from nomina where idNom=" + idNom + ";";
        try {
            ps = con.prepareStatement(query);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                salario = rs.getFloat("salariot");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return salario;
    }

    public static int descontar() {
        int status = 0;

        return status;
    }

}
