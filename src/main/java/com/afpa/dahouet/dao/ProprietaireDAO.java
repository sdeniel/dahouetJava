/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.dao;

import com.afpa.dahouet.metier.Proprietaire;
import com.afpa.dahouet.metier.Serie;
import com.afpa.dahouet.metier.Voilier;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sdeniel
 */
public class ProprietaireDAO {
    
    public static List<Proprietaire> findAll(){
        
        List<Proprietaire> listeProprietaire = new ArrayList<>();
        JDBCConnect jDBCConnect = null;
        try {
            jDBCConnect = new JDBCConnect();
        } catch (SQLException ex) {
            Logger.getLogger(ProprietaireDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     try {
            String sql_stmt = "SELECT * FROM proprietaire";
            PreparedStatement ps = (PreparedStatement) jDBCConnect.getConnection().prepareStatement(sql_stmt);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int identifiant = rs.getInt("identifiant");
                String motDePasse = rs.getString("motDePasse");
                String nomClubNautique = rs.getString("nomClubNautique");
                int personneID = rs.getInt("personneID"); 
                Proprietaire proprietaire = new Proprietaire(identifiant, motDePasse, nomClubNautique, personneID);
                listeProprietaire.add(proprietaire);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
     
     return listeProprietaire;
    }
  
    public static void insert(Proprietaire proprietaire) throws Exception {
        
            List<Proprietaire> listeProprietaire = new ArrayList<>();
            JDBCConnect jDBCConnect = null;
            try {
                jDBCConnect = new JDBCConnect();
            } catch (SQLException ex) {
                Logger.getLogger(ProprietaireDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
               String sql_stmt = "INSERT INTO proprietaire (identifiant, motDePasse, nomClubNautique, personneID)";
               sql_stmt += " VALUES ('" + proprietaire.getIdentifiant() + "','" + proprietaire.getMdp() + "','" + proprietaire.getNomClub() + "','" + proprietaire.getPersonneID() + "')";
            
               PreparedStatement ps = (PreparedStatement) jDBCConnect.getConnection().prepareStatement(sql_stmt);
               ps.executeUpdate();
        }  
}
