package com.afpa.dahouet.metier;

/**
 *
 * @author sdeniel
 */
import static com.afpa.dahouet.metier.Licencie.listeLicencie;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Commissaire extends Personne{
    String commite;
    static List<Commissaire> listeCommissaire;;
    
    // CONSTRUCTEURS
    public Commissaire() {
        super();
    }    
    public Commissaire(String nom, String prenom, String email, String commite, int anneeNaissance) {
        super(nom, prenom, email, anneeNaissance);
        this.commite = commite;
    }
    
    // METHODES
    // petit jeu d'essai de commissaires    
    public void jeuDessai(){       
        Commissaire com = new Commissaire("El commissarios", "George", "george.lecommissaire@yahoo.com", "comité de Bretagne", 1978);
        listeCommissaire = new ArrayList<>();
        listeCommissaire.add(com);
        
        // Affichage de la liste
       for (int i=0; i<listeCommissaire.size(); i++){
           System.out.println(listeCommissaire.get(i).toString());;
       }
    } 
    
    @Override
    public int calculAge() {
        return super.calculAge(); //To change body of generated methods, choose Tools | Templates.
    } 
    
    // calcul de la moyenne d'age des personnes de ce groupe
    public double calculMoyenneAge(){
       int sommeAge = 0;
       int ageTab[] = new int[listeCommissaire.size()];
       double mediane = 0;
       
      for (int i=0; i<listeCommissaire.size();i++){
           int age = calculAge() - listeCommissaire.get(i).getAnneeNaissance();
           ageTab[i] = age; 
           sommeAge += age;
       }
      
       // ordonner le tableau
       Arrays.sort(ageTab);
       
       if ((listeCommissaire.size()%2) == 0) {
           int indexMediane = (listeCommissaire.size()+1)/2;
           mediane = (ageTab[indexMediane] + ageTab[indexMediane-1])/2;
       }
       else {
           int indexMediane = (listeCommissaire.size()-1)/2;
           mediane = ageTab[indexMediane];
       }
       double moyenne = (sommeAge / listeCommissaire.size());
        System.out.println("\nLa moyenne d'age des commissaires est de " + moyenne + " ans.");
        System.out.println("\nLa médiane est : " + mediane + " ans.");
       return sommeAge;              
    }
    
    // GETTERS & SETTERS
    public String getCommite() {    
        return commite;
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

    @Override
    public String toString() {
        return "Commissaire{" + prenom + " " + nom + " (" + email + " ) du " + commite + '}';
    }
}
