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
    
    public static int agregarGasto(NominaBean nomina) {
        int status = 0;
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "insert into nomina (id_empleado, semana, viernes, sabado, domingo, lunes, martes, miercoles, jueves, hrs_total, total)"
                + " values(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(query);
            ps.setObject(1, gasto.getFechaIndirect());
            ps.setObject(2, gasto.getMesIndirect());
            ps.setObject(3, gasto.getProveeIndirect());
            ps.setObject(4, gasto.getNumFactIndirect());
            ps.setObject(5, gasto.getDescIndirect());
            ps.setObject(6, gasto.getSubToIndirect());
            ps.setObject(7, gasto.getIvaIndirect());
            ps.setObject(8, gasto.getTotalIndirect());
            status = ps.executeUpdate();
            System.out.println("Exito en el registro");
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }
    
}
