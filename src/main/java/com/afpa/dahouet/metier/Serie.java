/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.metier;

/**
 *
 * @author sdeniel
 */
public class Serie {
   
    private int serieID;
    private String nomSerie;

    public Serie(int serieID, String nomSerie) {
        this.serieID = serieID;
        this.nomSerie = nomSerie;
    }

    public int getSerieID() {
        return serieID;
    }

    public String getNomSerie() {
        return nomSerie;
    }

    @Override
    public String toString() {
        return nomSerie;
    }
    
    
}
