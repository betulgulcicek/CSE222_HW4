/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse222_hw4_101044025_betul_gulcicek;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 *
 * @author BETUL
 * 
 * Koffman &  Wolfgang   -    PostfixEvaluator Class
 */
public class PostfixEvaluator {

    public static class SyntaxErrorException
            extends Exception {

        SyntaxErrorException(String message) {
            super(message);
        }
    }

    PostfixEvaluator() {
    }
    // Constant
    /**
     * A list of operators.
     */
    private static final String OPERATORS = "+-*/";
    // Data Field
    /**
     * The operand stack.
     */
    private Stack<Integer> operandStackInt;

    // Methods
    /**
     * Evaluates the current operation. This function pops the two operands off
     * the operand stack and applies the operator.
     *
     * @param op A character representing the operator
     * @return The result of applying the operator
     * @throws EmptyStackException if pop is attempted on an empty stack
     */
    private int evalOpInt(char op) {
        // Pop the two operands off the stack.
        int rhs = operandStackInt.pop();
        int lhs = operandStackInt.pop();
        int result = 0;
        // Evaluate the operator.
        switch (op) {
            case '+':
                result = lhs + rhs;
                break;
            case '-':
                result = lhs - rhs;
                break;
            case '/':
                result = lhs / rhs;
                break;
            case '*':
                result = lhs * rhs;
                break;

        }
        return result;
    }

    /**
     * Determines whether a character is an operator.
     *
     * @param op The character to be tested
     * @return true if the character is an operator
     */
    private boolean isOperator(char ch) {
        return OPERATORS.indexOf(ch) != -1;
    }

    /**
     * Evaluates a postfix expression.
     *
     * @param expression The expression to be evaluated
     * @return The value of the expression
     * @throws SyntaxErrorException if a syntax error is detected
     */
    public Integer evalInt(String expression) throws SyntaxErrorException {
        // Create an empty stack.
        operandStackInt = new Stack<Integer>();

       // System.out.println(expression); /////////////////////////////////////////////////////////
        // Process each token.
        StringTokenizer tokens = new StringTokenizer(expression);
        try {
            while (tokens.hasMoreTokens()) {
                String nextToken = tokens.nextToken();
                // Does it start with a digit?
                if (Character.isDigit(nextToken.charAt(0))) {
                    // Get the integer value.
                    int value = Integer.parseInt(nextToken);
                   // System.out.println("Value : " + value);
                    // Push value onto operand stack.
                    operandStackInt.push(value);
                } // Is it an operator?
                else if (isOperator(nextToken.charAt(0))) {
                    // Evaluate the operator.
                    int result = evalOpInt(nextToken.charAt(0));
                    // Push result onto the operand stack.
                    operandStackInt.push(result);
                } else {
                    // Invalid character.
                    throw new SyntaxErrorException("Invalid character encountered");
                }
               // System.out.printf(nextToken, " ");            /////////////////////////////////////////////////////////
            } // End while.

            // No more tokens - pop result from operand stack.
            int answer = operandStackInt.pop();
            // Operand stack should be empty.
            if (operandStackInt.empty()) {
                return answer;
            } else {
                // Indicate syntax error.
                throw new SyntaxErrorException(
                        "Syntax Error: Stack should be empty");
            }
        } catch (EmptyStackException ex) {
            // Pop was attempted on an empty stack.
            throw new SyntaxErrorException("Syntax Error: The stack is empty");
          //   System.out.println("Syntax Error: The stack is empty" + ex.getMessage());
        }
    }
}
