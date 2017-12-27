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

/**
 *
 * @author HP
 */
public class DownloadTest {

    public DownloadTest() {
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
     * Test of klon method, of class Download.
     */
    @Test
    public void testKlon() {
        System.out.println("klon");
        Download instance = new Download();
        instance.klon();
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of run method, of class Download.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        Download instance = new Download();
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
    }

}
