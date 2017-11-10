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
public class VerificationEmailV2 {
    
    public static boolean compare(String email){
        // pensez à rajouter {2} avant et après le @ pour avoir au moins 2 caractères avant et après le @ dans l'email
        boolean test = Pattern.matches("^[_a-z0-9-]{2, }+(\\.[_a-z0-9-]+)*@[a-z0-9-]{2, }+(\\.[a-z0-9-]{2, }+)+$", email);
        System.out.println("boolean : " + test);
          return test;
    }
    
   
}


