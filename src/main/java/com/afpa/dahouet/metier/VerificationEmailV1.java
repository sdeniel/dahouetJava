/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.metier;

import java.util.regex.Pattern;

/**
 *
 * @author sdeniel
 */

// Version algo
public class VerificationEmailV1 {
    
    public static boolean compare(String email){
        // on peut utilise les contains, split mais je voulais faire de l'algo brut
        int countArobase = 0, countPointAv = 0, countPointAp = 0, nbCar = 0, nbPoint = 0, nbArobase = 0; 
        boolean validPoint = false;
        boolean validArobase = false;
       
        nbCar = email.length();
        char [] tab = new char[nbCar];
        
        for (int i = 0; i < nbCar; i++){
            tab[i] = email.charAt(i);
            if (tab[i] == '@') {
                nbArobase++;
                countArobase = i;
                validArobase = true;               
            }

            if ((tab[i] == '.') && (i > countArobase)) {
                countPointAv = i - countArobase -1;
                validPoint = true;
                countPointAp = nbCar - i - 1;
            }
        }        
        if ((countArobase >= 2) && (countPointAv >=2) && (countPointAp >=2) && (validPoint == true) && (validArobase == true) && (nbArobase == 1)){
            return true;
        }    
        else return false;  
    }
   
}


