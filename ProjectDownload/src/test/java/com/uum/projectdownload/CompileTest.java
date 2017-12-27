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
public class CompileTest {
    
    public CompileTest() {
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
     * Test of GetDir method, of class Compile.
     */
    @Test
    public void testGetDir() throws Exception {
        System.out.println("GetDir");
        String[] list = {};
        Compile instance = new Compile();
        instance.GetDir(list);
        // TODO review the generated test code and remove the default call to fail.

    }
    
}
