package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/users";
        String username = "root";
        String password = "602507qweASD";
        try (Connection connection = DriverManager.getConnection(url, username, password)){

        }
    }
}
