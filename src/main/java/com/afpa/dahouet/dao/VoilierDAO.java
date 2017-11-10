/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.dao;

import com.afpa.dahouet.metier.Serie;
import com.afpa.dahouet.metier.Voilier;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class VoilierDAO {
  public static void insert(Voilier voilier){
        
        List<Voilier> listeVoilier = new ArrayList<>();
        JDBCConnect jDBCConnect = null;
        try {
            jDBCConnect = new JDBCConnect();
        } catch (SQLException ex) {
            Logger.getLogger(VoilierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     try {
           String sql_stmt = "INSERT INTO voilier (numeroVoile, numeroInscription, identifiant, personneID, classeID)";
           sql_stmt += " VALUES ('" + voilier.getNumeroVoile() + "','" + voilier.getNumeroInscription() + "','" + voilier.getIdentifiant()  + "','" + voilier.getPersonneID() + "','" + voilier.getClasseID() + "')";

           PreparedStatement ps = (PreparedStatement) jDBCConnect.getConnection().prepareStatement(sql_stmt);
           ps.executeUpdate();
             
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erreur d'insertion en base de données");
        }  
    }  
}
