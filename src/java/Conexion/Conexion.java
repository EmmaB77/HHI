package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    static String DRIVER = "org.postgresql.Driver";
    static String CONNECTION_URL = "jdbc:postgresql://localhost:5432/hhi";
    static String USERNAME = "hhiadmin";
    static String PASSWORD = "444hhi";
    static Connection cn = null;

    public static Connection getConnetion() {
        try {
            Class.forName(DRIVER);
            cn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return cn;
    }

    public static Connection closeConection() {
        try {
            Class.forName(DRIVER);
            cn.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return cn;
    }
}
