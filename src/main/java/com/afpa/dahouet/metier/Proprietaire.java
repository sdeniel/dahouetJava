package com.afpa.dahouet.metier;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static com.afpa.dahouet.metier.Licencie.listeLicencie;
import com.afpa.dahouet.metier.Personne;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author sdeniel
 */
public class Proprietaire extends Personne {
    
    private static List<Proprietaire> listeProprietaire;
    private String login, mdp, nomClub;
    private int identifiant, personneID;
    
    
    // CONSTRUCTEURS
    public Proprietaire() { 
        
    }   
    
    public Proprietaire(int identifiant, String mdp, String nomClub, int personneID) { 
        this.identifiant = identifiant;
        this.mdp = mdp;
        this.nomClub = nomClub;
        this.personneID = personneID;
    }
    
    public Proprietaire(String nom, String prenom, String email, int anneeNaissance) { 
        super(nom, prenom, email, anneeNaissance);
    }  
    
    public Proprietaire(String nom, String prenom, String email, int anneeNaissance, String login, String mdp, String nomClub) { // complet
        super(nom, prenom, email, anneeNaissance);
        this.login = login;
        this.mdp = mdp;
        this.nomClub = nomClub;
    }  

    // METHODES
    // petit jeu d'essai de propriétaires
    public void jeuDessai(){
       Proprietaire prop1 = new Proprietaire("Leponge", "Bob", "Bob.leponge@sousleau.com",1988);
       Proprietaire prop2 = new Proprietaire("Craquetonslip", "René", "rene.aunemail.minitel",1954);
       
       listeProprietaire = new ArrayList<>();
       listeProprietaire.add(prop1);
       listeProprietaire.add(prop2);
       
        // Affichage de la liste
       for (int i=0; i<listeProprietaire.size(); i++){
           System.out.println(listeProprietaire.get(i).toString());;
       }
    }

    @Override
    public int calculAge() {
        return super.calculAge(); //To change body of generated methods, choose Tools | Templates.
    } 
    
    // calcul de la moyenne d'age des personnes de ce groupe
    public double calculMoyenneAge(){
       int sommeAge = 0;
       int ageTab[] = new int[listeProprietaire.size()];
       double mediane = 0;
       
       for (int i=0; i<listeProprietaire.size();i++){
           int age = calculAge() - listeProprietaire.get(i).getAnneeNaissance();           
           ageTab[i] = age;
           sommeAge += age;
       }
       // ordonner le tableau
       Arrays.sort(ageTab);
       
       if ((listeProprietaire.size()%2) == 0) {
           int indexMediane = (listeProprietaire.size()+1)/2;
           mediane = (ageTab[indexMediane] + ageTab[indexMediane-1])/2;
       }
       else {
           int indexMediane = (listeProprietaire.size()-1)/2;
           mediane = ageTab[indexMediane];
       }
       double moyenne = (sommeAge / listeProprietaire.size());
        System.out.println("\nLa moyenne d'age des proprietaires est de " + moyenne + " ans.");        
        System.out.println("\nLa médiane est : " + mediane + " ans.");
       return moyenne ;
    }
    
    
    // GETTERS & SETTERS
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public int getAnneeNaissance() {
        return anneeNaissance;
    }  
    
    public String getMdp() {
        return mdp;
    }

    public String getNomClub() {
        return nomClub;
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public int getPersonneID() {
        return personneID;
    }
 

    @Override
    public String toString() {
        return "id prop : " + identifiant;
    }
    
    
}
