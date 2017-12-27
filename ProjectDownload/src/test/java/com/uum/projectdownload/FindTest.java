/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uum.projectdownload;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author HP
 */
public class FindTest {
    
    public FindTest() {
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
     * Test of CountKeyword method, of class Find.
     */
    @Test
    public void testCountKeyword() throws Exception {
        System.out.println("CountKeyword");
        String[] listJavaFile = {};
        Find instance = new Find();
        instance.CountKeyword(listJavaFile);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of FindLine method, of class Find.
     */
    @Test
    public void testFindLine() {
        System.out.println("FindLine");
        String[] listJavaFile = {};
        Find instance = new Find();
        instance.FindLine(listJavaFile);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of combinejson method, of class Find.
     */
    @Test
    public void testCombinejson() {
        System.out.println("combinejson");
        Find instance = new Find();
        instance.combinejson();
    }
    
}
