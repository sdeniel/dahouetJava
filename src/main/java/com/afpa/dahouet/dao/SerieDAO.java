/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.dao;

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
public class SerieDAO {
    
    public static List<Serie> findAll(){
        
        List<Serie> listeSerie = new ArrayList<>();
        JDBCConnect jDBCConnect = null;
        try {
            jDBCConnect = new JDBCConnect();
        } catch (SQLException ex) {
            Logger.getLogger(SerieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     try {
            String sql_stmt = "SELECT * FROM serie";
            PreparedStatement ps = (PreparedStatement) jDBCConnect.getConnection().prepareStatement(sql_stmt);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int serieId = rs.getInt("serieID");
                String nomSerie = rs.getString("nomSerie");  
                Serie serie = new Serie(serieId, nomSerie);
                listeSerie.add(serie);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERREUR");
        }
     
     return listeSerie;
    }
}
