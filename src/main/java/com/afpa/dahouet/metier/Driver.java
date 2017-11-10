/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.metier;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author sdeniel
 */
public class Driver {
    
    static ArrayList<Personne> listePersonne;
    
    public static void main(String Args[]){
       /* EXO 1 : avant tests unitaires, voir VerificationEmailV1Test pour les JUnit
       String email = "ad.dzqdq@qae.efdzq";       
       VerificationEmailV1 v = new VerificationEmailV1();
       v.compare(email);*/
       
       // EXO 2
       Proprietaire p = new Proprietaire();
       Licencie l = new Licencie();
       Commissaire c = new Commissaire();
       l.jeuDessai(); 
       l.calculMoyenneAge();
       
    }
    
}
