package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

//подключаемся и указываем sql запросы
public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Connection connection = Util.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS users" +
                    "(id BIGINT NOT NULL AUTO_INCREMENT, " +
                    "name VARCHAR(50) NOT NULL, " +
                    "lastname VARCHAR(50) NOT NULL, " +
                    "age TINYINT NOT NULL, " +
                    "PRIMARY KEY (id))");
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
}

    public void dropUsersTable() {
        try(Connection connection = Util.getConnection()){
            PreparedStatement statement = connection.prepareStatement("DROP TABLE users");
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try(Connection connection = Util.getConnection();
            Statement statement = connection.createStatement()){
            statement.executeUpdate("INSERT users (name, lastName, age) VALUES ('Tvan', 'Tvanov', 22)");
            statement.executeUpdate("INSERT users (name, lastName, age) VALUES ('Ivan', 'Ivanov', 22)");
            statement.executeUpdate("INSERT users (name, lastName, age) VALUES ('Svan', 'Svanov', 22)");
            statement.executeUpdate("INSERT users (name, lastName, age) VALUES ('Zvan', 'Zvanov', 22)");


            } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void removeUserById(long id) {
        try(Connection connection = Util.getConnection();
        Statement statement = connection.createStatement()){
            statement.executeUpdate("DELETE FROM users WHERE id = 1");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        try(Connection connection = Util.getConnection();
            Statement statement = connection.createStatement()){
            statement.executeQuery("SELECT * FROM users");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void cleanUsersTable() {
        try(Connection connection = Util.getConnection();
            Statement statement = connection.createStatement()){
            statement.executeUpdate("DELETE FROM users");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
