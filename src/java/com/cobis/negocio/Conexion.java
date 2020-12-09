package com.cobis.negocio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static Connection Conectar() {

        Connection connection = null;
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=PruebaCobis";
            String user = "root";
            String password = "root";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Error de conexion a base de datos");
        }
        return connection;
    }
}
