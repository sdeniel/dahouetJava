/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sdeniel
 */
// Etablit la connection à la base de données
public class JDBCConnect {

    static Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    public JDBCConnect() throws SQLException {
        connection = DriverManager.getConnection(Config.connection_url, Config.DATABASE_USER_ID, Config.DATABASE_PASSWORD);
    }

    // Retourne la connection
    public static Connection getConnection() {
        return connection;
    }

    // Permet de créer le statement
    public void ExecuteSQLStatement(String sql_stmt) {
        try {
            statement = connection.createStatement();

            statement.executeUpdate(sql_stmt);
        } catch (SQLException ex) {
            System.out.println("Erreur relevée : " + ex.getMessage());
        }
    }
}

