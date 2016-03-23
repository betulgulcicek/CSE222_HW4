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
public class RegisterTest {
    
    public RegisterTest() {
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
     * Test of getVeriable method, of class Register.
     */
    @Test
    public void testGetVeriable() {
        System.out.println("getVeriable");
        Register instance = new Register();
        instance.setVeriable(new Veriables("int", "a"));
        Veriables expResult = new IntegerVeriable("int", "a");
        Veriables result = instance.getVeriable();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of setVeriable method, of class Register.
     */
    @Test
    public void testSetVeriable() {
        System.out.println("setVeriable");
        Veriables veriable = new IntegerVeriable("int", "c");
        Register instance = new Register();
        instance.setVeriable(veriable);
    }

    /**
     * Test of getLocation method, of class Register.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        Register instance = new Register();
        instance.setLocation("$t6");
        String expResult = "$t6";
        String result = instance.getLocation();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLocation method, of class Register.
     */
    @Test
    public void testSetLocation() {
        System.out.println("setLocation");
        String location = "$a0";
        Register instance = new Register();
        instance.setLocation(location);
    }

    /**
     * Test of getRegisterEmpty method, of class Register.
     */
    @Test
    public void testGetRegisterEmpty() {
        System.out.println("getRegisterEmpty");
        String location = "$t6";
        Register instance = new Register();
        boolean expResult = true;
        boolean result = instance.getRegisterEmpty(location);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getRegisterEmpty method, of class Register.
     */
    @Test
    public void testGetRegisterEmpty2() {
        System.out.println("getRegisterEmpty");
        String location = "$t4";
        Register instance = new Register();
        instance.setVeriable(new Veriables("int", "b"));
        instance.setLocation(location);
        boolean expResult = true;
        boolean result = instance.getRegisterEmpty(location);
        assertEquals(expResult, result);
    }

    /**
     * Test of setRegisterEmpty method, of class Register.
     */
    @Test
    public void testSetRegisterEmpty() {
        System.out.println("setRegisterEmpty");
        boolean registerStatus = false;
        Register instance = new Register();
        instance.setRegisterEmpty(registerStatus);
    }
    
}
