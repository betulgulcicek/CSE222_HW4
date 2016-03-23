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
public class InfixToPostfixTest {
    
    public InfixToPostfixTest() {
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
     * Test of convert method, of class InfixToPostfix.
     * @throws java.lang.Exception
     */
    @Test
    public void testConvert() throws Exception {
        System.out.println("convert");
        String infix = "a + b * 5";
        InfixToPostfix instance = new InfixToPostfix();
        String expResult = "a b 5 * + ";
        String result = instance.convert(infix);
        assertEquals(expResult, result);
    }


/**
     * Test of convert method, of class InfixToPostfix.
     * @throws java.lang.Exception
     */
    @Test
    public void testConvert2() throws Exception {
        System.out.println("convert");
        String infix = "a + 3 * 5";
        InfixToPostfix instance = new InfixToPostfix();
        String expResult = "a 3 5 * + ";
        String result = instance.convert(infix);
        assertEquals(expResult, result);
    }


/**
     * Test of convert method, of class InfixToPostfix.
     * @throws java.lang.Exception
     */
    @Test
    public void testConvert3() throws Exception {
        System.out.println("convert");
        String infix = "a = b * 5";
        InfixToPostfix instance = new InfixToPostfix();
        String expResult = "a b 5 * = ";
        String result = instance.convert(infix);
        assertEquals(expResult, result);
    }


/**
     * Test of convert method, of class InfixToPostfix.
     * @throws java.lang.Exception
     */
    @Test
    public void testConvert4() throws Exception {
        System.out.println("convert");
        String infix = "a = b";
        InfixToPostfix instance = new InfixToPostfix();
        String expResult = "a b = ";
        String result = instance.convert(infix);
        assertEquals(expResult, result);
    }


/**
     * Test of convert method, of class InfixToPostfix.
     * @throws java.lang.Exception
     */
    @Test
    public void testConvert5() throws Exception {
        System.out.println("convert");
        String infix = "c = a / 7";
        InfixToPostfix instance = new InfixToPostfix();
        String expResult = "c a 7 / = ";
        String result = instance.convert(infix);
        assertEquals(expResult, result);
    }    
    
    
    
/**
     * Test of convert method, of class InfixToPostfix.
     * @throws java.lang.Exception
     */
    @Test
    public void testConvert6() throws Exception {
        System.out.println("convert");
        String infix = "c + 9 - 2 / 1";
        InfixToPostfix instance = new InfixToPostfix();
        String expResult = "c 9 + 2 1 / - ";
        String result = instance.convert(infix);
        assertEquals(expResult, result);
    }    
    
    
    
/**
     * Test of convert method, of class InfixToPostfix.
     * @throws java.lang.Exception
     */
    @Test
    public void testConvert7() throws Exception {
        System.out.println("convert");
        String infix = "d * 8 / 2 = c";
        InfixToPostfix instance = new InfixToPostfix();
        String expResult = "d 8 * 2 / c = ";
        String result = instance.convert(infix);
        assertEquals(expResult, result);
    }    
}
