/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse222_hw4_101044025_betul_gulcicek;

/**
 *
 * @author BETUL
 */
/**
 * Bunlari Kontrol Et
 * (such as, undefined variable usage,division by zero, uncompitable type,  
 * out of register limit..).
 * 
 * tanimsiz veriable
 * 0 a bolme
 * register limiti doldu
 * uncompitable type (uyumsuz tip)
 *
 * 
 * Kullanabileceklerin ;
 * java list (ARRAYLIST)
 * and stack 
 * and also you can create your data structures.
 */

/**
 * Kullanabilecegin Registerlar:
 * [$t0-$t8,$a0,$v1]
 * ve tablodaki instructionlar
 */

import cse222_hw4_101044025_betul_gulcicek.InfixToPostfix.SyntaxErrorException;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws SyntaxErrorException, 
                                            PostfixEvaluator.SyntaxErrorException, 
                                            FileNotFoundException, IOException {
        
        Application app = new Application();
        //app.run(args[0]);
        try{
        app.run("input.txt");
        }catch(FileNotFoundException ex)
        {
            System.out.println("File Not Found! " + ex.getMessage());
            
        }
        
    }

}
