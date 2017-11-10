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
public class Classe {
    
    private int classeID, serieID;
    private String nomClasse;
    private float coef;

    public Classe(int classeID, String nomClasse, float coef, int serieID) {
        this.classeID = classeID;
        this.serieID = serieID;
        this.nomClasse = nomClasse;
        this.coef = coef;
    }

    public int getClasseID() {
        return classeID;
    }

    public int getSerieID() {
        return serieID;
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public float getCoef() {
        return coef;
    }

    @Override
    public String toString() {
        return nomClasse;
    }
    
    
}
