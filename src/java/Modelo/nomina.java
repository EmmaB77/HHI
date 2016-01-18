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
        String query = "insert into nomina (ID_EMPLEADO, SEMANA, VIERNES, LUNES, MARTES, MIERCOLES, JUEVES, HORAS_EXTRA, HRSTOTALES, SOBRESUELDO, VIATICOS, OTROS_INGRESOS, INFONAVIT, OTROS_DEDUCCIONES, SUELDO_NORMAL, SUELDO_EXTRA, TOTAL_INGRESOS,\n"
                + " TOTAL_DEDUCCIONES, SUELDOT, FECHA_CREACION) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,current_date)";
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
            ps.setObject(10, nomina.getSobresueldo());
            ps.setObject(11, nomina.getViaticos());
            ps.setObject(12, nomina.getOtros_ingresos());
            ps.setObject(13, nomina.getInfonavit());
            ps.setObject(14, nomina.getOtros_deducciones());
            ps.setObject(15, nomina.getSueldo_N());
            ps.setObject(16, nomina.getSueldoEx());
            ps.setObject(17, nomina.getTotal_ingresos());
            ps.setObject(18, nomina.getTotal_deducciones());
            ps.setObject(19, nomina.getSueldoT());
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
        float hrstotales;
        float totalSemana;
        float sobreS = 0;
        float viaticos = 0;
        float otrosI = 0;
        float info = 0;
        float otrasD = 0;
        float sueldoN = 0;
        float totalI;
        float totalD;
        float salarioSemana;
        float salarioExtra;
        float salarioT;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query1 = "select VIERNES, LUNES, MARTES, MIERCOLES, JUEVES, HORAS_EXTRA, HRSTOTALES, SOBRESUELDO, VIATICOS, OTROS_INGRESOS, INFONAVIT, OTROS_DEDUCCIONES, SUELDO_NORMAL, TOTAL_INGRESOS,\n"
                + " TOTAL_DEDUCCIONES, SUELDOT from nomina where idNom= " + idNom + ";";

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
                hrstotales = rs.getFloat("hrstotales");
                sobreS = rs.getFloat("sobresueldo");
                viaticos = rs.getFloat("viaticos");
                otrosI = rs.getFloat("otros_ingresos");
                info = rs.getFloat("infonavit");
                otrasD = rs.getFloat("otros_deducciones");
                sueldoN = rs.getFloat("sueldo_Normal");
                totalI = rs.getFloat("total_ingresos");
                totalD = rs.getFloat("total_deducciones");
                salarioT = rs.getFloat("sueldot");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        switch (dia) {
            case "Lunes":
                try {
                    lunes = lunes - horas;
                    hrstotales = lunes + martes + miercoles + jueves + viernes + horasEx;
                    totalSemana = hrstotales - horasEx;

                    salarioSemana = totalSemana * obtenerSalario(idEmp);
                    salarioExtra = horasEx * obtenerSalario(idEmp) * 2;

                    sueldoN = salarioSemana + salarioExtra;

                    totalI = otrosI + sueldoN + sobreS + viaticos;
                    totalD = info + otrasD;

                    nvSal = totalI - totalD;

                    String query = "update nomina set lunes= " + lunes + ", sueldo_extra=" + salarioExtra + ", sueldo_normal=" + salarioSemana + ", total_ingresos=" + totalI + ", total_deducciones=" + totalD + ", sueldot=" + nvSal + ", hrstotales= " + hrstotales + " where idNom=" + idNom;
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
                    hrstotales = lunes + martes + miercoles + jueves + viernes + horasEx;
                    totalSemana = hrstotales - horasEx;
                    salarioSemana = totalSemana * obtenerSalario(idEmp);
                    salarioExtra = horasEx * obtenerSalario(idEmp) * 2;
                    sueldoN = salarioSemana + salarioExtra;

                    totalI = otrosI + sueldoN + sobreS + viaticos;
                    totalD = info + otrasD;

                    nvSal = totalI - totalD;
                    String query = "update nomina set martes= " + martes + ", sueldo_extra=" + salarioExtra + ", sueldo_normal=" + salarioSemana + ", total_ingresos=" + totalI + ", total_deducciones=" + totalD + ", sueldot=" + nvSal + ", hrstotales= " + hrstotales + " where idNom=" + idNom;
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
                    hrstotales = lunes + martes + miercoles + jueves + viernes + horasEx;
                    totalSemana = hrstotales - horasEx;
                    salarioSemana = totalSemana * obtenerSalario(idEmp);
                    salarioExtra = horasEx * obtenerSalario(idEmp) * 2;
                    sueldoN = salarioSemana + salarioExtra;

                    totalI = otrosI + sueldoN + sobreS + viaticos;
                    totalD = info + otrasD;

                    nvSal = totalI - totalD;
                    String query = "update nomina set miercoles= " + miercoles + ", sueldo_extra=" + salarioExtra + ", sueldo_normal=" + salarioSemana + ", total_ingresos=" + totalI + ", total_deducciones=" + totalD + ", sueldot=" + nvSal + ", hrstotales= " + hrstotales + " where idNom=" + idNom;
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
                    hrstotales = lunes + martes + miercoles + jueves + viernes + horasEx;
                    totalSemana = hrstotales - horasEx;
                    salarioSemana = totalSemana * obtenerSalario(idEmp);
                    salarioExtra = horasEx * obtenerSalario(idEmp) * 2;
                    sueldoN = salarioSemana + salarioExtra;

                    totalI = otrosI + sueldoN + sobreS + viaticos;
                    totalD = info + otrasD;

                    nvSal = totalI - totalD;
                    String query = "update nomina set jueves= " + jueves + ", sueldo_extra=" + salarioExtra + ", sueldo_normal=" + salarioSemana + ", total_ingresos=" + totalI + ", total_deducciones=" + totalD + ", sueldot=" + nvSal + ", hrstotales= " + hrstotales + " where idNom=" + idNom;
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
                    hrstotales = lunes + martes + miercoles + jueves + viernes + horasEx;
                    totalSemana = hrstotales - horasEx;
                    salarioSemana = totalSemana * obtenerSalario(idEmp);
                    salarioExtra = horasEx * obtenerSalario(idEmp) * 2;
                    sueldoN = salarioSemana + salarioExtra;

                    totalI = otrosI + sueldoN + sobreS + viaticos;
                    totalD = info + otrasD;

                    nvSal = totalI - totalD;
                    String query = "update nomina set viernes= " + viernes + ", sueldo_extra=" + salarioExtra + ", sueldo_normal=" + salarioSemana + ", total_ingresos=" + totalI + ", total_deducciones=" + totalD + ", sueldot=" + nvSal + ", hrstotales= " + hrstotales + " where idNom=" + idNom;
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
                    hrstotales = lunes + martes + miercoles + jueves + viernes + horasEx;
                    totalSemana = hrstotales - horasEx;
                    salarioSemana = totalSemana * obtenerSalario(idEmp);
                    salarioExtra = horasEx * obtenerSalario(idEmp) * 2;
                    sueldoN = salarioSemana + salarioExtra;

                    totalI = otrosI + sueldoN + sobreS + viaticos;
                    totalD = info + otrasD;

                    nvSal = totalI - totalD;
                    String query = "update nomina set horas_extra= " + horasEx + ", sueldo_extra=" + salarioExtra + ", sueldo_normal=" + salarioSemana + ", total_ingresos=" + totalI + ", total_deducciones=" + totalD + ", sueldot=" + nvSal + ", hrstotales= " + hrstotales + " where idNom=" + idNom;
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

    public static List<NominaBean> listaNomxSem(String semana) {
        List<NominaBean> lista = new ArrayList<>();
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "Select idNom, ID_EMPLEADO, semana, VIERNES, LUNES, MARTES, MIERCOLES, JUEVES, HORAS_EXTRA, HRSTOTALES, SOBRESUELDO, VIATICOS, OTROS_INGRESOS, INFONAVIT, OTROS_DEDUCCIONES, SUELDO_NORMAL, SUELDO_EXTRA, TOTAL_INGRESOS,\n"
                + " TOTAL_DEDUCCIONES, SUELDOT, FECHA_CREACION from nomina where semana = '" + semana + "' ;";
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
                nomina.setSobresueldo(rs.getFloat("sobresueldo"));
                nomina.setViaticos(rs.getFloat("viaticos"));
                nomina.setOtros_ingresos(rs.getFloat("otros_ingresos"));
                nomina.setInfonavit(rs.getFloat("infonavit"));
                nomina.setOtros_deducciones(rs.getFloat("otros_deducciones"));
                nomina.setSueldo_N(rs.getFloat("sueldo_normal"));
                nomina.setSueldoEx(rs.getFloat("sueldo_extra"));
                nomina.setTotal_ingresos(rs.getFloat("total_ingresos"));
                nomina.setTotal_deducciones(rs.getFloat("total_deducciones"));
                nomina.setSueldoT(rs.getFloat("sueldoT"));
                nomina.setDate(rs.getString("FECHA_CREACION"));
                nomina.setEmpleado(Empleado.obtenerEmpleado(nomina.getId_empleado()));
                lista.add(nomina);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lista;
    }

    public static List<NominaBean> listaSemanas() {
        List<NominaBean> lista = new ArrayList<>();
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "Select semana from nomina group by semana";
        try {
            ps = con.prepareStatement(query);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                NominaBean nomina = new NominaBean();
                nomina.setSemanaNom(rs.getString("semana"));
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

    public static float obtenerDescInfonavit(int idEmp) {
        float infonavit = 0;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "select infonavit from empleado where id_empleado=" + idEmp + ";";
        try {
            ps = con.prepareStatement(query);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                infonavit = rs.getFloat("infonavit");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return infonavit;
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

}
