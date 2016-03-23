/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse222_hw4_101044025_betul_gulcicek;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author BETUL
 */
public class ApplicationTest {
    
    public ApplicationTest() {
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
     * Test of isAlpha method, of class Application.
     */
    @Test
    public void testIsAlpha() {
        System.out.println("isAlpha");
        String name = "a";
        Application instance = new Application();
        boolean expResult = true;
        boolean result = instance.isAlpha(name);
        assertEquals(expResult, result);
    }
    
     /**
     * Test of isAlpha method, of class Application.
     */
    @Test
    public void testIsAlpha2() {
        System.out.println("isAlpha");
        String name = "4";
        Application instance = new Application();
        boolean expResult = false;
        boolean result = instance.isAlpha(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of getVariable method, of class Application.
     */
    @Test
    public void testGetVariable() {
        System.out.println("getVariable");
       
    }

    /**
     * Test of run method, of class Application.
     * @throws java.lang.Exception
     */
    @Test
    public void testRun() throws Exception {
        System.out.println("run");
        String fileName = "input.txt";
        Application instance = new Application();
        instance.run(fileName);
    }

    /**
     * Test of printVariable method, of class Application.
     */
    @Test
    public void testPrintVariable() {
        System.out.println("printVariable");
        Application instance = new Application();
        instance.printVariable();
    }

    /**
     * Test of search method, of class Application.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        String targetName = "a";
        Application instance = new Application();
        instance.getVariable().add(new Veriables("int", "a"));
        int expResult = 0;
        int result = instance.search(targetName);
        assertEquals(expResult, result);
    }
    
}
