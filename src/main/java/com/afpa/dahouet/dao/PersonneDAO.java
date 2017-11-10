/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.dao;

import com.afpa.dahouet.metier.Personne;
import com.afpa.dahouet.metier.Proprietaire;
import com.afpa.dahouet.metier.Voilier;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sdeniel
 */
public class PersonneDAO {
    
    /**
     * 
     * @param personne
     * @throws Exception 
     */
    public static void insert(Personne personne) throws Exception{
        
        int personneID = 0;
        
        List<Personne> listePersonne = new ArrayList<>();
        JDBCConnect jDBCConnect = null;
        try {
            jDBCConnect = new JDBCConnect();
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     try {
           String sql_stmt = "INSERT INTO personne (nomPersonne, prenomPersonne, email)";
           sql_stmt += " VALUES ('" + personne.getNom() + "','" + personne.getPrenom() + "','" + personne.getEmail()  + "')";
           
           PreparedStatement ps = (PreparedStatement) jDBCConnect.getConnection().prepareStatement(sql_stmt);
           ps.executeUpdate();   
           
           
            PreparedStatement stmCreatePersonne;
            stmCreatePersonne = jDBCConnect.getConnection().prepareStatement("INSERT INTO personne (nomPersonne, prenomPersonne, email) VALUES(?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            stmCreatePersonne.setString(1, personne.getNom());
            stmCreatePersonne.setString(2, personne.getPrenom());
            stmCreatePersonne.setString(3, personne.getEmail());
            
            stmCreatePersonne.execute();
            
           // get autoincrement
            ResultSet rs = stmCreatePersonne.getGeneratedKeys();
            if (!rs.next()) {
                throw new Exception("Cannot get generated personne id");
            }
            personne.setPersonneID(rs.getInt(1));
           
           
           
             
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erreur d'insertion en base de données de la personne");
        } 
    }  
}
