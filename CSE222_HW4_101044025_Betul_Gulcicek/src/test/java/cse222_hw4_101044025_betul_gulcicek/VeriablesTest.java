/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse222_hw4_101044025_betul_gulcicek;

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
public class VeriablesTest {
    
    public VeriablesTest() {
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
     * Test of setType method, of class Veriables.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        String inType = "double";
        Veriables instance = new Veriables();
        instance.setType(inType);
    }

    /**
     * Test of setName method, of class Veriables.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String inName = "5";
        Veriables instance = new Veriables();
        instance.setName(inName);
    }

    /**
     * Test of setValue method, of class Veriables.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        Object inValue = 0.0;
        Veriables instance = new Veriables();
        instance.setValue(inValue);
    }

    /**
     * Test of getisInitialized method, of class Veriables.
     */
    @Test
    public void testGetisInitialized() {
        System.out.println("getisInitialized");
        Veriables instance = new Veriables();
        boolean expResult = false;
        boolean result = instance.getisInitialized();
        assertEquals(expResult, result);
    }

    /**
     * Test of getValue method, of class Veriables.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        Veriables instance = new Veriables();
        Object expResult = 0;
        Object result = instance.getValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of getType method, of class Veriables.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Veriables instance = new Veriables();
        String expResult = "";
        String result = instance.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Veriables.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Veriables instance = new Veriables();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
    }
    
}
