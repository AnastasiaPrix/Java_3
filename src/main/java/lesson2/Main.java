package lesson2;

import java.sql.*;
import java.util.Scanner;

public class Main {
    private static Connection connection;
    private static Statement stmt;

    public static void main(String[] args) {
        try {
            connect();
            createTable();
            insertEntity();
            deleteEntity(1);
            deleteTable();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }


    private static void createTable() throws SQLException {
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS employeTable (\n" +
                "    id    INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    name TEXT,\n" +
                "    role TEXT,\n" +
                "    salary INTEGER\n" +
                ");");
    }


    private static void deleteTable() throws SQLException {
        stmt.executeUpdate("DROP TABLE IF EXISTS employeTable;");
    }

    private static void deleteEntity(Integer id) throws SQLException {
        String sql = "\"DELETE FROM employeTable WHERE id = " +id.toString()+";";
        stmt.executeUpdate(sql);
    }

    private static void insertEntity() throws SQLException {
        stmt.executeUpdate("INSERT INTO employeTable (name, role, salary) VALUES ('Tom', 'manager', 60000);");
    }

    private static void selectEntity(Integer id) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String sql = String.format("SELECT * FROM employeTable where prodid = '%s';", id.toString());
        ResultSet res = stmt.executeQuery(sql);
        while (res.next()) {
            System.out.println(res);
        }
    }


    public static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:main.db");
            stmt = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
