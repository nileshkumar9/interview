package com.interview.stack;

import java.util.Stack;

/**
 * https://www.interviewbit.com/problems/redundant-braces/
 * Given a string A denoting an expression. It contains the following operators ’+’, ‘-‘, ‘*’, ‘/’.
 *
 * Chech whether A has redundant braces or not.
 *
 * Return 1 if A has redundant braces, else return 0.
 *
 * Note: A will be always a valid expression.
 *
 *
 *
 *
 * Input Format
 *
 * The only argument given is string A.
 * Output Format
 *
 * Return 1 if string has redundant braces, else return 0.
 * For Example
 *
 * Input 1:
 *     A = "((a + b))"
 * Output 1:
 *     1
 *     Explanation 1:
 *         ((a + b)) has redundant braces so answer will be 1.
 *
 * Input 2:
 *     A = "(a + (a + b))"
 * Output 2:
 *     0
 *     Explanation 2:
 *         (a + (a + b)) doesn't have have any redundant braces so answer will be 0.
 *
 * Logic : Keep pushing it into the stack until we encounter the closing brackets.
 * When closing bracket is encountered , check if the peek is not the immediate opening, if immediate opening means there was
 * no operator/operands in between and its redundant.
 * Keep poping till we reach the matching opening bracket.
 * Also check there mush be atleast one operator present between opening and closing brackets (a) is invalid.
 *
 */
public class RedundantBraces {
    //Return 1 if string has redundant braces, else return 0.
    static public int braces(String A) {
        // Create stack
        Stack<Character> st = new Stack<>();

        // Iterator over the String
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if (ch == ')') {
                // when its a closing brackets, it means pop till we have opening brackets
                // Also check that there is not a opening bracket at the peek,
                // Because in case of balanced one we must have something in between brackets else its a duplicacy
                // case where there is no content in between brackets
                if (st.peek() == '(') {
                    // its redundant as the stack is containing opening bracket without any operators or operands
                    return 1;
                }
                boolean hasOperators = false;

                while (st.size() > 0 && st.peek() != '(') // Otherwise keep on poping unitl you find the opening brackets
                {
                    if(st.peek() == '+' || st.peek() == '-' || st.peek() == '*' || st.peek() == '/' ){
                        hasOperators = true;
                    }
                    st.pop();
                }
                // pop the opening brackets as well as the while loop will pop till the '(' but not the operning brackets
                st.pop();
                // if there was not any operator that means it was redundant (a)
                if(hasOperators != true){
                    return 1;
                }
            } else {
                // push to stack always when there is opening bracket of any operator or digit
                st.push(ch);
            }
        }

        return 0;


    }

    public static void main(String[] args) {
        String A = "(a+(a+b))";
        int result = braces(A);

        System.out.println(result);

    }
}
