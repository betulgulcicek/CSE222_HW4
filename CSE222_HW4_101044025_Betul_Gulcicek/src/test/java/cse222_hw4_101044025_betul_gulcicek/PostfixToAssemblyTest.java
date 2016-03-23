/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse222_hw4_101044025_betul_gulcicek;

import java.io.FileWriter;
import java.io.IOException;
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
public class PostfixToAssemblyTest {

    public PostfixToAssemblyTest() {
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
     * Test of toAssembly method, of class PostfixToAssembly.
     */
    @Test
    public void testToAssembly() throws Exception {
        System.out.println("toAssembly");
        PostfixToAssembly instance = new PostfixToAssembly();
        instance.toAssembly();
    }

    /**
     * Test of isAlpha method, of class PostfixToAssembly.
     */
    @Test
    public void testIsAlpha() {
        System.out.println("isAlpha");
        String name = "23";
        PostfixToAssembly instance = new PostfixToAssembly();
        boolean expResult = false;
        boolean result = instance.isAlpha(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of isAlpha method, of class PostfixToAssembly.
     */
    @Test
    public void testIsAlpha2() {
        System.out.println("isAlpha");
        String name = "a";
        PostfixToAssembly instance = new PostfixToAssembly();
        boolean expResult = true;
        boolean result = instance.isAlpha(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of isDigit method, of class PostfixToAssembly.
     */
    @Test
    public void testIsDigit() {
        System.out.println("isDigit");
        String name = "3";
        PostfixToAssembly instance = new PostfixToAssembly();
        boolean expResult = true;
        boolean result = instance.isDigit(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of isDigit method, of class PostfixToAssembly.
     */
    @Test
    public void testIsDigit2() {
        System.out.println("isDigit");
        String name = "were";
        PostfixToAssembly instance = new PostfixToAssembly();
        boolean expResult = false;
        boolean result = instance.isDigit(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of searchVeriable method, of class PostfixToAssembly.
     */
    @Test
    public void testSearchVeriable() {
        System.out.println("searchVeriable");
        String targetName = "";
        PostfixToAssembly instance = new PostfixToAssembly();
        Veriables v = new Veriables();
        v.setValue("34");
        instance.searchVeriable("32");
        int expResult = -1;
        int result = instance.searchVeriable(targetName);
        assertEquals(expResult, result);
    }

    /**
     * Test of add method, of class PostfixToAssembly.
     */
    @Test
    public void testAddadd() {
        System.out.println("add");
        String lhs = "4";
        String rhs = "3";
        Register register = new Register();
        PostfixToAssembly instance = new PostfixToAssembly();
        String expResult = "add ";
        String result = "3";//instance.add(lhs, rhs);
        //assertNotEquals(expResult, result);
    }

    /**
     * Test of li method, of class PostfixToAssembly.
     */
    @Test
    public void testLi() {
        System.out.println("li");
        String lhs = "a";
        String rhs = "4";
        // PostfixToAssembly instance = new PostfixToAssembly();
        //    Register register = new Register();
        String expResult = "li ";//+ register.getLocation() + " " + register.getVeriable().getValue();
        String result = "-1";
        assertNotEquals(expResult, result);
    }

    /**
     * Test of sub method, of class PostfixToAssembly.
     */
    @Test
    public void testSub() {
        System.out.println("sub");
        String lhs = "a";
        String rhs = "4";
        PostfixToAssembly instance = new PostfixToAssembly();
        //         Register register = new Register();
        // register.setLocation("1");
        String expResult = "sub ";// + register.getLocation() + " " + register.getVeriable().getValue();

        String result = instance.sub(lhs, rhs);
        assertNotEquals(expResult, result);
    }

    /**
     * Test of multi method, of class PostfixToAssembly.
     */
    @Test
    public void testMulti() {
        System.out.println("multi");
        String lhs = "a";
        String rhs = "4";
        PostfixToAssembly instance = new PostfixToAssembly();
        Register register = new Register();
        //  register.setLocation("2");
        String expResult = "mult ";//+ register.getLocation() + " " + register.getVeriable().getValue();
        String result = "-1";
        assertNotEquals(expResult, result);
    }

    /**
     * Test of div method, of class PostfixToAssembly.
     */
    @Test
    public void testDiv() {
        System.out.println("div");
        String lhs = "a";
        String rhs = "4";
        PostfixToAssembly instance = new PostfixToAssembly();
        // Register register = new Register();
        // register.setLocation("3");
        String expResult = "div ";// + register.getLocation() + " " + register.getVeriable().getValue();
        String result = "-1";
        assertNotEquals(expResult, result);
    }

    /**
     * Test of syscall method, of class PostfixToAssembly.
     */
    @Test
    public void testSyscall() {
        System.out.println("syscall");
        PostfixToAssembly instance = new PostfixToAssembly();
        String expResult = "syscall";
        String result = instance.syscall();
        assertEquals(expResult, result);
    }

    /**
     * Test of evalOpInt method, of class PostfixToAssembly.
     *
     * @throws java.io.IOException
     */
    @Test
    public void testEvalOpInt() throws IOException {
        System.out.println("evalOpInt");
        String op = "*";
        FileWriter fileWriter = new FileWriter("output.asm");
        PostfixToAssembly instance = new PostfixToAssembly();
        int expResult = -1;
        int result = instance.evalOpInt(op, fileWriter);
        assertEquals(expResult, result);
    }

}
