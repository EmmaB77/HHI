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
        String query = "insert into nomina (id_empleado, semana, viernes, lunes, martes, miercoles, jueves, horas_extra, hrstotales, sueldoT)"
                + " values(?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(query);
            ps.setObject(1, nomina.getId_empleado());
            ps.setObject(2, nomina.getSemanaNom());
            ps.setObject(3, nomina.getHrsViernes());
            ps.setObject(4, nomina.getHrsLunes());
            ps.setObject(5, nomina.getHrsMartes());
            ps.setObject(6, nomina.getHrsMiercoles());
            ps.setObject(7, nomina.getHrsJueves());
            ps.setObject(8, nomina.getHrsExtra());
            ps.setObject(9, nomina.getHrsTotales());
            ps.setObject(10, nomina.getSueldoT());
            status = ps.executeUpdate();
            System.out.println("Exito en el registro");
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static int descontarNom(int idNom, String dia, float horas, int idEmp) {
        int status = 0;
        float nvSal = 0;
        float viernes = 0;
        float lunes = 0;
        float martes = 0;
        float miercoles = 0;
        float jueves = 0;
        float horasEx = 0;
        float totales;
        float totalSemana;
        float salarioSemana;
        float salarioExtra;
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
                    totalSemana = totales-horasEx;
                    salarioSemana = totalSemana*obtenerSalario(idEmp);
                    salarioExtra = horasEx*obtenerSalario(idEmp)*2;
                    nvSal = salarioSemana + salarioExtra;
                    String query = "update nomina set lunes= " + lunes + ", salario=" + nvSal + ", hrstotales= "+totales+" where idNom=" + idNom;
                    ps = con.prepareStatement(query);
                    ps.executeUpdate();
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
                break;
            case "Martes":
                try {
                    martes = martes - horas;
                    totales = lunes+martes+miercoles+jueves+viernes+horasEx;
                    totalSemana = totales-horasEx;
                    salarioSemana = totalSemana*obtenerSalario(idEmp);
                    salarioExtra = horasEx*obtenerSalario(idEmp)*2;
                    nvSal = salarioSemana + salarioExtra;
                    String query = "update nomina set martes= " + martes + ", salario=" + nvSal + ", hrstotales= "+totales+" where idNom=" + idNom;
                    ps = con.prepareStatement(query);
                    ps.executeUpdate();
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
                break;
            case "Miercoles":
                try {
                    miercoles = miercoles - horas;
                    totales = lunes+martes+miercoles+jueves+viernes+horasEx;
                    totalSemana = totales-horasEx;
                    salarioSemana = totalSemana*obtenerSalario(idEmp);
                    salarioExtra = horasEx*obtenerSalario(idEmp)*2;
                    nvSal = salarioSemana + salarioExtra;
                    String query = "update nomina set miercoles= " + miercoles + ", salario=" + nvSal + ", hrstotales= "+totales+" where idNom=" + idNom;
                    ps = con.prepareStatement(query);
                    ps.executeUpdate();
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
                break;
            case "Jueves":
                try {
                    jueves = jueves - horas;
                    totales = lunes+martes+miercoles+jueves+viernes+horasEx;
                    totalSemana = totales-horasEx;
                    salarioSemana = totalSemana*obtenerSalario(idEmp);
                    salarioExtra = horasEx*obtenerSalario(idEmp)*2;
                    nvSal = salarioSemana + salarioExtra;
                    String query = "update nomina set jueves= " + jueves + ", salario=" + nvSal + ", hrstotales= "+totales+" where idNom=" + idNom;
                    ps = con.prepareStatement(query);
                    ps.executeUpdate();
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
                break;
            case "Viernes":
                try {
                    viernes = viernes - horas;
                    totales = lunes+martes+miercoles+jueves+viernes+horasEx;
                    totalSemana = totales-horasEx;
                    salarioSemana = totalSemana*obtenerSalario(idEmp);
                    salarioExtra = horasEx*obtenerSalario(idEmp)*2;
                    nvSal = salarioSemana + salarioExtra;
                    String query = "update nomina set viernes= " + viernes + ", salario=" + nvSal + ", hrstotales= "+totales+" where idNom=" + idNom;
                    ps = con.prepareStatement(query);
                    ps.executeUpdate();
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
                break;
            default:
                try {
                    horasEx = horasEx - horas;
                    totales = lunes+martes+miercoles+jueves+viernes+horasEx;
                    totalSemana = totales-horasEx;
                    salarioSemana = totalSemana*obtenerSalario(idEmp);
                    salarioExtra = horasEx*obtenerSalario(idEmp)*2;
                    nvSal = salarioSemana + salarioExtra;
                    String query = "update nomina set horas_extra= " + horasEx + ", salario=" + nvSal + ", hrstotales= "+totales+" where idNom=" + idNom;
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
        String query = "Select idNom, ID_EMPLEADO, semana, viernes, lunes, martes, miercoles, jueves, horas_extra, hrstotales, sueldoT from nomina";
        try {
            ps = con.prepareStatement(query);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                NominaBean nomina = new NominaBean();
                nomina.setIdNom(rs.getInt("idNom"));
                nomina.setId_empleado(rs.getInt("id_empleado"));
                nomina.setSemanaNom(rs.getString("semana"));
                nomina.setHrsViernes(rs.getFloat("viernes"));
                nomina.setHrsLunes(rs.getFloat("lunes"));
                nomina.setHrsMartes(rs.getFloat("martes"));
                nomina.setHrsMiercoles(rs.getFloat("miercoles"));
                nomina.setHrsJueves(rs.getFloat("jueves"));
                nomina.setHrsExtra(rs.getFloat("horas_extra"));
                nomina.setHrsTotales(rs.getFloat("hrstotales"));
                nomina.setSueldoT(rs.getFloat("sueldoT"));
                nomina.setEmpleado(Empleado.obtenerEmpleado(nomina.getId_empleado()));
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
        String query = "select sueldot from nomina where idNom=" + idNom + ";";
        try {
            ps = con.prepareStatement(query);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                salario = rs.getFloat("sueldot");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return salario;
    }

    public static int obtenerIdEmp(int idNom) {
        int id = 0;  
        return id;
    }
    
}
