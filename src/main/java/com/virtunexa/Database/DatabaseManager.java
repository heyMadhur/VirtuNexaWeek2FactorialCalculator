package com.virtunexa.Database;

import java.sql.*;

public class DatabaseManager {
    private static final String URL = "jdbc:h2:file:./data/factorialcalculatordb;AUTO_SERVER=TRUE";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void createTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS factorial_history ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "username VARCHAR(255), "
                + "method VARCHAR(10), "
                + "number INT, "
                + "result INT, "
                + "calculation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
                + ");";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("Table created or already exists.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertCalculationData(String username, String method, int number, int result) {
        String insertSQL = "INSERT INTO factorial_history (username, method, number, result) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, username);
            pstmt.setString(2, method);
            pstmt.setInt(3, number);
            pstmt.setInt(4, result);
            pstmt.executeUpdate();
            System.out.println("Conversion record inserted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void showConversionHistory() {
        String query = "SELECT * FROM factorial_history ORDER BY calculation_date DESC";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("----- Conversion History -----");
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String method = rs.getString("method");
                int number = rs.getInt("number");
                int result = rs.getInt("result");
                String conversionDate = rs.getString("calculation_date");

                System.out.printf("ID: %d | User: %s | Method: %s | Number: %d | Result: %d | Date: %s%n",
                        id, username, method, number, result, conversionDate);
            }
            System.out.println("------------------------------");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
