package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/gestion_clientes";
    private static final String USUARIO = "root";  // Cambia esto si tienes otro usuario
    private static final String PASSWORD = "1234";  // Pon la contraseña de tu MySQL si la tienes

    public static Connection getConexion() {
        try {
            return DriverManager.getConnection(URL, USUARIO, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error en la conexión a la base de datos");
        }
    }
}
