package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL =
            "jdbc:mysql://localhost:3306/proyecto_formas";

    private static final String USUARIO = "root";

    private static final String PASSWORD =
            System.getenv("MYSQL_PASSWORD");

    public Connection conectar() throws SQLException {
        if (PASSWORD == null || PASSWORD.isBlank()) {
            throw new SQLException(
                    "No se configuró la variable MYSQL_PASSWORD."
            );
        }

        return DriverManager.getConnection(
                URL,
                USUARIO,
                PASSWORD
        );
    }
}