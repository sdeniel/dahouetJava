/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.dao;

import com.afpa.dahouet.metier.Classe;
import com.afpa.dahouet.metier.Serie;
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
public class ClasseDAO {
        
    public static List<Classe> findAll(int choixSerie){
        
        List<Classe> listeClasse = new ArrayList<>();
        JDBCConnect jDBCConnect = null;
        try {
            jDBCConnect = new JDBCConnect();
        } catch (SQLException ex) {
            Logger.getLogger(SerieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     try {
         // ou la valeur de serieID correspond à la serie selectionnée
            String sql_stmt = "SELECT * FROM classe WHERE serieID = " + choixSerie;
            
            PreparedStatement ps = (PreparedStatement) jDBCConnect.getConnection().prepareStatement(sql_stmt);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int classeId = rs.getInt("classeID");
                String nomClasse = rs.getString("nomClasse"); 
                float coef = rs.getFloat("coef");
                int serieID = rs.getInt("serieID");
                Classe classe = new Classe(classeId, nomClasse, coef, serieID);
                listeClasse.add(classe);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERREUR");
        }
     
     return listeClasse;
    }
}

