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
public class Voilier {
    private String numeroVoile;
    private String numeroInscription;
    private int identifiant;
    private int personneID, classeID;

    public Voilier(String numeroVoile, String numeroInscription, int identifiant, int personneID, int classeID) {
        this.numeroVoile = numeroVoile;
        this.numeroInscription = numeroInscription;
        this.identifiant = identifiant;
        this.personneID = personneID;
        this.classeID = classeID;
    }
    
    public String getNumeroVoile() {
        return numeroVoile;
    }

    public String getNumeroInscription() {
        return numeroInscription;
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public int getPersonneID() {
        return personneID;
    }

    public int getClasseID() {
        return classeID;
    }

    @Override
    public String toString() {
        return "Voilier{" + "numeroVoile=" + numeroVoile + ", numeroInscription=" + numeroInscription + ", identifiant=" + identifiant + ", personneID=" + personneID + ", classeID=" + classeID + '}';
    }
    
    
    
}
