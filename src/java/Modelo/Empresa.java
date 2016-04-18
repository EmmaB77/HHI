/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Beans.EmpresaBean;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author windows
 */
public class Empresa {

    public static List<EmpresaBean> listarEmpresa() {
        Connection con = Conexion.getConnetion();
        List<EmpresaBean> list = new ArrayList();
        PreparedStatement ps;
        String query = "select id_empresa, nombre_empresa from empresa";
        try {
            ps = con.prepareStatement(query);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                EmpresaBean empleado = new EmpresaBean();
                empleado.setIdEmpresa(res.getInt("id_empresa"));
                empleado.setNombreEmpresa(res.getString("nombre_empresa"));
                list.add(empleado);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public static EmpresaBean obtenerEmpresa(int id) {
        EmpresaBean empresa = new EmpresaBean();
        Connection con = Conexion.getConnetion();
        PreparedStatement ps;
        String query = "select id_empresa, nombre_empresa from empresa where id_empresa=" + id;
        try {
            ps = con.prepareStatement(query);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                EmpresaBean empleado = new EmpresaBean();
                empleado.setIdEmpresa(res.getInt("id_empresa"));
                empleado.setNombreEmpresa(res.getString("nombre_empresa"));
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return empresa;
    }
}
