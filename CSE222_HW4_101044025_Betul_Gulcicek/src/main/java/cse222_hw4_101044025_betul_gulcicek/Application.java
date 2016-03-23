/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse222_hw4_101044025_betul_gulcicek;

import cse222_hw4_101044025_betul_gulcicek.PostfixEvaluator.SyntaxErrorException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author BETUL
 */
public class Application {

    /**
     *
     * @param name isAlpha mi bakilacak olan string - String value
     * @return verilen string alfabeden mi
     */
    public boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }

    /**
     * veriable list
     */
    private List<Veriables> variables = new ArrayList();

    /**
     * veriable listi veren method
     *
     * @return veriable list
     */
    public List<Veriables> getVariable() {
        return variables;
    }

    /**
     * main islemlerin yapildigi method, read file, evaluate
     *
     * @param fileName input file name
     */
    public void run(String fileName) throws InfixToPostfix.SyntaxErrorException, SyntaxErrorException, FileNotFoundException {

        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));

            String line = in.readLine();

            String temp = new String();
            String temp2 = new String();

            while (line != null) {

                InfixToPostfix itp = new InfixToPostfix();
                temp2 = itp.convert(line);
                System.out.println(": " + temp2);

                try {
                    FileWriter fileWriter = new FileWriter("postfix.txt", true);
                    try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                        bufferedWriter.newLine();

                        bufferedWriter.append(temp2);
                    }

                } catch (IOException ex) {
                    ex.getMessage();
                }

                //   System.out.println(line);
                StringTokenizer token = new StringTokenizer(line);
                temp = token.nextToken();

                //  System.out.println(temp);
                //control lvalue 
                if (!temp.equals("print") && search(temp) == -1 && !isAlpha(temp) /*&& !isDigit(temp)*/) {
                    System.out.printf("Error! %s is not be lvalue.\n", temp);
                    throw new IOException("Error! is not be lvalue.\n");
                }

                //Integer variable decleration
                if (isAlpha(temp) && !temp.equals("print") /*&&  search(temp) != -1*/) {
                    //control is variable name exist
                    if (search(temp) == -1) {
                        variables.add(new IntegerVeriable("int", temp));
                        //  register.add(new Register(new IntegerVeriable("int", temp), "-1", true));
                    }
                    /*else {
                    System.out.printf("Error! %s This variable name has already exist. \n", name);
                }*/
                }

                //lvalue variable and make calculate process
                if (search(temp) != -1) {
                    //read '=' character
                    token.nextToken();  //ORIGINAL

                    String infix = new String();
                    String next = new String();

                    int control;

                    while (token.hasMoreTokens()) {
                        next = token.nextToken();
                        //control is statement includes variable name
                        control = search(next);
                        if (control != -1) {
                            //convert variable name to value
                            next = variables.get(control).toString();
                        }

                        //append read values to infix string 
                        infix = infix + next;
                        infix = infix + " ";
                    }
                    PostfixEvaluator evaluator = new PostfixEvaluator();
                    Integer valueInt;

                    //Integer
                    if (variables.get(search(temp)).getType().equals("int")) {
                        InfixToPostfix converter = new InfixToPostfix();
                        try {
                            valueInt = evaluator.evalInt(converter.convert(infix));
                            variables.get(search(temp)).setValue(valueInt);
                            // register.get(search(temp)).getVeriable().setValue(valueInt);//.setVeriable(valueInt);
                        } catch (InfixToPostfix.SyntaxErrorException ex) {
                            ex.getMessage();
                        }
                    } else {
                        System.out.println("Veriable Type is not Integer!");
                    }

                }
                //print function
                if (temp.equals("print")) {
                    String printer = token.nextToken();
                    //Control variable name
                    if (search(printer) != -1) {
                        System.out.printf("Result ----> %s = %s\n", variables.get(search(printer)).getName(),
                                variables.get(search(printer)).toString() +"\n\n");
                    } else {
                        //Print variables value on screen
                        System.out.printf("%s\n", Integer.parseInt(printer));                                               // EXCEPTION
                    }
                }

                //get next line
                line = in.readLine();

            }
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException("File is Not Found");
        } catch (IOException ex) {
            ex.getMessage();
        }
        //control uninitialized variables
        for (int i = 0; i < variables.size(); ++i) {
            //   System.out.println(variables.get(i));
            if (!variables.get(i).getisInitialized()) {
                System.out.printf("Warning! %s is uninitialized variable.\n", variables.get(i).getName());
            }
        }
    }

    /**
     * veriiable listini print eder
     */
    public void printVariable() {
        System.out.println("VARIABLE");
        for (int i = 0; i < variables.size(); ++i) {
            System.out.println(variables.get(i).getName() + " " + variables.get(i).getValue());
        }
    }

    /**
     * variable listinde search yapar
     *
     * @param targetName search yapilacak target - String value
     * @return target bulunduysa indexi, bulunamadiysa -1 - int value
     */
    public int search(String targetName) {
        for (int i = 0; i < variables.size(); ++i) {
            if (variables.get(i).getName().equals(targetName)) {
                //    System.out.print(variables.get(i)+" ");
                return i;
            }
        }
        return -1;
    }
}
