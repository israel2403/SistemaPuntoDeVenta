/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author isra
 */
public class Conexion {

    private String db = "punto_de_ventas";
    private String user = "root";
    private String password = "240395";
    private String urlMysql = "jdbc:mysql://localhost/" + db + "?SslMode=none";
    private Connection conn = null;

    public Conexion() {
        try {
            // obtenemos el driver para mysql
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(this.urlMysql, this.user, this.password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error : " + ex);
        }
    }

    public Connection getConn() {
        return conn;
    }
}
