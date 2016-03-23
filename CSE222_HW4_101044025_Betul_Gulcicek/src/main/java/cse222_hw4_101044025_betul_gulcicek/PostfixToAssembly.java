/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse222_hw4_101044025_betul_gulcicek;

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
public class PostfixToAssembly {

    private List<Register> register = new ArrayList(11);
    private List<Veriables> variable = new ArrayList();
    private static final String OPERATORS = "=+-*/";

    /**
     * postfix.txt filedan okuma yapip oku assembly koda ceviren method
     *
     * @throws FileNotFoundException file not found throw exception
     * @throws IOException i/o throw exception
     * @throws
     * cse222_hw4_101044025_betul_gulcicek.InfixToPostfix.SyntaxErrorException
     * @throws
     * cse222_hw4_101044025_betul_gulcicek.PostfixEvaluator.SyntaxErrorException
     */
    public void toAssembly() throws FileNotFoundException, IOException,
            InfixToPostfix.SyntaxErrorException, PostfixEvaluator.SyntaxErrorException {

        try {
            FileWriter fileWriter = new FileWriter("output.asm", true);

            for (int i = 0; i < 11; i++) {
                register.add(new Register());
            }

            for (int i = 0; i < register.size() - 2; i++) {
                register.get(i).setLocation("$t" + i);
                // System.out.println(register.get(i).getLocation());
            }
            register.get(9).setLocation("$a0"); // a0
            register.get(10).setLocation("$v0"); // v0

            /* System.out.println("--------------khrblıfgghvlhbtrwlvhbtvhrtvbrvhjbl----------------------");
        for(int i=0; i<register.size(); i++)
        {
            System.out.println(register.get(i).getLocation());
        }*/
            BufferedReader in = new BufferedReader(new FileReader("postfix.txt"));

            in.readLine();
            String line = in.readLine();
            String temp = new String();
            String next = new String();

            System.out.println("***************** ASSEMBLY *****************");
            while (line != null) {
                //   System.out.println(line);
                StringTokenizer token = new StringTokenizer(line);
                // token.nextToken(); // empty line
                temp = token.nextToken();

                while (token.hasMoreTokens()) {
                    /*if (!temp.equals("print") && searchVeriable(temp) == -1 && (!isAlpha(temp) || !isDigit(temp))) {
                    System.out.printf("Error! %s is not be value.\n", temp);
                }*/

                    if ((!isOperator(temp) && !temp.equals("print")) && (isAlpha(temp) || isDigit(temp))) {
                        if (searchVeriable(temp) == -1) {
                            variable.add(new IntegerVeriable("int", temp));
                            // register.add(new Register(new IntegerVeriable("int", temp), "-1", true));
                        }/*else {
                    System.out.printf("Error! %s This variable name has already exist. \n", temp);
                }*/
                    }

                    if (isOperator(temp)) {
                        int result;
                        result = evalOpInt(temp, fileWriter);
                        System.out.println("RESUT: " + result);

                    }

                    if ("print".equals(temp)) {
                        System.out.println("Printttt bennnn: " + temp);
                        String printer = token.nextToken();
                        //Control variable name
                        if (searchVeriable(printer) != -1) {
                            System.out.printf("Result ----> %s = %s\n", variable.get(searchVeriable(printer)).getName(),
                                    variable.get(searchVeriable(printer)).toString() + "\n\n");
                        } else {
                            //Print variables value on screen
                            System.out.println(printer + " ---> is not found veriable list");
                            // System.out.printf("%s\n", Integer.parseInt(printer));                                               // EXCEPTION
                        }

                        printToFile(fileWriter, syscall());
                        break;
                    }

                    temp = token.nextToken();
                    if ("=".equals(temp)) {
                        /*System.out.println("Assignmentim bennnn");
                    updateVeriable();
                    printToFile(fileWriter, li());*/
                        evalOpInt(temp, fileWriter);
                    }
                }
                //get next line
                line = in.readLine();
            }
            //printVariable();
            //control uninitialized variables
            for (int i = 0; i < variable.size(); ++i) {
                //   System.out.println(variables.get(i));
                if (!variable.get(i).getisInitialized()) {
                    System.out.println(/*"Warning! %s is uninitialized variable.\n", variable.get(i).getName()*/);
                }
            }
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException("File Not Found");
        }
    }

    /**
     * verilen isAlpha mi
     *
     * @param name isAlpha olup olmadigi kontrol edilecek olan target - String
     * value
     * @return isAlpha olup olmadigi - boolean value
     */
    public boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }

    /**
     * verilen isDigit mi
     *
     * @param name isDigit olup olmadigi kontrol edilecek olan target - String
     * value
     * @return isDigit olup olmadigi - boolean value
     */
    public boolean isDigit(String name) {
        return name.matches("[0-9]+");
    }

    /**
     * verilen operator mu
     *
     * @param op operator olup olmadigi kontrol edilecek olan target - String
     * value
     * @return operator olup olmadigi - boolean value
     */
    private boolean isOperator(String op) {
        return OPERATORS.indexOf(op) != -1;
    }

    /**
     * variable listini print eden method
     */
    private void printVariable() {
        Application app = new Application();
        app.printVariable();
    }

    /**
     * verilen targeti variable listinde arayan method
     *
     * @param targetName variable listinde aranacak olan method
     * @return
     */
    public int searchVeriable(String targetName) {
        for (int i = 0; i < variable.size(); ++i) {
            if (variable.get(i).getName().equals(targetName)) {
                //    System.out.print(variable.get(i)+" ");
                return i;
            }
        }
        return -1;
    }

    /**
     * postfixde + operatoru gordugunde bunu assemblye ceviren method
     *
     * @param lhs left variable - String value
     * @param rhs right variable - String value
     * @return assembly code - String value
     */
    public String add(String lhs, String rhs) {
        return "add " + register.get(3).getLocation() + " " + register.get(searchVeriable(rhs)).getLocation() + " " + register.get(searchVeriable(lhs)).getLocation();
    }

    /**
     * postfixde = operatoru gordugunde bunu assemblye ceviren method
     *
     * @param lhs left variable - String value
     * @param rhs right variable - String value
     * @return assembly code - String value
     */
    public String li(String lhs, String rhs) {
        // Register register = new Register();

        return "li " + register.get(searchVeriable(rhs)).getLocation() + " " + register.get(searchVeriable(lhs)).getVeriable().getValue();    ///////////
    }

    /**
     * postfixde - operatoru gordugunde bunu assemblye ceviren method
     *
     * @param lhs left variable - String value
     * @param rhs right variable - String value
     * @return assembly code - String value
     */
    public String sub(String lhs, String rhs) {
        Register register = new Register();
        register.setLocation("1");
        return "sub " + register.getLocation() + " " + register.getVeriable().getValue();
    }

    /**
     * postfixde * operatoru gordugunde bunu assemblye ceviren method
     *
     * @param lhs left variable - String value
     * @param rhs right variable - String value
     * @return assembly code - String value
     */
    public String multi(String lhs, String rhs) {
        return "mult " + register.get(searchVeriable(rhs)).getLocation() + " " + register.get(searchVeriable(lhs)).getLocation()
                + "\n" + "mflo " + register.get(searchVeriable(lhs) + 1).getLocation();
    }

    /**
     * postfixde / operatoru gordugunde bunu assemblye ceviren method
     *
     * @param lhs left variable - String value
     * @param rhs right variable - String value
     * @return assembly code - String value
     */
    public String div(String lhs, String rhs) {

        return "div " + register.get(searchVeriable(rhs)).getLocation() + " " + register.get(searchVeriable(lhs)).getLocation();
    }

    /**
     * postfixde print operatoru gordugunde bunu assemblye ceviren method
     *
     * @param lhs left variable - String value
     * @param rhs right variable - String value
     * @return assembly code - String value
     */
    public String syscall() {
        //Register register = new Register();
        //register.setLocation("3");
        return "syscall";
    }

    /**
     * gelen line in verilen file yazildigi method
     *
     * @param fileWriter yazilacak olan file
     * @param line filea yazilacak olan line
     */
    private void printToFile(FileWriter fileWriter, String line) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.newLine();
            bufferedWriter.append(line);
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    /**
     * gelen operatore gore evaluate yapan method
     *
     * @param op gelen operator
     * @param fileWriter yazilacagi file
     * @return evaluation yapildiktan sonraki result
     */
    public int evalOpInt(String op, FileWriter fileWriter) {
        String retMethod;

        if (register.size() < 2) {
            return -1;
        }
        int rhs = (int) variable.remove(variable.size() - 1).getValue();
        int lhs = (int) variable.remove(variable.size() - 1).getValue();
        String temp;
        temp = Integer.toString(lhs);
        int result = 0;
        // Evaluate the operator.
        switch (op) {
            case "+":
                result = lhs + rhs;
                System.out.println("Artiiiii bennnn");
                variable.add(new IntegerVeriable("int", Integer.toString(result)));
                printToFile(fileWriter, add(Integer.toString(lhs), Integer.toString(rhs)));
                break;
            case "-":
                result = lhs - rhs;
                System.out.println("Eksiiiii bennnn");
                variable.add(new IntegerVeriable("int", Integer.toString(result)));
                printToFile(fileWriter, sub(Integer.toString(lhs), Integer.toString(rhs)));
                break;
            case "/":
                result = lhs / rhs;
                System.out.println("Boluuuu bennnn");
                variable.add(new IntegerVeriable("int", Integer.toString(result)));
                printToFile(fileWriter, div(Integer.toString(lhs), Integer.toString(rhs)));
                break;
            case "*":
                result = lhs * rhs;
                System.out.println("Carpiiiii bennnn");
                variable.add(new IntegerVeriable("int", Integer.toString(result)));
                printToFile(fileWriter, multi(Integer.toString(lhs), Integer.toString(rhs)));
                break;
            case "=":
                lhs = rhs;
                result = lhs;
                System.out.println("Assignmentim bennnn");

                variable.add(new IntegerVeriable("int", temp));
                variable.get(searchVeriable(temp)).setValue(result);
                register.get(searchVeriable(temp)).getVeriable().setValue(result);

                retMethod = li(temp, Integer.toString(rhs));
                printToFile(fileWriter, retMethod);
        }
        /*
        variable.get(searchVeriable(temp)).setValue(result);
        register.get(searchVeriable(temp)).getVeriable().setValue(result);
         */

        //  register.get(searchVeriable(temp)).getVeriable().setValue(result);
        return result;
    }
}
