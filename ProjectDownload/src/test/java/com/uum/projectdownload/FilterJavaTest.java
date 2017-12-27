/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uum.projectdownload;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
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
public class FilterJavaTest {
    
    public FilterJavaTest() {
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
     * Test of addTree method, of class FilterJava.
     */
    @Test
    public void testAddTree() {
        System.out.println("addTree");
        File file = null;
        Collection<File> all = null;
        FilterJava.addTree(file, all);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of filterJava method, of class FilterJava.
     */
    @Test
    public void testFilterJava() {
        System.out.println("filterJava");
        Collection<File> listAllFileName = new ArrayList<>();
        String[] expResult = {};
        String[] result = FilterJava.filterJava(listAllFileName);
        assertArrayEquals(expResult, result);

        fail("The test case is a prototype.");
    }
    
}
