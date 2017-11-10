/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.metier;

import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.LinkedList;
import java.util.List;



/**
 *
 * @author sdeniel
 */
public class Licencie extends Personne {
    
    static List<Licencie> listeLicencie;
    
    int numLicence, anneeLicence;
    double pointsFFV;
    
    // CONSTRUCTEURS
    public Licencie() {
        super();
    }
   
    public Licencie(String nom, String prenom, String email, int numLicence, int anneeLicence, double pointsFFV, int anneeNaissance) {
        super(nom, prenom, email, anneeNaissance);
        this.numLicence = numLicence;
        this.anneeLicence = anneeLicence;
        this.pointsFFV = pointsFFV;
    }
    
    // METHODES
    // petit jeu d'essai de licenciés
    public void jeuDessai(){
       Licencie lic1 = new Licencie("Licencia", "Maria", "maquecalor@msn.fr", 12458, 2017, 103, 1981);
       Licencie lic2 = new Licencie("Licencia", "Roberta", "coquinou@lenoob.ita", 17456, 2017, 68, 1985);
       Licencie lic3 = new Licencie("Licencia", "claudio", "cloclo@karma.de", 16021, 2016, 79, 1973);
    
       listeLicencie = new ArrayList<>();
       listeLicencie.add(lic1);
       listeLicencie.add(lic2);
       listeLicencie.add(lic3);
       
       // Affichage de la liste
       for (int i=0; i<listeLicencie.size(); i++){
           System.out.println(listeLicencie.get(i).toString());;
       }
    }
    
    @Override
    public int calculAge() {
        return super.calculAge(); //To change body of generated methods, choose Tools | Templates.
    }       
    
    // calcul de la moyenne d'age des personnes de ce groupe
    public double calculMoyenneAge(){
       int sommeAge = 0;
       int ageTab[] = new int[listeLicencie.size()];
       double mediane = 0;
       
       for (int i=0; i<listeLicencie.size();i++){
           int age = calculAge() - listeLicencie.get(i).getAnneeNaissance();
           
           //test validité licence
           if (listeLicencie.get(i).getAnneeLicence() == 2017){
               listeLicencie.get(i).setPointsFFV(listeLicencie.get(i).getPointsFFV()+1); // je mets 1 points en bonus s'il a sa licence à jour :)
               //System.out.println(listeLicencie.get(i).getAnneeLicence() + " " + listeLicencie.get(i).getPointsFFV());
           }
           else {
               listeLicencie.get(i).setPointsFFV(0);
               //System.out.println(listeLicencie.get(i).getAnneeLicence() + " " + listeLicencie.get(i).getPointsFFV());
           }
                     
           ageTab[i] = age;
           sommeAge += age;
       }
       // ordonner le tableau
       Arrays.sort(ageTab);
       
       if ((listeLicencie.size()%2) == 0) {
           int indexMediane = (listeLicencie.size()+1)/2;
           mediane = (ageTab[indexMediane] + ageTab[indexMediane-1])/2;
       }
       else {
           int indexMediane = (listeLicencie.size()-1)/2;
           mediane = ageTab[indexMediane];
       }
       
       double moyenne = (sommeAge / listeLicencie.size());
        System.out.println("\nLa moyenne d'age des licenciés est de " + moyenne + " ans.");
        System.out.println("\nLa médiane est : " + mediane + " ans.");
       return moyenne ;
    }    
    
   
    
    @Override
    public String toString() {
        return "Licencie{" + prenom + " " + nom + ", numLicence : " + numLicence + ", anneeLicence=" + anneeLicence + ", pointsFFV=" + pointsFFV + " annee de naissance : " + anneeNaissance +'}';
    }
       
    /*public double calculPoints(){
    
        String format = "yyyy";
        java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format );
        int anneeEnCours = Integer.parseInt(formater.format( new java.util.Date() )) ;
        
        if(listeLicencie.get(0).getAnneeLicence() == anneeEnCours){
            return pointsFFV++;
        }
        else return 0;
    }*/
    
    // GETTERS & SETTERS
    public int getNumLicence() {
        return numLicence;
    }
    public int getAnneeLicence() {
        return anneeLicence;
    }
    public double getPointsFFV() {
        return pointsFFV;
    }
    public void setPointsFFV(double pointsFFV) {
        this.pointsFFV = pointsFFV;
    }
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
}
