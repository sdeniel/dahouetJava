
package com.afpa.dahouet.metier;

import java.util.ArrayList;

/**
 *
 * @author sdeniel
 */
public class Personne {
    String nom, prenom, email;
    int anneeNaissance, personneID;
    static ArrayList<Personne> listePersonne;
    
    
    public Personne() {        
    }
    
    public Personne(String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.anneeNaissance = anneeNaissance;
    }
    
    public Personne(String nom, String prenom, String email, int personneID) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.anneeNaissance = anneeNaissance;
        this.personneID = personneID;
    }

    // j'ai inversé l'ordre année de naissance et email pour des petits tests donc a voir si besoin l'erreur est la ...
    public Personne(String nom, String prenom, int anneeNaissance, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.anneeNaissance = anneeNaissance;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getPersonneID() {
        return personneID;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPersonneID(int personneID) {
        this.personneID = personneID;
    }
    
    

    @Override
    public String toString() {
        return "Personne{" + "nom=" + nom + ", prenom=" + prenom + ", email=" + email + '}';
    }
    
     // calcul de l'age des personnes = f(annee Naissance)
    public int calculAge(){    
        String format = "yyyy";
        java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format );
        int anneeEnCours = Integer.parseInt(formater.format( new java.util.Date() )) ;
        
        return anneeEnCours;
    }    
    

    public int getAnneeNaissance() {
        return anneeNaissance;
    }
    
    
}
