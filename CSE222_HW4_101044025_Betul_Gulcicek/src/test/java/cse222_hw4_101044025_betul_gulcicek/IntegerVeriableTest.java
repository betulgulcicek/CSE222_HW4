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
public class IntegerVeriableTest {

    public IntegerVeriableTest() {
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
     * Test of setValue method, of class IntegerVeriable.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        Object inValue = 23;

        IntegerVeriable instance = new IntegerVeriable("int", "b");
        instance.setValue(inValue);
        assertEquals(instance.getValue(), inValue);
    }

    @Test
    public void testSetValue2() {
        System.out.println("setValue");
        Object inValue = 10;

        IntegerVeriable instance = new IntegerVeriable("int", "a");
        instance.setValue(inValue);
        assertEquals(instance.getValue(), inValue);
    }

    /**
     * Test of getValue method, of class IntegerVeriable.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        IntegerVeriable instance = new IntegerVeriable();
        instance.setValue(34);
        Object expResult = 34;
        Object result = instance.getValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class IntegerVeriable.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        IntegerVeriable instance = new IntegerVeriable("int", "a");

        instance.setValue(12);

        String expResult = "12";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
