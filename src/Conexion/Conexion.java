/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;

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
    
    public Conexion(){
        
    }
}
