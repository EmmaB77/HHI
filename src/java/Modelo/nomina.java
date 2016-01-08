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

    public static int descontarNom(int idNom, String dia, float horas, float nuevoS) {
        int status = 0;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        switch (dia) {
            case "Lunes": {
                String query = "update nomina set lunes = " + horas + ", salarioT = "+ nuevoS +" where idNomina = " + idNom;
                try {
                    ps = con.prepareStatement(query);
                    status = ps.executeUpdate();
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
                break;
            }
            case "Martes": {
                String query = "update nomina set martes = " + horas + ", salarioT = "+ nuevoS +" where idNomina = " + idNom;
                try {
                    ps = con.prepareStatement(query);
                    status = ps.executeUpdate();
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
                break;
            }
            case "Miercoles": {
                String query = "update nomina set miercoles = " + horas + ", salarioT = "+ nuevoS +" where idNomina = " + idNom;
                try {
                    ps = con.prepareStatement(query);
                    status = ps.executeUpdate();
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
                break;
            }
            case "Jueves": {
                String query = "update nomina set jueves = " + horas + ", salarioT = "+ nuevoS +" where idNomina = " + idNom;
                try {
                    ps = con.prepareStatement(query);
                    status = ps.executeUpdate();
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
                break;
            }
            case "Viernes": {
                String query = "update nomina set viernes = " + horas + ", salarioT = "+ nuevoS +" where idNomina = " + idNom;
                try {
                    ps = con.prepareStatement(query);
                    status = ps.executeUpdate();
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
                break;
            }
            case "Sabado": {
                String query = "update nomina set sabado = " + horas + ", salarioT = "+ nuevoS +" where idNomina = " + idNom;
                try {
                    ps = con.prepareStatement(query);
                    status = ps.executeUpdate();
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
                break;
            }
            default: {
                String query = "update nomina set domingo = " + horas + ", salarioT = "+ nuevoS +" where idNomina = " + idNom;
                try {
                    ps = con.prepareStatement(query);
                    status = ps.executeUpdate();
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
                break;
            }
        }

        return status;
    }

}
