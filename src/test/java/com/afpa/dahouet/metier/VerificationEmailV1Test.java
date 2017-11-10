/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.metier;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sdeniel
 */
public class VerificationEmailV1Test {
    
    public VerificationEmailV1Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of compare method, of class VerificationEmailV1.
     */
    @Test
    public void testEmail(){
        assertTrue(VerificationEmailV1.compare("ab@cd.ef")); 
        assertTrue(VerificationEmailV1.compare("abcdef@ghij.klmn")); 
        assertTrue(VerificationEmailV1.compare("ab@c.f.ef")); 
        assertFalse(VerificationEmailV1.compare("a@ghij.klmn")); 
        assertFalse(VerificationEmailV1.compare("ab@c.de")); 
        assertFalse(VerificationEmailV1.compare("ab@cd.e")); 
        assertFalse(VerificationEmailV1.compare("abcdefghij")); 
        assertFalse(VerificationEmailV1.compare("abcdefghij.kl")); 
        assertFalse(VerificationEmailV1.compare("ab@cdef"));
    }
    
}
