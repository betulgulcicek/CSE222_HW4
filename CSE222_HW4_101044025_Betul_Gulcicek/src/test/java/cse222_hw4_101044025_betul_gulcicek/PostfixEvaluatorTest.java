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
public class PostfixEvaluatorTest {
    
    public PostfixEvaluatorTest() {
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
     * Test of evalInt method, of class PostfixEvaluator.
     */
    @Test
    public void testEvalInt() throws Exception {
        System.out.println("evalInt");
        String expression = "2 5 +";
        PostfixEvaluator instance = new PostfixEvaluator();
        Integer expResult = 7;
        Integer result = instance.evalInt(expression);
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testEvalInt2() throws Exception {
        System.out.println("evalInt");
        String expression = "22 5 -";
        PostfixEvaluator instance = new PostfixEvaluator();
        Integer expResult = 17;
        Integer result = instance.evalInt(expression);
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testEvalInt3() throws Exception {
        System.out.println("evalInt");
        String expression = "3 4 *";
        PostfixEvaluator instance = new PostfixEvaluator();
        Integer expResult = 12;
        Integer result = instance.evalInt(expression);
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testEvalInt4() throws Exception {
        System.out.println("evalInt");
        String expression = "20 5 /";
        PostfixEvaluator instance = new PostfixEvaluator();
        Integer expResult = 4;
        Integer result = instance.evalInt(expression);
        assertEquals(expResult, result);
    }
}
